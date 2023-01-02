package com.comibird.springcorebasic;

import com.comibird.springcorebasic.discount.DiscountPolicy;
import com.comibird.springcorebasic.discount.FixDiscountPolicy;
import com.comibird.springcorebasic.member.MemberRepository;
import com.comibird.springcorebasic.member.MemberService;
import com.comibird.springcorebasic.member.MemberServiceImpl;
import com.comibird.springcorebasic.member.MemoryMemberRepository;
import com.comibird.springcorebasic.order.OrderService;
import com.comibird.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  private MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  private DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }
}
