package com.comibird.springcorebasic.web;

import com.comibird.springcorebasic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  private final MyLogger myLogger;

  public void logic(String id) {
    // 이 시점에서 MyLogger 빈 생성
    myLogger.log("service id = " + id);
  }
}
