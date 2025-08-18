package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User4DTO;
import util.DBHelper;

public class User4DAO extends DBHelper{
	
	// 싱글톤
	private static final User4DAO INSTANCE = new User4DAO();
	public static User4DAO getInstance() {
		return INSTANCE;
	}
	private User4DAO() {}
	
	private final String DBCP = "jdbc/studydb";
	
	// 기본 CRUD 메서드
	public void insertUser4(User4DTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO USER4 values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getGender());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getHp());
			psmt.setString(6, dto.getAddr());
			psmt.executeUpdate();
			closeAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User4DTO selectUser4(String uid) {
		return null;
	}
	
	public List<User4DTO> selectAlluser4(){
		
		List<User4DTO> dtoList = new ArrayList<User4DTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM USER4");
			
			while(rs.next()) {
				User4DTO dto = new User4DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setHp(rs.getString(5));
				dto.setAddr(rs.getString(6));
				dtoList.add(dto);
			}
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
		
	}
	
	public void updateUser4(User4DTO dto) {
		
	}
	
	public void deleteUser4(String uid) {
		
	}

}
