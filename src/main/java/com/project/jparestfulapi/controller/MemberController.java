package com.project.jparestfulapi.controller;

import com.project.jparestfulapi.domain.Member;
import com.project.jparestfulapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("")
    public List<Member> getMembers(){
        return memberService.memberList();
    }

    @GetMapping("/{memberid}")
    public Member getMemberById(@PathVariable("memberid") Long memberId){
        return memberService.memberInfo(memberId);
    }

    @PostMapping("")
    public Member signMember(@RequestParam(value = "memberid") Long memberId
            , @RequestParam(value = "membername") String memberName){
        Member member = new Member();
        member.setId(memberId);
        member.setName(memberName);
        return memberService.memberSignUp(member);
    }

    @PutMapping("/{memberid}")
    public Member modifyMember(
            @PathVariable("memberid") Long memberId,
            @RequestParam("membername") String memberName
    ){
        Member member = memberService.memberInfo(memberId);
        member.setName(memberName);
        return memberService.memberModify(member);
    }

    @DeleteMapping("/{memberid}")
    public void resignMember(@PathVariable Long memberid){
        memberService.memberResign(memberid);
    }

}
