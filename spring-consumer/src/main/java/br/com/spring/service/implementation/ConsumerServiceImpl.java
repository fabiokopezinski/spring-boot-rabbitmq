package br.com.spring.service.implementation;

import org.springframework.stereotype.Service;

import br.com.spring.dto.MessageDTO;
import br.com.spring.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

	@Override
	public void action(MessageDTO message) throws Exception {
		log.info(message.getMessage());
		
	}

}
