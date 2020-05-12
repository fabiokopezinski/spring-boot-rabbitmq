package br.com.spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.amqp.AmqpProducer;
import br.com.spring.form.MessageForm;
import br.com.spring.service.AmqpService;

@Service
public class RabbitMQService implements AmqpService {

	@Autowired
	private AmqpProducer<MessageForm> amqp;
	
	@Override
	public void SendToConsumer(MessageForm message) {
		amqp.producer(message);
	}

}
