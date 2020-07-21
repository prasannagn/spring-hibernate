package com.app.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int arg1) throws SQLException {
		Member member = new Member();
		member.setId(rs.getLong("USER_ID"));
		member.setName(rs.getString("USER_NAME"));
		return member;
	}

}
