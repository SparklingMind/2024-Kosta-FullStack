package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.dto.Emp;
import db.util.DBmanager;

public class SqlInjectionTest {

	/**
	 * Statement인경우 select empno, ename,job, sal, hiredate from emp where sal >
	 * '2000'
	 */
	public static void statementTest(String param) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select empno, ename,job, sal, hiredate from emp where sal > " + param + " order by sal";
		try {
			con = DBmanager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Emp emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

				System.out.println(emp);// emp.toString()
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.dbClose(con, st, rs);
		}
	}

	/**
	 * PreparedStatement인경우 select empno, ename,job, sal, hiredate from emp where
	 * sal > '2000'
	 */
	public static void preparedStatementTest(String param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno, ename,job, sal, hiredate from emp where sal > ? order by sal";
		try {
			con = DBmanager.getConnection();
			ps = con.prepareStatement(sql);
			// ?의 값 설정 필요
			ps.setString(1, param);

			rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

				System.out.println(emp);// emp.toString()
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBmanager.dbClose(con, ps, rs);
		}
	}

	public static void main(String[] args) {
	    // Statement 사용 예제
	    System.out.println("--1. Statement 경우-------------- ");
	    // SQLInjection 공격에 취약함. 사용자 입력이 쿼리에 직접 결합되어 실행되므로,
	    // 악의적인 입력값("5000 or 1 = 1")이 조건을 항상 참으로 만들어 모든 데이터를 반환할 수 있음.
//	    statementTest("2000"); // 안전한 사용 예시
//	    statementTest("5000 or 1 =1"); // SQL 인젝션 공격 예시

	    // PreparedStatement 사용 예제
	     System.out.println("\n--2. PreparedStatement 경우 ------------");
	    // SQLInjection을 방어할 수 있음. 사용자 입력값을 파라미터로 받아 처리하기 때문에,
	    // 악의적인 입력이 쿼리의 구조를 변경할 수 없음. "?" 플레이스홀더를 사용하여 쿼리를 사전에 컴파일하고,
	    // 실행 시 파라미터 값을 안전하게 삽입함.
//	    preparedStatementTest("2000"); // 안전한 사용 예시
//	    preparedStatementTest("2000 or 1 =1"); // PreparedStatement를 사용하면 이러한 입력도 안전하게 처리됨.
	}

}
