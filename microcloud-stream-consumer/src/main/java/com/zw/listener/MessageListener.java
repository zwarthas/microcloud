package com.zw.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.zw.vo.Product;

@Component
@EnableBinding(Sink.class)
public class MessageListener {

	@StreamListener(Sink.INPUT)
	public void listen(Message<Product> message) {
		System.out.println("听到消息："+message.getPayload());
	}
	
}
