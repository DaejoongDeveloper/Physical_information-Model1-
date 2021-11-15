package com.information.biz.physical.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.information.biz.common.JDBCUtil;
import com.information.biz.physical.PhysicalVO;
@Repository("boardDAO")
public class PhysicalDAO {
	//JDBC관련변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String PHYSICAL_INSERT ="insert into physical(seq, name1, weight, height, blood, gender) values((select nvl(max(seq), 0)+1 from physical),?,?,?,?,?)";
	private final String PHYSICAL_UPDATE = "update physical set name1=?, weight=?, height=?, blood=?, gender=? where seq=?";
	private final String PHYSICAL_DELETE = "delete physical where seq=?";
	private final String PHYSICAL_GET = "select * from physical where seq=?";
	private final String PHYSICAL_LIST = "select * from physical order by seq";
	
	//CRUD 기능의 메소드 구현
	//등록
	public void insertPhysical(PhysicalVO vo) {
		System.out.println("-> insert기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(PHYSICAL_INSERT);
			pstmt.setString(1, vo.getName1());
			pstmt.setString(2, vo.getWeight());
			pstmt.setString(3, vo.getHeight());
			pstmt.setString(4, vo.getBlood());
			pstmt.setString(5, vo.getGender());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public void updatePhysical(PhysicalVO vo) {
		System.out.println("-> update 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(PHYSICAL_UPDATE);
			pstmt.setString(1, vo.getName1());
			pstmt.setString(2, vo.getWeight());
			pstmt.setString(3, vo.getHeight());
			pstmt.setString(4, vo.getBlood());
			pstmt.setString(5, vo.getGender());
			pstmt.setInt(6, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public void deletePhysical(PhysicalVO vo) {
		System.out.println("-> delete 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(PHYSICAL_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public PhysicalVO getPhysical(PhysicalVO vo) {
		System.out.println("-> get 기능 처리");
		PhysicalVO physical = null;

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(PHYSICAL_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				physical = new PhysicalVO();
				physical.setSeq(rs.getInt("SEQ"));
				physical.setName1(rs.getString("NAME1"));
				physical.setWeight(rs.getString("WEIGHT"));
				physical.setHeight(rs.getString("HEIGHT"));
				physical.setBlood(rs.getString("BLOOD"));
				physical.setGender(rs.getString("GENDER"));
				physical.setRegDate(rs.getDate("REGDATE"));
				physical.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return physical;
	}
	
	public List<PhysicalVO> getPhysicalList(PhysicalVO vo) {
		System.out.println("-> JDBC로 getList 처리");
		List<PhysicalVO> physicalList = new ArrayList<PhysicalVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(PHYSICAL_LIST);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PhysicalVO physical = new PhysicalVO();
				physical.setSeq(rs.getInt("SEQ"));
				physical.setName1(rs.getString("NAME1"));
				physical.setWeight(rs.getString("WEIGHT"));
				physical.setHeight(rs.getString("HEIGHT"));
				physical.setBlood(rs.getString("BLOOD"));
				physical.setGender(rs.getString("GENDER"));
				physical.setRegDate(rs.getDate("REGDATE"));
				physical.setCnt(rs.getInt("CNT"));
				physicalList.add(physical);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return physicalList;
	}
	
	
}
