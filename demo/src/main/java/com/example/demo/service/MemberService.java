package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MemberRepository;
import com.example.demo.vo.Member;

@Service
@Transactional
public class MemberService {
	
	@Autowired
    private MemberRepository memberRepository;
	
	public Long join(Member member) {
		
        memberRepository.save(member);
        return member.getId();
        
	}
	
	public List<Member> getMember() {
		
		return memberRepository.findAll();
	}
	
	public void updateMember(Long id, Map<String, String> members) {
		
		Optional<Member> updateMember = memberRepository.findById(id);
		
		updateMember.ifPresent(selectId -> {
			selectId.setName(members.get("name"));
			selectId.setAge(members.get("age"));
			memberRepository.save(selectId);
		});
		
	}
	
	public void deleteMember(Long id) {

		Optional<Member> deleteMember = memberRepository.findById(id);
		
		deleteMember.ifPresent(selectId -> {
			System.out.println("user" +selectId);
			memberRepository.delete(selectId);
		});
	}

}
