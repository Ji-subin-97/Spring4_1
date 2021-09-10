package com.subin.p1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sql_Sec;
	private final String NAMESPACE = "com.subin.p1.member.MemberDAO.";
	
	
	public void getID() {
		return sql_Sec.selectOne(NAMESPACE + "getID", NAMESPACE);
	}
}
