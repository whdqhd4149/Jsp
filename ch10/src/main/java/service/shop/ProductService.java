package service.shop;

import java.util.List;

import dao.shop.ProductDAO;
import dto.shop.ProductDTO;

public enum ProductService {
	
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();
	
	public void register(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	
	public ProductDTO findById(String pname) {
		return dao.selectProduct(pname);
	}
	
	public List<ProductDTO> findALL(){
		return dao.selectAllProduct();
	}
	
	public void modify(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	
	public void delete(String pname) {
		dao.deleteProduct(pname);
	}
}
