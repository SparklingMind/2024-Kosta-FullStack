package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.util.DBmanager;

public class TransactionDAO {
  /**
   * 계좌이체 기능 구현 - 하나의 transaction으로 실행
   * 출금과 입금이 모두 성공적으로 이루어지면 트랜잭션을 커밋(commit)하여
   * 변경사항을 데이터베이스에 반영
   * 만약 중간에 오류가 발생하면, 트랜잭션을 롤백(rollback)하여
   * 모든 변경사항을 이전 상태로 되돌림.
   * */
	public void transfer(String inputAccount, String outputAccount, int money) {
		Connection con = null;
		//로드
		//연결
		//실행(2번의 update select)
		//닫기
		try {
			con = DBmanager.getConnection();	//auto commit이 기본적으로 true. => auto commit 해제 필요
			con.setAutoCommit(false);
			
			//1. 출금한다
			int result = this.withdraw(con, outputAccount, money);
			if(result==0) throw new SQLException("출금 계좌번호 오류입니다."); 
				
			
			//2. 출금이 정상하면 입금한다.
			result = this.deposit(con, inputAccount, money);
			if(result==0)throw new SQLException("입금 계좌번호 오류입니다.");
			
			//3. 입금이 정상이면 잔액확인한다. 1000원 초과인 경우는 비정상이라고 판단하기.
			if(!this.isCheckBalance(con, inputAccount)) {
				throw new SQLException("잔액이 1000원 초과입니다. 계좌이체 할 수 없습니다.");
			}
			
			//4. 잔액확인이 정상이면 commit 한다.
			con.commit();
			System.out.println("계좌이체 성공하였습니다.");
		}catch (SQLException e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println(e.getMessage());	//=>출금계좌번호 오류입니다.
		}finally {
			DBmanager.dbClose(con, null);
		}
	}
	/**
	 * 출금하기
	 * sql문 : update bank set balance=balane-인출금액 where account = 출금계좌번호;
	 **/
	public int withdraw(Connection con, String outputAccount, int money) throws SQLException {
	    PreparedStatement ps = null;
	    String sql = "update bank set balance = balance - ? where account = ?";
	    try {
	      ps = con.prepareStatement(sql); // SQL문 준비
	      ps.setInt(1, money);
	      ps.setString(2, outputAccount);
	      return ps.executeUpdate(); // SQL 실행 및 결과 반환
	    } finally {
	      DBmanager.dbClose(null, ps); // 리소스 정리
	    }
	  }
	/**
	 * 입금하기
	 * sql문 : update bank set balance=balance+인출금액 where account =입금계좌번호;
	 **/
	public int deposit(Connection con, String inputAccount, int money) throws SQLException {
	    PreparedStatement ps = null;
	    String sql = "update bank set balance = balance + ? where account = ?";
	    try {
	      ps = con.prepareStatement(sql); // SQL문 준비
	      ps.setInt(1, money);
	      ps.setString(2, inputAccount);
	      return ps.executeUpdate(); // SQL 실행 및 결과 반환
	    } finally {
	      DBmanager.dbClose(null, ps); // 리소스 정리
	    }
	  }
	
	/**
	 * 잔액확인 
	 * sql문 : select balance from bank where account='?';
	 * @return true이면 잔액이 1000원 이하, false이면 잔액이 1000원 초과 또는 계좌 정보가 없음
	 **/
	public boolean isCheckBalance(Connection con, String inputAccount) throws SQLException {
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "select balance from bank where account = ?";
	    try {
	        ps = con.prepareStatement(sql); // SQL문 준비
	        ps.setString(1, inputAccount);
	        
	        rs = ps.executeQuery(); // SQL 실행 및 결과 집합 반환
	        if (rs.next()) {
	            int balance = rs.getInt("balance");
	            // 잔액이 1000원 이하인 경우 true 반환, 1000원 초과면 false 반환
	            return balance <= 1000;
	        } else {
	            // 계좌 정보가 없는 경우 false 반환
	            return false;
	        }
	    } finally {
	        DBmanager.dbClose(con, ps, rs); // 리소스 정리
	    }
	}
	
	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
//		System.out.println("--1. 출금계좌 오류 예시----");
//		dao.transfer("A02", "A05",200);//입금, 출금, 금액
		
		//System.out.println("--2. 입금계좌 오류 예시----");
		//dao.transfer("A04", "A01",200);//입금, 출금, 금액
		
		
//		System.out.println("--3. 입금계좌의 총액 1000원 이상인 경우----");
//		dao.transfer("A02", "A01",700);//입금, 출금, 금액
		
		System.out.println("--4. 성공------");
		dao.transfer("A02", "A01",100);//입금, 출금, 금액
	}
}	
//transaction 끝.












