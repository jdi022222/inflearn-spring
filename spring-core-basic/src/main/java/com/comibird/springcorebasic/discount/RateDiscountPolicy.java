package com.comibird.springcorebasic.discount;

import com.comibird.springcorebasic.annotaion.MainDiscountPolicy;
import com.comibird.springcorebasic.member.Grade;
import com.comibird.springcorebasic.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.Vip) {
      return price * discountPercent / 100;
    }
    return 0;
  }
}
