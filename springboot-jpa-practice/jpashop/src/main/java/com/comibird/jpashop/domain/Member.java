package com.comibird.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    //order에 있는 member에 의해 매핑된 것
    //연관관계의 주인이 아님을 명시
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}