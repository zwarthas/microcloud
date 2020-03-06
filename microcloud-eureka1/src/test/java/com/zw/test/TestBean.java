package com.zw.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zw.EurekaApp;

@SpringBootTest(classes = { EurekaApp.class })
@RunWith(SpringRunner.class)
public class TestBean {

	@Resource
	Person person;
	
	@Test
	public void testYibo() {
		System.out.println(person.getName());
	}
	
}
