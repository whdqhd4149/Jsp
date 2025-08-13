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

import dto.User6DTO;

public class User6DAO {
	
	// DAO는 기본 싱글톤
	private final static User6DAO INSTANCE = new User6DAO();
	public static User6DAO getInstance() {
		return INSTANCE;
	}

	
	private User6DAO() {}
	
	// 기본 CRUD 메서드
	public void insertUser6(User6DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "INSERT INTO USER6 VALUES (?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public User6DTO selectUser6(String name) {
		
		User6DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM USER6 WHERE name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User6DTO();
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getString(3));
				dto.setAddr(rs.getString(4));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	public List<User6DTO> selectAllUser6() {
		
		List<User6DTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER6";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User6DTO dto = new User6DTO();
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getString(3));
				dto.setAddr(rs.getString(4));
				
				dtoList.add(dto);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
		
	}
	
	public void updateUser6(User6DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "UPDATE USER6 SET gender=?, age=?, addr=? WHERE name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getGender());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getName());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
						
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public void deleteUser6(String name) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "DELETE FROM USER6 WHERE name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
