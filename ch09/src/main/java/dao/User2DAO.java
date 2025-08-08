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

import dto.User2DTO;

public class User2DAO {
	
	private final static User2DAO INSTANCE = new User2DAO();
	
	public static User2DAO getInstance() {
		return INSTANCE;		
	}
	private User2DAO() {}
	
	public void insertUser2(User2DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "INSERT INTO USER2 VALUES (?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public User2DTO selectUser2(String user_id) {
		
		User2DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM USER2 WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User2DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));				
			}
			rs.close();
			psmt.close();
			conn.close();
						
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	public List<User2DTO> selectAllUser2(){
		
		List<User2DTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER2";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User2DTO dto = new User2DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
				
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
	
	public void updateUser2(User2DTO dto) {
		
		try {
			Context ctx =  (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "UPDATE USER2 name=?, hp=?, age=? WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void deleteUser2(String user_id) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whdqhd4149");
			
			Connection conn = ds.getConnection();
			
			String sql = "DLELTE FROM USER2 WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
