package com.project.jparestfulapi.service;

import com.project.jparestfulapi.domain.Member;

import java.util.List;

public interface MemberService {

    // 전체 멤버을 가져오는 메서드
    List<Member> memberList();

    // 멤버정보를 가져오는 메서드
    Member memberInfo(Long id);

    // 멤버를 신규등록하는 메서드
    Member memberSignUp(Member member);

    // 멤버를 수정하는 메서드
    Member memberModify(Member modifiedMember);

    // 멤버를 삭제하는 메서드
    void memberResign(Long id);
}
