package service;

import java.util.List;

import dao.User6DAO;
import dto.User6DTO;

public class User6Service {
	
	private static User6Service instance = new User6Service();
	public static User6Service getInstance() {
		return instance;
	}
	private User6Service() {}
	
	// dao 싱글톤 객체 가져오기
	private User6DAO dao = User6DAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(User6DTO dto) {
		dao.insertUser6(dto);		
	}
	
	public User6DTO findById(String name) {
		return dao.selectUser6(name);
		
	}
	
	public List<User6DTO> findAll() {
		return dao.selectAllUser6();
		
	}
	
	public void modify(User6DTO dto) {
		dao.updateUser6(dto);
		
	}
	
	public void delete(String name) {
		dao.deleteUser6(name);
		
	}

}
