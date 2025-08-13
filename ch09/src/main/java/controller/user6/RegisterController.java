package controller.user6;

import java.io.IOException;

import dto.User6DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User6Service;

@WebServlet("/user6/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// service 싱글톤 객체 가져오기
	private User6Service service = User6Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user6/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		// 서비스 전달을 위해 DTO 생성
		User6DTO dto = new User6DTO();
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		// 서비스 요청
		service.register(dto);
		
		// 이동
		resp.sendRedirect("/ch09/user6/list.do");
		
	}

}
