package com.comibird.springcorebasic.order;

import com.comibird.springcorebasic.discount.DiscountPolicy;
import com.comibird.springcorebasic.member.Member;
import com.comibird.springcorebasic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

  private MemberRepository memberRepository;
  private DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  // 싱글톤 테스트용
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
