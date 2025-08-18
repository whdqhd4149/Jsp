package controller.user5;

import java.io.IOException;

import dto.User5DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private User5Service service = User5Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user5/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 폼 입력 데이터 수신
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		// DTO 생성
		User5DTO dto = new User5DTO();
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		// 서비스 호출
		service.register(dto);
		
		// 목록 이동
		resp.sendRedirect("/ch10/user5/list.do");
	}

}
