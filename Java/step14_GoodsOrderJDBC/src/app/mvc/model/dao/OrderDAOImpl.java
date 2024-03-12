package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.mvc.model.dto.Goods;
import app.mvc.model.dto.OrderLine;
import app.mvc.model.dto.Orders;
import app.mvc.util.DBManager;

//데이터베이스와의 상호작용을 담당하는 클래스. DAO(Data Access Object)는 데이터베이스의 데이터에 접근하기 위한 객체이다.
public class OrderDAOImpl implements OrderDAO {
 
 // GoodsDAO의 인스턴스. GoodsDAO는 상품 데이터에 접근하기 위한 객체이다.
 GoodsDAO goodsDao = new GoodsDAOImpl();
 
 /**
  * 주문을 데이터베이스에 저장하는 메소드.
  * - Connection: 데이터베이스 연결을 관리하는 객체.
  * - PreparedStatement: SQL 문을 표현하고 실행하는 객체. SQL 인젝션 공격을 방지할 수 있다.
  * - SQLException: SQL 처리 중 발생하는 예외를 처리하는 클래스.
  */
 @Override
 public int orderInsert(Orders order) throws SQLException {
     Connection con = null;
     PreparedStatement ps = null;
     // SQL 문에서 ORDER_ID_SEQ.NEXTVAL은 주문 ID 시퀀스의 다음 값을 가져온다.
     String sql = "INSERT INTO ORDERS(ORDER_ID, ORDER_DATE, USER_ID, ADDRESS, TOTAL_AMOUNT)" + 
                 " VALUES(ORDER_ID_SEQ.NEXTVAL, sysdate, ?, ?, ?)";
     int result = 0;
     try {
         con = DBManager.getConnection(); // DBManager를 통해 데이터베이스 연결을 가져온다.
         con.setAutoCommit(false); // 트랜잭션 시작. 자동 커밋을 비활성화한다.
         
         ps = con.prepareStatement(sql); // SQL 문을 준비한다.
         ps.setString(1, order.getUserId()); // 사용자 ID 설정
         ps.setString(2, order.getAddress()); // 배송 주소 설정
         ps.setInt(3, this.getTotalAmount(order)); // 총 구매 금액 계산
         
         result = ps.executeUpdate(); // SQL 문 실행
         if (result == 0) {
             con.rollback(); // 실패 시 롤백
             throw new SQLException("주문 실패...");
         } else {
             // 주문 성공 시 추가 작업
             int[] re = this.orderLineInsert(con, order); // 주문 상세 정보 등록
             for (int i : re) {
                 if (i != 1) {
                     con.rollback();
                     throw new SQLException("주문할 수 없습니다...");
                 }
             }
             
             // 재고 감소 처리
             this.decrementStock(con, order.getOrderLineList()); 
             con.commit(); // 모든 작업 성공 시 커밋
         }
     } finally {
         DBManager.close(con, ps, null); // 리소스 해제
     }
     
     return result;
 }
	
	/**
	 * 주문 상세 정보를 데이터베이스에 저장하는 메소드. 주문할 때마다 주문 상세 정보도 함께 저장된다.
	 * */
	public int[] orderLineInsert(Connection con  , Orders order) throws SQLException{
		
		  PreparedStatement ps=null;
		  String sql="insert into order_line(order_line_id,order_id, goods_id,unit_price, qty, amount)" + 
		  		"  values(ORDER_LINE_ID_SEQ.nextval ,ORDER_ID_SEQ.currval , ?, ? , ? , ? )";
		  int result [] =null;
		 try {
			 ps = con.prepareStatement(sql);
			 
		  for( OrderLine orderline : order.getOrderLineList() ) {
			 Goods goods = goodsDao.goodsSelectBygoodsId(orderline.getGoodsId());
			  
			   ps.setString(1, orderline.getGoodsId()); //상품코드
			   ps.setInt(2, goods.getGoodsPrice());//가격
			   ps.setInt(3, orderline.getQty());//총구매금액
			   ps.setInt(4,  goods.getGoodsPrice()*orderline.getQty());//총구매금액
			   ps.addBatch(); //addBatch는 일괄처리를 위한 메소드 -> 라인을 쌓아 놓고 한번에 처리
			   ps.clearParameters(); //물음표에 바인딩된 부분을 초기화하여 다음 작업을 준비
		  }
		  
		  result = ps.executeBatch();//일괄처리
		  
		   
    }finally {
    	DBManager.close(null, ps , null);
    }
		
		return result;
		
	}
	
	/**
	 * 주문한 상품의 재고를 감소시키는 메소드. 주문 수량만큼 재고를 감소시킨다.
	 * */
	public int[] decrementStock(Connection con , List<OrderLine> orderLineList)throws SQLException {
		 PreparedStatement ps=null;
		  String sql="update goods set stock = stock-? where goods_id=?";
		  int result [] =null;
		 try {
		  ps = con.prepareStatement(sql);
		  for( OrderLine orderline : orderLineList ) {
			   ps.setInt(1, orderline.getQty());
			   ps.setString(2, orderline.getGoodsId());
			   
			   ps.addBatch(); //일괄처리할 작업에 추가
			   ps.clearParameters();
		  }
		  
		  
		  result = ps.executeBatch();//일괄처리
		 }finally {
			 DBManager.close(null, ps, null);
		 }
		
		return result;
	}
	
	/**
	 * 주문한 상품의 총 금액을 계산하는 메소드. 각 상품의 가격과 수량을 곱한 뒤, 총합을 구한다.
	 * */
	public int getTotalAmount(Orders order) throws SQLException { //상품가격 , 수량
		List<OrderLine> orderLineList= order.getOrderLineList();
	    int total=0;
		for(OrderLine line : orderLineList) {
			Goods goods =goodsDao.goodsSelectBygoodsId(line.getGoodsId());//상품에해당하는 정보 검색
			
			if(goods==null)throw new SQLException("상품번호 오류입니다.... 주문 실패..");
			else if(goods.getStock() <  line.getQty())throw new SQLException("재고량 부족입니다...");
			
	    	total += line.getQty() * goods.getGoodsPrice() ; //주문수량 * 가격
	    }
		return total;
	}
	
	/**
	 * 특정 사용자의 주문 내역을 조회하는 메소드. 사용자 ID를 기반으로 모든 주문 내역을 가져온다.
	 * */
	public List<Orders> selectOrdersByUserId(String userId)throws SQLException{
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<Orders> list = new ArrayList<>();
		 try {
		   con = DBManager.getConnection();
		   ps= con.prepareStatement("select * from orders where user_id=? order by order_id desc");
		   ps.setString(1, userId);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	Orders orders  = new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
	        	
	        	//주문번호에 해당하는 상세정보 가져오기
	        	List<OrderLine> orderLineList = selectOrderLine(orders.getOrderId());//메소드 호출
	        	
	        	orders.setOrderLineList(orderLineList);
	        	
	        	list.add(orders);
	        }
    }finally {
    	DBManager.close(con, ps, rs);
    }
		return list;
		
	}
	
	/**
	 * 주문 번호에 해당하는 주문 상세 정보를 조회하는 메소드. 주문 번호로 주문된 모든 상품 정보를 가져온다.
	 * */
	public List<OrderLine> selectOrderLine(int orderId)throws SQLException{
		Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  List<OrderLine> list = new ArrayList<>();
		 try {
		   con = DBManager.getConnection();
		   ps= con.prepareStatement("select * from order_line where  order_id=?");
		   ps.setInt(1, orderId);
	       rs = ps.executeQuery(); 
	        
	        while(rs.next()) {
	        	OrderLine orderLine  = new OrderLine(rs.getInt(1), rs.getInt(2), 
	        			rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
	        	list.add(orderLine);
	        }
    }finally {
    	DBManager.close(con, ps, rs);
    }
		return list;
		
	}
}







