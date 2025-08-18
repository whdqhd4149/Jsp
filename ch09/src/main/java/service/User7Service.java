package service;

import java.util.List;

import dao.User7DAO;
import dto.User7DTO;

public class User7Service {
	
	private static User7Service instance = new User7Service();
	public static User7Service getInstance() {
		return instance;
	}
	private User7Service() {}
	
	// dao 싱글톤 객체 가져오기
	private User7DAO dao = User7DAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍 
	public void register(User7DTO dto) {
		dao.insertUser7(dto);
	}
	
	public User7DTO findById(String id) {
		return dao.selectUser7(id);
	
	}
	
	public List<User7DTO> findAll() {
		return dao.selectAllUser7();
	}
	
	public void modify(User7DTO dto) {
		dao.updateUser7(dto);
	}
	
	public void delete(String id) {
		dao.deleteUser7(id);
	}

}
