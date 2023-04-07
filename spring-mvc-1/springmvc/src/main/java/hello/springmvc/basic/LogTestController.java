package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        logger.trace("trace log={}", name);
        logger.debug("debug log={}", name);
        logger.info("info log={}", name);
        logger.warn("warn log={}", name);
        logger.error("error log={}", name);
        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X log.debug("String concat log=" + name);

        return "ok";
    }
}
