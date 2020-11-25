package tw.group4._35_.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;

@RestController
public class MemberREST {

	@Autowired
	WebsiteMemberService service;
	
	@PostMapping(path= "/35/members/{name}")
	public Map<String, String> postMembers(@RequestBody WebsiteMember member, @PathVariable String name) {
		System.out.println(member.getName());
		System.out.println(member.getAddress());
		System.out.println(member.getEmail());
		Map<String, String> map = new HashMap<>();
		int n = 1;
		try {
//			WebsiteMember insertResult = service.insert(member);
			if (n == 1) {
				map.put("success", "新增成功"); 
			} else if (n == -1) {
				map.put("fail", "帳號重複");
			}
			
		} catch(Exception e) {
			map.put("fail", e.getMessage());
		}
		
		return map;
	}
}
