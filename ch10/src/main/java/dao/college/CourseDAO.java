package dao.college;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.CourseDTO;
import util.DBHelper;

public class CourseDAO extends DBHelper{
	
	private static final CourseDAO INSTANCE = new CourseDAO();
	
	public static CourseDAO getInstance() {
		return INSTANCE;
	}
	private CourseDAO() {}
	
	private final String DBCP = "jdbc/college";
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertCourse(CourseDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO COURSE VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCs_id());
			psmt.setString(2, dto.getCs_name());
			psmt.setInt(3, dto.getCs_credit());
			psmt.setString(4, dto.getCs_dept());
			psmt.executeUpdate();
			closeAll();
			
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}		
	}
	
	public CourseDTO selectCourse(String cs_id) {
		
		CourseDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM COURSE WHERE CS_ID=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cs_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CourseDTO();
				dto.setCs_id(rs.getString(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getInt(3));
				dto.setCs_dept(rs.getString(4));				
			}
			closeAll();
			
		}catch (Exception e) {
			// e.printStackTrace();
			logger.error(e.getMessage());
		}
		return dto;
	}
	
	public List<CourseDTO> selectAllCourse() {
		
		List<CourseDTO> dtoList = new ArrayList<CourseDTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM COURSE";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CourseDTO dto = new CourseDTO();
				dto.setCs_id(rs.getString(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getInt(3));
				dto.setCs_dept(rs.getString(4));
				
				dtoList.add(dto);				
			}
			closeAll();
			
		}catch (Exception e) {
			// e.printStackTrace();
			logger.error(e.getMessage());
		}
		return dtoList;
		
	}
	
	public void updateCourse() {}
	
	public void deleteCourse() {}
	

}
