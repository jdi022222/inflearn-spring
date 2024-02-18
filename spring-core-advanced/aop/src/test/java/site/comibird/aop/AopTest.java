package site.comibird.aop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import site.comibird.aop.order.OrderRepository;
import site.comibird.aop.order.OrderService;

@Slf4j
@SpringBootTest
public class AopTest {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Test
	void aopInfo() {
		log.info("isAop", AopUtils.isAopProxy(orderService));
		log.info("isAop", AopUtils.isAopProxy(orderRepository));
		Assertions.assertThat(AopUtils.isAopProxy(orderService)).isTrue();
		Assertions.assertThat(AopUtils.isAopProxy(orderRepository)).isTrue();
	}

	@Test
	void success() {
		orderService.orderItem("itemA");
	}

	@Test
	void fail() {
		Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
			.isInstanceOf(IllegalStateException.class);
	}
}
