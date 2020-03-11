package com.zw.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DefaultProcess {

	public static final String OUTPUT="custom_output";
	public static final String INPUT="custom_input";
	public static final String INPUT2="custom_input2";
	
	@Output(DefaultProcess.OUTPUT)
	MessageChannel output();
	
	@Input(DefaultProcess.INPUT)
	SubscribableChannel input();
	
	@Input(DefaultProcess.INPUT2)
	SubscribableChannel input2();
}
