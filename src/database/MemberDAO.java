package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDAO {
	//data access object
	
	//드라이버 클래스 로드
	//static 구문을 통해서 컴파일이 끝난 시점에 미리 메모리에 올릴 수가 있음
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 커넥션 연결
	public Connection getConnection() {
		Connection con = null;
		
		String url = "jdbc:oracl:thin:@localhost:1521:orcl";
		String user = "javadb";
		String password = "12345";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 데이터베이스 요청 작업
	
}
