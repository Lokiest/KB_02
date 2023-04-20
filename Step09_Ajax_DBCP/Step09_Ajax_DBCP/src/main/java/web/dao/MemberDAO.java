package web.dao;

import java.util.List;

import web.dto.Member;

public interface MemberDAO {
	//회원 전체 검색
	List<Member> selectAll();
}
