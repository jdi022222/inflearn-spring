package site.comibird.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import site.comibird.aop.order.aop.AspectV1;
import site.comibird.aop.order.aop.AspectV2;
import site.comibird.aop.order.aop.AspectV3;
import site.comibird.aop.order.aop.AspectV4Pointcut;
import site.comibird.aop.order.aop.AspectV5Order;

@SpringBootApplication
@Import({AspectV5Order.LogAspect.class, AspectV5Order.TxAspect.class})
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
