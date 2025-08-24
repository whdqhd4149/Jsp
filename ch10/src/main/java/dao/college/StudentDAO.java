package dao.college;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper{
	
	private static final StudentDAO INSTANCE = new StudentDAO();
	
	public static StudentDAO getInstance() {
		return INSTANCE;
	}
	private StudentDAO() {}
	
	private final String DBCP = "jdbc/college";
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	
	public void insertStudent(StudentDTO dto) {
		
		try {
			conn = getConnection(DBCP);
				
			String sql = "INSERT INTO STUDENT VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStdno());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getMajor());
			psmt.setString(5, dto.getEnr_date());
			psmt.executeUpdate();
			closeAll();
			
		}catch(Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}			
	}
	
	public StudentDTO selectStudent(String stdno) {
		
		StudentDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
				
			String sql = "SELECT * FROM STUDENT WHERE STDNO=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdno);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setStdno(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(rs.getString(5));
			}
			closeAll();
		}catch(Exception e) {
			//e.printStackTrace();	
			logger.error(e.getMessage());
		}
		
		return dto;
	}
	
	public List<StudentDTO> selectAllStudent(){
		
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM STUDENT";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStdno(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(rs.getString(5));
				
				dtoList.add(dto);			
			}
			closeAll();
			
		}catch(Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return dtoList;			
	}
	
	public void updateStudent(StudentDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE STUDENT SET name=?, birth=?, major=?, enr_date=? WHERE stdno=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBirth());
			psmt.setString(3, dto.getMajor());
			psmt.setString(4, dto.getEnr_date());
			psmt.setString(5, dto.getStdno());
			
			psmt.executeUpdate();
			
			closeAll();
			
			
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	
	public void deleteStudent(String stdNo) {
		
		try {
				conn = getConnection(DBCP);
				
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
			
}
