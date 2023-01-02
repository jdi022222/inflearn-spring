package com.comibird.springcorebasic;

import com.comibird.springcorebasic.discount.FixDiscountPolicy;
import com.comibird.springcorebasic.member.MemberService;
import com.comibird.springcorebasic.member.MemberServiceImpl;
import com.comibird.springcorebasic.member.MemoryMemberRepository;
import com.comibird.springcorebasic.order.OrderService;
import com.comibird.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }
}
