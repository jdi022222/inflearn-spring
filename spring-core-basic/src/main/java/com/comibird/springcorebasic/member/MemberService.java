package com.comibird.springcorebasic.member;

public interface MemberService {

  void join(Member member);

  Member findMember(Long memeberId);
}
