package com.zw.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zw.StreamProviderApp;
import com.zw.service.IMessageProvider;
import com.zw.vo.Product;

@SpringBootTest(classes = { StreamProviderApp.class })
@RunWith(SpringRunner.class)
public class TestProvider {

	@Resource(name = "messageProviderImp")
	IMessageProvider messageProvider;

	@Test
	public void sendMessage() {
		Product p = new Product();
		p.setProductName("dahubi");
		p.setProductId(6666l);
		p.setProductDesc("dahubi666");
		messageProvider.send(p);
		messageProvider.send(p);
		messageProvider.send(p);
	}

}
