package com.comibird.springintroduction.service;

import com.comibird.springintroduction.domain.Member;
import com.comibird.springintroduction.repository.MemberRepository;
import com.comibird.springintroduction.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;
import org.apache.catalina.LifecycleState;

public class MemberService {

  private static MemberRepository memberRepository = new MemoryMemberRepository();

  /**
   * 회원 가입
   */
  public long join(Member member) {
    validateDuplicateMember(member); // 중복 회원 검증

    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
            .ifPresent(m -> {
              try {
                throw new IllegalAccessException("이미 존재하는 회원입니다.");
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              }
            });
  }

  /**
   * 전체 회원 조회
   */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  /**
   * 회원 조회
   */
  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
