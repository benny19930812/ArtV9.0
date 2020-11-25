package tw.group4._35_.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4.util.IdentityFilter;

@Controller
public class MemberListAll {
	
	@Autowired
	private WebsiteMemberService service;
	
	@GetMapping("/35/members.ctrl")
	public String memberList(Model m){
		
		List<WebsiteMember> list = service.selectAllMembers();
		m.addAttribute("membersList", list);
		
		return IdentityFilter.loginID+"35/login/memberManagement";
	}

}
