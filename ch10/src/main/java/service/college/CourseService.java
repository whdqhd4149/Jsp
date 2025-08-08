package service.college;

import java.util.List;

import dao.college.CourseDAO;
import dto.college.CourseDTO;

public enum CourseService {
	
	INSTANCE;
	
	private CourseDAO dao = CourseDAO.getInstance();
	
	public void register(CourseDTO dto) {
		dao.insertCourse(dto);	
	}
	
	public CourseDTO findById(String stdNo) {
		return dao.selectCourse(stdNo);
	}
	
	public List<CourseDTO> findAll(){
		return dao.selectAllCourse();				
	}
	
	public void modify(CourseDTO dtd) {
		dao.updateCourse(dtd);
	}
	
	public void delete(String stdNo) {
		dao.deleteCourse(stdNo);
	}
}
