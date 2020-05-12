package br.com.spring.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.spring.amqp.AmqpProducer;
import br.com.spring.form.MessageForm;

@Component
public class ProducerRabbitMQ implements AmqpProducer<MessageForm> {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;

	@Value("${spring.rabbitmq.request.exchenge.producer}")
	private String exchange;

	
	@Override
	public void producer(MessageForm message) {
		try {
			rabbitTemplate.convertAndSend(exchange,queue,message);
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex.getMessage()); 
			// quando der erro, ele vai enviar para a deadletter
		}
	}

}
