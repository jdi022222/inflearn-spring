package com.comibird.springcorebasic.order;

import com.comibird.springcorebasic.member.Grade;
import com.comibird.springcorebasic.member.Member;
import com.comibird.springcorebasic.member.MemberService;
import com.comibird.springcorebasic.member.MemberServiceImpl;

public class OrderApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.Vip);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println(order.toString());
    System.out.println(order.calculatePrice());
  }
}
