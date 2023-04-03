package kb.common;

/*
 * DB의 설정 정보들을 상수로 관리
 */

public interface DBproperties {
	String Driver_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	String USER_ID = "system";
	String USER_PASS = "system";
}
