package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User7DTO;

public class User7DAO {
	
	// DAO 는 기본 싱글톤
	private final static User7DAO INSTANCE = new User7DAO();
	public static User7DAO getInstance() {
		return INSTANCE;
	}
	
	public User7DAO() {}
	
	// 기본 CRUD 메서드
	public void insertUser7(User7DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "INSERT INTO USER7 VALUES(?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getEmail());
			
			psmt.executeUpdate();
			
			conn.close();
			psmt.close();
								
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public User7DTO selectUser7(String id) {
		
		User7DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM USER7 WHERE id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User7DTO();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getString(3));
				dto.setEmail(rs.getString(4));				
			}
			conn.close();
			psmt.close();
			rs.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
		
	public List<User7DTO> selectAllUser7() {
		
		List<User7DTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) InitialContext.doLookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER7";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User7DTO dto = new User7DTO();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getString(3));
				dto.setEmail(rs.getString(4));
				
				dtoList.add(dto);				
			}
			conn.close();
			stmt.close();
			rs.close();		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;		
	}
	
	public void updateUser7(User7DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "UPDATE USER7 SET name=?, age=?, email=? WHERE id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getId());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser7(String id) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "DELETE FROM USER7 WHERE id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
					
			
		}catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
}
