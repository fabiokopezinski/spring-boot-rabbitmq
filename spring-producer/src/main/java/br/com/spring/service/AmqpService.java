package br.com.spring.service;

import br.com.spring.form.MessageForm;

public interface AmqpService {

	void SendToConsumer(MessageForm message);
}
