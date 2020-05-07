package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member member) {
//		System.out.println("Service단까지 옴");
		
		Connection conn = getConnection();
		
		Member loginMember = new MemberDao().loginMmeber(conn,member);
		
		close(conn);
		
		return loginMember;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn,member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		
		Member loginMember = new MemberDao().selectMmeber(conn,userId);
		
		close(conn);
		
		return loginMember;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn,member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteMember(String userId) {
Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn,userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
