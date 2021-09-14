package com.subin.p1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sql_Sec;
	private final String NAMESPACE = "com.subin.p1.member.MemberDAO.";
	
	
	public MemberDTO getIDCheck(MemberDTO memberDTO) throws Exception{
		return sql_Sec.selectOne(NAMESPACE + "getIDCheck", memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return sql_Sec.selectOne(NAMESPACE + "getLogin", memberDTO);
	}
	
	public int setFileInsert(MemberFilesDTO memberFilesDTO) throws Exception{
		return sql_Sec.insert(NAMESPACE + "setFileInsert", memberFilesDTO);
	}
	
	public int setJoin(MemberDTO memberDTO) throws Exception{
		return sql_Sec.insert(NAMESPACE + "setJoin", memberDTO);
	}
	
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return sql_Sec.update(NAMESPACE + "setUpdate", memberDTO);
	}
	
	public int setDelete(MemberDTO memberDTO) throws Exception{
		return sql_Sec.delete(NAMESPACE + "setDelete", memberDTO);
	}
}
