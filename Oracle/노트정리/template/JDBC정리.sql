JDBC API
- IMPORT JAVA.SQL;

DB 연동 순서
1) 로드 - 접속하려는 데이터베이스 제품 선택(이 때  DB에 DERVIER-JAR) 찾는다.

2) 연결 - 데이터베이스의 계정으로 접속하는 것(URL, USER,PASSWORD 필요)

3 )실행 - CRUD문장 실행

4 0 -사용된 객체를 반납(close한다.)
-------------------------------------------------------
1) 로드
    Class.ForName("연결하려는 드라이버명");
    _:드라이버명이 오류이거나 ~jar가 없으면 ClassNotFoundExceptioin 발생
    
2) 연결
    Connection CON = DriverManager.getConnection(String url, String user, String pass);
    
3) 실행
    1.Statement 방식
    2.PreparedStatment 방식 -권장(Statement를 상속)
    
    1의 경우 - Statement 방식
        Statemnet st=con.createStatement();
        *DDL, DML인 경우
        int result = st.executeUpdate(String sql);
        -결과 result가 0이면 실패, 1 이상이면 성공/ 제약조건위배, 길이제한, 쿼리오류이면 SQLexception 발생
        *select 전용
        
        
        
    2의 경우 - PreparedStatment 방식
    PreparedStatment ps = con.prepareStatement(String sql);
    ex) Result rs = st.executeQuery("select empno, ename, sal from emp");
    
    boolean b = rs.next(); //커서를 한 행 앞으로 이동
   
   List <Emp> list = new ArrayList<>();
    while(rs.next()){ //앞으로 커서가 이동한다면
        //열을 이동하면서 데이터 조회 - getType(컬럼명)
        int empno = rs.getInt("empno"); //1
        String ename = rs.getString("ename"); //2
        int sal = rs.getInt(3); //3
        Emp emp =  new Emp(empno, ename, sal);
        list.add(emp);
    }
    