package com.comibird.springcorebasic.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import com.comibird.springcorebasic.AppConfig;
import com.comibird.springcorebasic.member.MemberRepository;
import com.comibird.springcorebasic.member.MemberServiceImpl;
import com.comibird.springcorebasic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {


  @Test
  void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    MemberRepository memberRepository1 = memberService.getMemberRepository();
    MemberRepository memberRepository2 = orderService.getMemberRepository();

    //모두 같은 인스턴스를 참고하고 있다.
    System.out.println(
        "memberService -> memberRepository = " + memberService.getMemberRepository());
    System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
    System.out.println("memberRepository = " + memberRepository);

    //모두 같은 인스턴스를 참고하고 있다.
    assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
  }
}
