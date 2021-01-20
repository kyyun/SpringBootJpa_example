package com.example.demo.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MemberService;
import com.example.demo.vo.Member;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member", method = RequestMethod.POST)
	public String member(String name, String age) {
	
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		
		memberService.join(member);
		return "/";
	}
	
	@RequestMapping(value="/getMember", method = RequestMethod.GET)
	public List<Member> getMember() {
		
		List<Member> members = memberService.getMember();
		
		System.out.println(members);
		
		return members;
	}
	
	@RequestMapping(value="/updateMember/{id}", method = RequestMethod.PUT )
	public void updateMember(@PathVariable("id") Long id, @RequestParam Map<String, String> members) {
		
		memberService.updateMember(id, members);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void deleteMember(@PathVariable("id") Long id) {
		
		memberService.deleteMember(id);
	}
}
