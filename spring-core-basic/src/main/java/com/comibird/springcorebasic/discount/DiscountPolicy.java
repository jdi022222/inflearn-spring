package com.comibird.springcorebasic.discount;

import com.comibird.springcorebasic.member.Member;

public interface DiscountPolicy {

  /**
   * @return 할인 대상 금액
   */
  int discount(Member member, int price);
}
