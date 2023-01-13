package com.comibird.springcorebasic.componentScan;

import static org.assertj.core.api.Assertions.assertThat;

import com.comibird.springcorebasic.AutoAppConfig;
import com.comibird.springcorebasic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        AutoAppConfig.class);

    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

}
