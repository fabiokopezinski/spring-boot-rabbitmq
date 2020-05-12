package br.com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.form.MessageForm;
import br.com.spring.service.AmqpService;

@RestController
@RequestMapping("/producer")
public class AmqpController {

	@Autowired
	private AmqpService service;
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void send(@RequestBody  MessageForm message)
	{
		service.SendToConsumer(message);
	}
}
