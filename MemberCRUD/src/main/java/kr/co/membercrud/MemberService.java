package kr.co.membercrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.membercrud.MemberDao;
import kr.co.membercrud.MemberVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	
	public MemberVo selectMember(String uid) {
		return dao.selectMember(uid);
	}
	
	public List<MemberVo> selectMembers() {
		return dao.selectMembers();
	}
	
	public void updateMember(MemberVo vo) {
		dao.updateMember(vo);
	}
	
	public void deleteMember(MemberVo vo) {
		dao.deleteMember(vo);		
	}
}