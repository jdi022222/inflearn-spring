package com.comibird.springcorebasic.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.comibird.springcorebasic.AppConfig;
import com.comibird.springcorebasic.member.Grade;
import com.comibird.springcorebasic.member.Member;
import com.comibird.springcorebasic.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @DisplayName("주문 생성")
  @Test
  void createOrder() {
    // given
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.Vip);
    memberService.join(member);

    // when
    Order order = orderService.createOrder(memberId, "itemA", 10000);

    // then
    assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
