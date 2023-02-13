package com.comibird.springcorebasic.discount;

import com.comibird.springcorebasic.member.Grade;
import com.comibird.springcorebasic.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1000; // 고정으로 1000원 할인

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.Vip) {
      return discountFixAmount;
    }
    return 0;
  }
}
