package jboard.dao;

import java.util.List;

import jboard.dto.ArticleDTO;
import jboard.util.DBHelper;

public class ArticleDAO extends DBHelper {
	
	private final static ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}	
	private ArticleDAO() {}
	
	
	public void insert(ArticleDTO dto) {
		
	}
	
	public ArticleDTO select(int ano) {
		return null;
	}
	
	public List<ArticleDTO> selectAll() {
		return null;
	}
	
	public void update(ArticleDTO dto) {
		
	}
	
	public void delete(int ano) {
		
	}
}
