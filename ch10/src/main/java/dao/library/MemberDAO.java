package dao.library;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.library.MemberDTO;
import util.DBHelper;

public class MemberDAO extends DBHelper{
	
	private static final MemberDAO INSTANCE = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return INSTANCE;
	}
	private MemberDAO() {}
	
	private final String DBCP = "jdbc/library";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertMember(MemberDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getMember_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getJoin_date());
			psmt.executeUpdate();
			
			closeAll();
			
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	public MemberDTO selectMember(String member_id) {
		
		MemberDTO dto = null;
		
		try{
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM MEMBER WHERE member_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setJoin_date(rs.getString(5));				
			}
			closeAll();
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		return dto;
	}
	
	public List<MemberDTO> selectAllMember() {
		
		List<MemberDTO> dtoList = new ArrayList<MemberDTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM MEMBER";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMember_id(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setJoin_date(rs.getString(5));
				
				dtoList.add(dto);	
			}
			closeAll();
			
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		return dtoList;
	}
	
	public void updateMember(MemberDTO dto) {
		
		try{
			conn = getConnection(DBCP);
			
			String sql = "UPDATE MEMBER SET name=?, address=?, hp=?, join_date=? WHERE member_id=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getAddress());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getJoin_date());
			psmt.setInt(5, dto.getMember_id());
			psmt.executeUpdate();
			
			closeAll();
			
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}		
	}
	
	public void deleteMember(int member_id) {
		
	}
	

}
