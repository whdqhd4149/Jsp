package controller.shop.product;

import java.io.IOException;

import dto.shop.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

@WebServlet("/shop/product/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pname = req.getParameter("pname");
		
		ProductDTO productDTO = service.findById(pname);
		
		req.setAttribute("productDTO", productDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/shop/product/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pname = req.getParameter("pname");
		String stock = req.getParameter("stock");
		String price = req.getParameter("price");
		String company = req.getParameter("company");
		
		ProductDTO dto = new ProductDTO();
		dto.setPname(pname);
		dto.setStock(stock);
		dto.setPrice(price);
		dto.setCompany(company);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/shop/product/list.do");
	}

}
