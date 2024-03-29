package com.comibird.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
class HelloRepositoryTests {
    @Autowired
    HelloRepository helloRepository;

    @Test
    @Transactional
    @Rollback(false)
    @DisplayName("회원_테스트")
    void testMember() {
        //given
        Hello member = new Hello();
        member.setUsername("memberA");

        //when
        Long savedId = helloRepository.save(member);
        Hello findMember = helloRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}