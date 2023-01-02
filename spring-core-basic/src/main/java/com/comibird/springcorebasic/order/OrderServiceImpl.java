package com.comibird.springcorebasic.order;

import com.comibird.springcorebasic.discount.DiscountPolicy;
import com.comibird.springcorebasic.discount.FixDiscountPolicy;
import com.comibird.springcorebasic.member.Member;
import com.comibird.springcorebasic.member.MemberRepository;
import com.comibird.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
