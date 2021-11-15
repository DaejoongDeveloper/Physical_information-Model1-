package com.information.biz.physical.impl;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.information.biz.physical.PhysicalVO;

public class PhysicalDAOSpring extends JdbcDaoSupport{
	private final String PHYSICAL_INSERT = "insert into physical(seq, name1, weight, height, blood, gender) values((select nvl(max(seq), 0)+1 from physical),?,?,?,?,?)";
	private final String PHYSICAL_UPDATE = "update physical set name1=?, weight=?, height=?, blood=?, gender=? where seq=?";
	private final String PHYSICAL_DELETE = "delete physical where seq=?";
	private final String PHYSICAL_GET = "select * from physical where seq=?";
	private final String PHYSICAL_LIST = "select * from physical order by seq";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public void insertPhysical(PhysicalVO vo) {
		System.out.println("-> insert처리");
		getJdbcTemplate().update(PHYSICAL_INSERT, vo.getName1(), vo.getWeight(), vo.getHeight(), vo.getBlood(), vo.getGender());
	}
	
	public void updatePhysical(PhysicalVO vo) {
		System.out.println("-> update처리");
		getJdbcTemplate().update(PHYSICAL_UPDATE, vo.getName1(), vo.getWeight(), vo.getHeight(), vo.getBlood(), vo.getGender(), vo.getSeq());
	}
	
	public void deletePhysical(PhysicalVO vo) {
		System.out.println("-> delete처리");
		getJdbcTemplate().update(PHYSICAL_DELETE, vo.getSeq());
	}
	
	public PhysicalVO getPhysical(PhysicalVO vo) {
		System.out.println("-> getPhysical 처리");
		Object[] args = {vo.getSeq()};
		return getJdbcTemplate().queryForObject(PHYSICAL_GET, args, new PhysicalRowMapper());
	}
	
	public List<PhysicalVO> getPhysicalList(PhysicalVO vo){
		System.out.println("-> List 처리");
		return getJdbcTemplate().query(PHYSICAL_LIST, new PhysicalRowMapper());
	}
}

