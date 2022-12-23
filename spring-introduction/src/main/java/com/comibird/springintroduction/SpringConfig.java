package com.comibird.springintroduction;

import com.comibird.springintroduction.repository.JpaMemberRepository;
import com.comibird.springintroduction.repository.MemberRepository;
import com.comibird.springintroduction.service.MemberService;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//  private final DataSource dataSource;
//
//  public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//  }

  private EntityManager em;

  @Autowired
  public SpringConfig(EntityManager em) {
    this.em = em;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
  }
}
