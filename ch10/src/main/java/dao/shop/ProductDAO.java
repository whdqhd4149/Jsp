package dao.shop;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.shop.ProductDTO;
import util.DBHelper;

public class ProductDAO extends DBHelper{
	
	private static final ProductDAO INSTANCE = new ProductDAO();
	public static ProductDAO getInstance() {
		return INSTANCE;
	}
	private ProductDAO() {}
	
	private final String DBCP = "jdbc/shop";
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProduct(ProductDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO PRODUCT (pname, stock, price, company) VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getPname());
			psmt.setInt(2, dto.getStock());
			psmt.setInt(3, dto.getPrice());
			psmt.setString(4, dto.getCompany());
			psmt.executeUpdate();
			closeAll();
					
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		
	}
	
	public ProductDTO selectProduct(String pname) {
		
		ProductDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM PRODUCT WHERE PNAME=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pname);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDTO();
				
				dto.setPname(rs.getString(1));
				dto.setStock(rs.getString(2));
				dto.setPrice(rs.getString(3));
				dto.setCompany(rs.getString(4));			
			}
			closeAll();
			
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		return dto;		
	}
	
	public List<ProductDTO> selectAllProduct() {
		
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		
		try{
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM PRODUCT";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				
				dto.setPname(rs.getString(1));
				dto.setStock(rs.getString(2));
				dto.setPrice(rs.getString(3));
				dto.setCompany(rs.getString(4));
				
				dtoList.add(dto);				
			}
			closeAll();
			
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		return dtoList;
		
	}
	
	public void updateProduct(ProductDTO dto) {
		
	}
	
	public void deleteProduct(String pno) {
		
	}

	
}

