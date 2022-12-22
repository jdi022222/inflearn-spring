package com.comibird.springintroduction;

import com.comibird.springintroduction.repository.MemberRepository;
import com.comibird.springintroduction.repository.MemoryMemberRepository;
import com.comibird.springintroduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}
