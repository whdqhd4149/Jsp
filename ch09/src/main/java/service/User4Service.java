package service;

import java.util.List;

import dao.User4DAO;
import dto.User4DTO;

public class User4Service {
	
	// 싱글톤
	private static User4Service instance = new User4Service();
	public static User4Service getInstance() {
		return instance;
	}
	private User4Service() {}
	
	// dao 싱글톤 객체 가져오기
	private User4DAO dao = User4DAO.getInstance();
	
	// DAO 메서드 호출 - Service에 맞게 네이밍
	public void register(User4DTO dto) {
		dao.insertUser4(dto);
	}
	
	public User4DTO findById(String name) {
		return dao.selectUser4(name);
	}
	
	public List<User4DTO> findAll() {
		return dao.selectAllUser4();
	}
	
	public void modify(User4DTO dto) {
		dao.updateUser4(dto);
	}
	
	public void delete(String name) {
		dao.deleteUser4(name);
	}
	
}
