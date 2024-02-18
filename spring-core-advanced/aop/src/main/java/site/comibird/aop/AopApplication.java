package site.comibird.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import site.comibird.aop.order.aop.AspectV1;
import site.comibird.aop.order.aop.AspectV2;
import site.comibird.aop.order.aop.AspectV3;
import site.comibird.aop.order.aop.AspectV4Pointcut;

@SpringBootApplication
@Import(AspectV4Pointcut.class)
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
