package controller.college.course;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.CourseDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.CourseService;

@WebServlet("/college/course/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// 서비스 객체 가져오기
	private CourseService service = CourseService.INSTANCE;
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/college/course/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cs_id = req.getParameter("cs_id");
		String cs_name = req.getParameter("cs_name");
		String cs_credit = req.getParameter("cs_credit");
		String cs_dept = req.getParameter("cs_dept");
		
		CourseDTO dto = new CourseDTO();
		
		dto.setCs_id(cs_id);
		dto.setCs_name(cs_name);
		dto.setCs_credit(cs_credit);
		dto.setCs_dept(cs_dept);
		
		logger.info(dto.toString());
		
		service.register(dto);
		
		resp.sendRedirect("/ch10/college/course/list.do");
		
		
	}

}
