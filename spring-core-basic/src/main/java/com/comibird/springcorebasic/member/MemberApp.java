package com.comibird.springcorebasic.member;

import com.comibird.springcorebasic.AppConfig;

public class MemberApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    Member member = new Member(1L, "memberA", Grade.Vip);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new Member = " + member.getName());
    System.out.println("find Member = " + findMember.getName());
  }
}
