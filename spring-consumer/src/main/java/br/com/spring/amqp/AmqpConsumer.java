package br.com.spring.amqp;

public interface AmqpConsumer<T> {

	void consumer(T t) throws Exception;
}
