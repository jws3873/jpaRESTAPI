package com.project.jparestfulapi.service;

import com.project.jparestfulapi.dao.MemberRepository;
import com.project.jparestfulapi.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> memberList() {
        return (List<Member>) memberRepository.findAll();
    }

    @Override
    public Member memberInfo(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member memberSignUp(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member memberModify(Member modifiedMember) {
        Member member = memberRepository.findById(modifiedMember.getId()).orElse(null);
        if(member == null) return null;
        return memberRepository.save(modifiedMember);
    }

    @Override
    public void memberResign(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        memberRepository.delete(member);
    }
}
