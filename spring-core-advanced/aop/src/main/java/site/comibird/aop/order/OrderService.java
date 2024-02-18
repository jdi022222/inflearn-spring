package site.comibird.aop.order;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void orderItem(String itemId) {
		log.info("[orderService] 실행");
		orderRepository.save(itemId);
	}
}