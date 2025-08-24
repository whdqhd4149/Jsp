package controller.bank.account;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.bank.AccountDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.AccountService;

@WebServlet("/bank/account/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private AccountService service = AccountService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/bank/account/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acc_no = req.getParameter("acc_no");
		String acc_type = req.getParameter("acc_type");
		String acc_name = req.getParameter("acc_name");
		String acc_cid = req.getParameter("acc_cid");
		String acc_balance = req.getParameter("acc_balance");
		String acc_date = req.getParameter("acc_date");
		
		AccountDTO dto = new AccountDTO();
		dto.setAcc_no(acc_no);
		dto.setAcc_type(acc_type);
		dto.setAcc_name(acc_name);
		dto.setAcc_cid(acc_cid);
		dto.setAcc_balance(acc_balance);
		dto.setAcc_date(acc_date);
		
		logger.info(dto.toString());
		
		service.register(dto);
		
		resp.sendRedirect("/ch10/bank/account/list.do");
	}
	

}
