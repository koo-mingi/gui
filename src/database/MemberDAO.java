package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;

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
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
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
	public Vector<MemberVO> getList(){
		Vector<MemberVO> vecList = new Vector<MemberVO>();
		
		String sql = "select * from memberTBL";
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString(4));
				vecList.add(vo);
			}
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vecList;
	}
	
	public int insert(MemberVO vo) {
		
		int result=0;
		String sql = "insert into memberTBL values(member_seq.nextval,?,?,?)";
		
		try (Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			//preparedStatement : 서버로 쿼리 문장 전송
			//반복적으로 쓰이기 때문에, 캐시메모리에 저장해서 사용 및 속도 향상
			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public MemberVO getRow(int no) {
		String sql = "select * from memberTBL where no=?";
		MemberVO vo = null;
		
		try (Connection con=getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			// 넘어오는 정보를 rs객체에 담아준다. 쉽게 말해, select구문 실행 시 나오는 테이블 정보.
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) { // 여러 정보를 담아야하는 경우, while문을 돌리면 된다.
				vo=new MemberVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getNString("name"));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString("gender"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// no 값을 이용해서 회원 정보 삭제하기
	// delete from memberTBL where no=?
	public int remove(int no) {
		
		int result=0;
		String sql = "delete from memberTBL where no=?";
		
		try (Connection con=getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
