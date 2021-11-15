package com.information.biz.physical.impl;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.information.biz.physical.PhysicalVO;

public class PhysicalRowMapper implements RowMapper<PhysicalVO>{
	@Override
	public PhysicalVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PhysicalVO physical = new PhysicalVO();
		physical.setSeq(rs.getInt("SEQ"));
		physical.setName1(rs.getString("NAME1"));
		physical.setWeight(rs.getString("WEIGHT"));
		physical.setHeight(rs.getString("HEIGHT"));
		physical.setBlood(rs.getString("BLOOD"));
		physical.setGender(rs.getString("GENDER"));
		physical.setRegDate(rs.getDate("REGDATE"));
		physical.setCnt(rs.getInt("CNT"));
		return physical;
	}

}
