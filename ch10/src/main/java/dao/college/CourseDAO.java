package dao.college;


import java.util.List;

import dto.college.CourseDTO;
import util.DBHelper;

public class CourseDAO extends DBHelper{
	
	private static final CourseDAO INSTANCE = new CourseDAO();
	public static CourseDAO getInstance() {
		return INSTANCE;
	}
	private CourseDAO() {}
	
	private final String DBCP = "jdbc/college";
	
	public void insertCourse(CourseDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public CourseDTO selectCourse(String stdNo) {
		
		try {
				conn = getConnection(DBCP);
				
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<CourseDTO> selectAllCourse(){
		
		try {
			conn = getConnection(DBCP);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void updateCourse(CourseDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCourse(String stdNo) {
		
		try {
			conn = getConnection(DBCP);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
