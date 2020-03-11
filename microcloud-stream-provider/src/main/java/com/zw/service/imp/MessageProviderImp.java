package com.zw.service.imp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.zw.channel.DefaultProcess;
import com.zw.service.IMessageProvider;
import com.zw.vo.Product;

@EnableBinding(DefaultProcess.class)
public class MessageProviderImp implements IMessageProvider{

	@Resource(name="custom_output")
	MessageChannel output;
	
	@Override
	public void send(Product product) {
		output.send(MessageBuilder.withPayload(product).build());
	}

}
