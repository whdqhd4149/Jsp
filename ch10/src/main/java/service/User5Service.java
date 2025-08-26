package service;

import java.util.List;

import dao.User5DAO;
import dto.User5DTO;

public enum User5Service {
	
	INSTANCE;
	
	private User5DAO dao = User5DAO.getInstance();
	
	public void register(User5DTO dto) {
		dao.insertUser5(dto);
	}
	
	public User5DTO findById(String seq) {
		return dao.selectUser5(seq);
	}
	
	public List<User5DTO> findAll(){
		return dao.selectAllUser5();
	}
	
	public void modify(User5DTO dto) {
		dao.updateUser5(dto);
	}
	
	public void remove(String name) {
		dao.deleteUser5(name);
	}

}
