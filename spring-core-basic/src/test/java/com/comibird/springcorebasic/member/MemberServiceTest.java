package com.comibird.springcorebasic.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

  MemberService memberService = new MemberServiceImpl();

  @DisplayName("멤버 저장")
  @Test
  void join() {
    // given
    Member member = new Member(1L, "memberA", Grade.Vip);

    // when
    memberService.join(member);
    Member findMember = memberService.findMember(1L);

    // then
    assertThat(member).isEqualTo(findMember);
  }

}
