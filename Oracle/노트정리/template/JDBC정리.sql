JDBC API
- IMPORT JAVA.SQL;

DB ���� ����
1) �ε� - �����Ϸ��� �����ͺ��̽� ��ǰ ����(�� ��  DB�� DERVIER-JAR) ã�´�.

2) ���� - �����ͺ��̽��� �������� �����ϴ� ��(URL, USER,PASSWORD �ʿ�)

3 )���� - CRUD���� ����

4 0 -���� ��ü�� �ݳ�(close�Ѵ�.)
-------------------------------------------------------
1) �ε�
    Class.ForName("�����Ϸ��� ����̹���");
    _:����̹����� �����̰ų� ~jar�� ������ ClassNotFoundExceptioin �߻�
    
2) ����
    Connection CON = DriverManager.getConnection(String url, String user, String pass);
    
3) ����
    1.Statement ���
    2.PreparedStatment ��� -����(Statement�� ���)
    
    1�� ��� - Statement ���
        Statemnet st=con.createStatement();
        *DDL, DML�� ���
        int result = st.executeUpdate(String sql);
        -��� result�� 0�̸� ����, 1 �̻��̸� ����/ ������������, ��������, ���������̸� SQLexception �߻�
        *select ����
        
        
        
    2�� ��� - PreparedStatment ���
    PreparedStatment ps = con.prepareStatement(String sql);
    ex) Result rs = st.executeQuery("select empno, ename, sal from emp");
    
    boolean b = rs.next(); //Ŀ���� �� �� ������ �̵�
   
   List <Emp> list = new ArrayList<>();
    while(rs.next()){ //������ Ŀ���� �̵��Ѵٸ�
        //���� �̵��ϸ鼭 ������ ��ȸ - getType(�÷���)
        int empno = rs.getInt("empno"); //1
        String ename = rs.getString("ename"); //2
        int sal = rs.getInt(3); //3
        Emp emp =  new Emp(empno, ename, sal);
        list.add(emp);
    }
    