package com.zw.service.imp;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.zw.service.IMessageProvider;
import com.zw.vo.Product;

@EnableBinding(Source.class)
public class MessageProviderImp implements IMessageProvider{

	@Resource
	MessageChannel output;
	
	@Override
	public void send(Product product) {
		output.send(MessageBuilder.withPayload(product).build());
	}

}
