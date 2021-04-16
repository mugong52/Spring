package kr.co.membercrud;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.membercrud.MemberVo;

@Repository
public class MemberDao {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertMember(MemberVo vo) {
		mybatis.insert("mapper.member.INSERT_MEMBER", vo);
	}
	
	public MemberVo selectMember(String uid) {
		return mybatis.selectOne("mapper.member.SELECT_MEMBER", uid);
	}
	
	public List<MemberVo> selectMembers() {
		return mybatis.selectList("mapper.member.SELECT_MEMBERS");
	}
	
	public void updateMember(MemberVo vo) {
		mybatis.update("mapper.member.UPDATE_MEMBER", vo);
	}
	
	public void deleteMember(MemberVo vo) {
		mybatis.delete("mapper.member.DELETE_MEMBER", vo);
		
	}
}

