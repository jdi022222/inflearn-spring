package com.comibird.springcorebasic;

import com.comibird.springcorebasic.discount.DiscountPolicy;
import com.comibird.springcorebasic.discount.RateDiscountPolicy;
import com.comibird.springcorebasic.member.MemberRepository;
import com.comibird.springcorebasic.member.MemberService;
import com.comibird.springcorebasic.member.MemberServiceImpl;
import com.comibird.springcorebasic.member.MemoryMemberRepository;
import com.comibird.springcorebasic.order.OrderService;
import com.comibird.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }
}
