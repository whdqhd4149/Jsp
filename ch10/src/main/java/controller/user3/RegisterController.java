package controller.user3;



import java.io.IOException;

import dto.User3DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User3Service;

@WebServlet("/user3/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private User3Service service = User3Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user3/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 폼 입력 데이터 수신
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String hp = req.getParameter("hp");
		String addr = req.getParameter("addr");
		
		// DTO 생성
		User3DTO dto = new User3DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setHp(hp);
		dto.setAddr(addr);
		
		// 서비스 호출
		service.register(dto);
		
		// 목록 이동
		resp.sendRedirect("/ch10/user3/list.do");
		
	}

}
