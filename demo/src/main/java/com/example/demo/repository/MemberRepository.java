package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
