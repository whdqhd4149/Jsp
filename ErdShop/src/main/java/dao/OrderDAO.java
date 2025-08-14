package dao;



import dto.OrderDTO;

import util.DBHelper;

public class OrderDAO extends DBHelper{
	
	private static final OrderDAO INSTANCE = new OrderDAO();
	public static OrderDAO getInstance() {
		return INSTANCE;
	}
	private OrderDAO() {}
	
	// 기본 CRUD 메서드
	
	public void insertOrder(OrderDTO dto) {
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO \"Order\" (ORDERID, ORDERPRODUCT, ORDERCOUNT, ORDERDATE)values(?,?,?,SYSDATE) ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getOrderId());
			psmt.setInt(2, dto.getOrderProduct());
			psmt.setInt(3, dto.getOrderCount());			
			psmt.executeUpdate();
			
			closeAll();
			
				 
			}catch (Exception e) {
				e.printStackTrace();
		}
			
	
		
		
		
	}

	

}
