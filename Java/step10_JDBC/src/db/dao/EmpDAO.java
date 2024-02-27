package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.dto.Emp;
import db.util.DBmanager;

public class EmpDAO { // dao: data access object

	// 사원 이름을 조회하는 메소드
	public void selectByName() {
		// 데이터베이스 연결 및 SQL 쿼리 실행에 사용될 변수 초기화
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select ename from emp"; // 실행할 SQL 쿼리

		try {
			// 데이터베이스 연결
			con = DBmanager.getConnection();

			// SQL 문을 실행할 Statement 객체 생성
			st = con.createStatement();

			// 쿼리 실행 및 결과 저장
			rs = st.executeQuery(sql);

			// 결과 처리
			while (rs.next()) {
				// 현재 행의 'eNaMe' 열 값을 가져옴 (대소문자 구분 없음)
				String ename = rs.getString("eNaMe");
				System.out.println(ename); // 콘솔에 출력
			}
			System.out.println("**조회완료**");
		} catch (SQLException e) {
			// 예외 처리: SQL 관련 오류 발생 시 콘솔에 에러 메시지 출력
			e.printStackTrace();
		} finally {
			// 자원 해제: 데이터베이스 연결 및 사용한 자원을 안전하게 닫음
			DBmanager.dbClose(con, st, rs);
		}
	}

	// 모든 사원 정보를 조회하여 List로 반환하는 메소드
	public List<Emp> selectAll() {
		// 사원 정보를 저장할 리스트 생성
		List<Emp> empList = new ArrayList<>();
		// 데이터베이스 연결 및 SQL 쿼리 실행에 사용될 변수 초기화
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp"; // 실행할 SQL 쿼리

		try {
			// 데이터베이스 연결
			con = DBmanager.getConnection();

			// SQL 문을 실행할 Statement 객체 생성
			st = con.createStatement();

			// 쿼리 실행 및 결과 저장
			rs = st.executeQuery(sql);

			// 결과 처리
			while (rs.next()) {
				// Emp 객체를 생성하고 결과집합에서 읽은 값으로 초기화
				Emp emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("sal"),
						rs.getString("hiredate"));
				// 생성된 Emp 객체를 리스트에 추가
				empList.add(emp);
			}
		} catch (Exception e) {
			// 예외 처리: 오류 발생 시 콘솔에 에러 메시지 출력
			e.printStackTrace();
		} finally {
			// 자원 해제: 데이터베이스 연결 및 사용한 자원을 안전하게 닫음
			DBmanager.dbClose(con, st, rs);
		}
		return empList; // 조회 결과를 담은 리스트 반환
	}

	/**
	 * 사원번호에 해당하는 사원 정보를 검색
	 */
	public Emp selectByEmpno(int empno) { // 사원 번호를 기준으로 한 사원 정보를 조회하므로, 조회 결과는 최대 한 개의 Emp 객체

		Emp emp = null; // 결과를 저장할 Emp 객체 초기화. 검색 결과가 없을 경우 null을 유지
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp where empno = " + empno; // 실행할 SQL 쿼리
		try {
			con = DBmanager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) { // 결과가 존재하면 Emp 객체 생성
				emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("sal"),
						rs.getString("hiredate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 해제: 데이터베이스 연결 및 사용한 자원을 안전하게 닫음
			DBmanager.dbClose(con, st, rs);
		}
		return emp; // 조회된 사원 정보가 담긴 Emp 객체 반환 (검색 결과가 없다면 null 반환)
	}

	/**
	 * 사원등록
	 */
	public int insert(Emp emp) {
		Connection con = null;
		Statement st = null;
		int result = 0;
		// SQL 쿼리 작성, 문자열 값은 따옴표(')로 감싸야 함
		String sql = "insert into emp(empno, ename, job, sal, hiredate) values (" + emp.getEmpno() + ", '"
				+ emp.getEname() + "', '" + emp.getJob() + "', " + emp.getSal()
				+ ",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          )";

		try {
			con = DBmanager.getConnection(); // 데이터베이스 연결
			st = con.createStatement(); // Statement 객체 생성
			result = st.executeUpdate(sql); // SQL 실행, 삽입된 행의 수 반환
			System.out.println("SQL 실행 결과: " + result);
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
		} finally {
			DBmanager.dbClose(con, st); // 자원 해제
		}
		return result; // 삽입 결과 반환
	}

	/**
	 * 사원등록
	 */
	public int preparedInsert(Emp emp) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int result = 0;
	    // PreparedStatement를 사용하는 SQL 쿼리
	    String sql = "insert into emp(empno, ename, job, sal, hiredate) values (?, ?, ?, ?, sysdate)";

	    try {
	        con = DBmanager.getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, emp.getEmpno());
	        ps.setString(2, emp.getEname());
	        ps.setString(3, emp.getJob());
	        ps.setInt(4, emp.getSal());
	        // SQL 실행
	        result = ps.executeUpdate(); // 수정됨
	        System.out.println("SQL 실행 결과: " + result);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBmanager.dbClose(con, ps);
	    }
	    return result;
	}

}
