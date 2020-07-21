package com.app.transaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.MemberDao;
import com.app.model.Member;

public class MyTransaction {
	@Autowired
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void saveMember(Member member) {
		memberDao.saveMember(member);
		if (0 == member.getId()) {
			throw new RuntimeException();
		}
	}
}
