package br.com.spring.amqp;

public interface AmqpProducer<T> {
	
	void producer(T t);

}
