package com.comibird.springcorebasic.order;

import com.comibird.springcorebasic.discount.FixDiscountPolicy;
import com.comibird.springcorebasic.member.Grade;
import com.comibird.springcorebasic.member.Member;
import com.comibird.springcorebasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

// 순수한 자바 코드로 테스트 생성
//
class OrderServiceImplTest {

  @Test
  void createOrder() {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    memberRepository.save(new Member(1L,"name", Grade.Vip));

    OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    Order order = orderService.createOrder(1L, "itemA", 10000);

    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

}