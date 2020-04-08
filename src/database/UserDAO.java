package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;



public class UserDAO {
	
		// 드라이버 로드
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 컨넥션
		public Connection getConnection() {
			Connection con = null;
			
			//커넥션 연결
			String url = "jdbc:mysql://localhost:3306/javadb?useSSL=false&serverTimezone=UTC";
			String user = "javadb";
			String password = "12345";
			
			try {
				con=DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return con;
		}
		
		//전체 리스트 가져오기
		public Vector<UserVO> getList(){
			Vector<UserVO> vecList = new Vector<UserVO>();
			
			String sql = "select * from userTBL";
			
			try(Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()) {
				
				
				while(rs.next()){
					UserVO vo = new UserVO();
					vo.setNo(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setBirthday(rs.getDate(3));
					vo.setAddress(rs.getString(4));
					vecList.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return vecList;
		}
		
		
}
