package com.comibird.springcorebasic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

  private MemberRepository memberRepository;

  @Autowired // ac.getBean(MemberRepository.class)
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memeberId) {
    return memberRepository.findById(memeberId);
  }

  // 싱글톤 테스트용
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
