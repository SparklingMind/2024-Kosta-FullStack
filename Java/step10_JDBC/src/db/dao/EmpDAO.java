package db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.util.DBmanager;

public class EmpDAO {	//dao: data access object
	/**
	 * emp테이블에서 사원의 이름 검색하기
	 * 	:select ename from emp
	 */
	public void selectByName() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select ename from emp";
		try {
		//로드 
		//연결
		con = DBmanager.getConnection();
		
		//실행
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			//열을 조회
			String ename = rs.getString("eNaMe");
			System.out.println(ename);
		}
		
		System.out.println("**조회완료**");
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
		//닫기
			DBmanager.dbClose(con, st, rs);
		}
	}
}
