package br.com.spring.service;

import br.com.spring.dto.MessageDTO;

public interface ConsumerService {
	
	void action(MessageDTO message) throws Exception;
}
