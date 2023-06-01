package com.example.rabbit.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbit.config.MessagingConfig;
import com.example.rabbit.model.OrderStatus;
import com.example.rabbit.model.PurchaseOrder;

@RestController
@RequestMapping("/order")
public class PurchaseOrderPublisher {
	
	@Autowired
	private RabbitTemplate template;
	
	@Value("${ust.rabbitmq.routingkey}")
	String routingkey;
	@Value("${ust.rabbitmq.queue}")
	String queue;
	@Value("${ust.rabbitmq.exchange}")
	String exchange;
	
	@PostMapping("/{customerName}")
	public String bookOrder(@RequestBody PurchaseOrder order, @PathVariable String customerName) {
		order.setOrderid(UUID.randomUUID().toString());
		//other service calls
		OrderStatus orderStatus = new OrderStatus(order, "ACCEPTED", "order placed successfully by "+ customerName);
		template.convertAndSend(exchange, routingkey, orderStatus);
		return "Success";    // this is confirmation to the sender of order.
	}

}
