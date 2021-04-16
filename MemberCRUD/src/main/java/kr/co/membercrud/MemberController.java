package kr.co.membercrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.membercrud.MemberService;
import kr.co.membercrud.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/register")
	public String register() {
		return "/register";
	}
	
	@PostMapping("/register")
	public String register(MemberVo vo) {
		service.insertMember(vo);
		return "redirect:/list";
	}
	
	@GetMapping(value={"/", "/list"})
	public String list(Model model) {
		List<MemberVo> members = service.selectMembers();
		
		model.addAttribute("members", members);
		
		return "/list";
	}
	
	@GetMapping("/modify")
	public String modify(String uid, Model model) {
		
		MemberVo vo = service.selectMember(uid);
		
		model.addAttribute(vo);
		
		return "/modify";
	}
	
	@PostMapping("/modify")
	public String modify(MemberVo vo) {
		service.updateMember(vo);
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(MemberVo vo) {
		service.deleteMember(vo);
		return "redirect:/list";
	}
	
}


