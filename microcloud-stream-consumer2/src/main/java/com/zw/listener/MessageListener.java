package com.zw.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.zw.channel.DefaultProcess;
import com.zw.vo.Product;

@Component
@EnableBinding(DefaultProcess.class)
public class MessageListener {

	@StreamListener(DefaultProcess.INPUT)
	public void listen(Message<Product> message) {
		System.out.println("爷1号听到1消息："+message.getPayload());
	}
	
	@StreamListener(DefaultProcess.INPUT2)
	public void listen2(Message<Product> message) {
		System.out.println("爷2号听到1消息："+message.getPayload());
	}
	
}
