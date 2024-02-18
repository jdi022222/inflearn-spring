package com.comibird.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HelloRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Hello member) {
        em.persist(member);
        return member.getId();
    }

    public Hello find(Long id) {
        return em.find(Hello.class, id);
    }
}
