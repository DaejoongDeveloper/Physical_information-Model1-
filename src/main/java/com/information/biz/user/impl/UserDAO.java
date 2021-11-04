package com.information.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.information.biz.common.JDBCUtil;
import com.information.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users2 where id=? and password=?";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("-> getUser 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setNString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD") );
				user.setName(rs.getNString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,  stmt, conn);
		}
		return user;
	}
}
