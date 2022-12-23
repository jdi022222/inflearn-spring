package com.comibird.springintroduction;

import com.comibird.springintroduction.repository.JdbcMemberRepository;
import com.comibird.springintroduction.repository.JdbcTemplateMemberRepository;
import com.comibird.springintroduction.repository.MemberRepository;
import com.comibird.springintroduction.service.MemberService;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private final DataSource dataSource;

  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
    return new JdbcTemplateMemberRepository(dataSource);
  }
}
