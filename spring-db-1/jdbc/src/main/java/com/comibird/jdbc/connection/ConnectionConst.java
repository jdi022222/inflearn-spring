package com.comibird.jdbc.connection;

// 객체 생성을 막기 위해 abstract로 인스턴스 생성 방지
public abstract class ConnectionConst {
    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
}
