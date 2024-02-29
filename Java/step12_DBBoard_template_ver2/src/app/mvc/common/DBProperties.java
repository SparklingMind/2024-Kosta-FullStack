package app.mvc.common;
/**
 * DB의 설정 정보들 상수로 관리
 * */
public interface DBProperties {
  public static final String DRVIER_NAME="oracle.jdbc.driver.OracleDriver";
   String URL="jdbc:oracle:thin:@127.0.0.1:1521:xe";
   String USER_ID="scott";
   String USER_PASS="TIGER";
   
}
