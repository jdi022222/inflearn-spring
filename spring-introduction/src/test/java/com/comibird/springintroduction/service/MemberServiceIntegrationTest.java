package com.comibird.springintroduction.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.comibird.springintroduction.domain.Member;
import com.comibird.springintroduction.repository.MemberRepository;
import com.comibird.springintroduction.repository.MemoryMemberRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;

  @Test
  void 회원가입() {
    // given
    Member member = new Member();
    member.setName("hello");

    // when
    Long saveId = memberService.join(member);

    // then
    Member result = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(result.getName());
  }

  @Test
  void 중복_회원_예외() {
    // given
    Member member1 = new Member();
    member1.setName("hello");

    Member member2 = new Member();
    member2.setName("hello");

    // when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class,
        () -> memberService.join(member2));

    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//    memberService.join(member1);
//    try {
//      memberService.join(member2);
//      fail();
//    } catch (IllegalStateException e) {
//      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
  }

  @Test
  void 회원전체찾기() {
    // given
    Member member1 = new Member();
    member1.setName("hello1");
    memberService.join(member1);
    Member member2 = new Member();
    member2.setName("hello2");
    memberService.join(member2);

    // when
    List<Member> result = memberService.findMembers();

    // then
    assertThat(result.size()).isEqualTo(2);
  }

  @Test
  void 회원한명찾기() {
    // given
    Member member1 = new Member();
    member1.setName("hello1");
    memberService.join(member1);

    // when
    Member result = memberService.findOne(member1.getId()).get();

    // then
    assertThat(member1.getId()).isEqualTo(result.getId());
  }
}