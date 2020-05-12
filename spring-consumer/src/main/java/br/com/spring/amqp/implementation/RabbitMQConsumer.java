package br.com.spring.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.spring.amqp.AmqpConsumer;
import br.com.spring.dto.MessageDTO;
import br.com.spring.service.ConsumerService;

@Component
public class RabbitMQConsumer implements AmqpConsumer<MessageDTO>{

	@Autowired
	private ConsumerService consumerService;
	
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consumer(MessageDTO message) {
		try {
			consumerService.action(message);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
		
	}

}
