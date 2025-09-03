package jboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.ArticleDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class ArticleDAO extends DBHelper {
	
	private final static ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}	
	private ArticleDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insert(ArticleDTO dto) {
		
		int ano = 0;
		
		try {
			conn = getConnection();
			
			conn.setAutoCommit(false);
		
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile_cnt());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getReg_ip());
			//logger.debug(psmt.toString());  <-- 중요한 팁!!
			psmt.executeUpdate();
			
			// 방금 INSERT한 글 번호 조회
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAX_ANO);
			
			if(rs.next()) {
				ano = rs.getInt(1);	
			}
			
			conn.commit();				
			closeAll();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
			
			try {
				conn.rollback();
			}catch (Exception e1) {
				logger.error(e.getMessage());
			}
		}
		
		return ano;
	}
	
	public int selectCountTotal() {
		
		int total = 0;
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);	
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	public ArticleDTO select(int ano) {
		return null;
	}
	
	public List<ArticleDTO> selectAll(int start) {
		
		List<ArticleDTO> dtoList = new ArrayList<ArticleDTO>();
				
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLE_ALL);
			psmt.setInt(1, start);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setAno(rs.getInt(1));
				dto.setCate(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setComment_cnt(rs.getInt(5));
				dto.setFile_cnt(rs.getInt(6));
				dto.setHit_cnt(rs.getInt(7));
				dto.setWriter(rs.getString(8));
				dto.setReg_ip(rs.getString(9));
				dto.setWdate(rs.getString(10));
				dto.setNick(rs.getString(11));
				dtoList.add(dto);
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return dtoList;
	}
	
	public void update(ArticleDTO dto) {
		
	}
	
	public void delete(int ano) {
		
	}
}
