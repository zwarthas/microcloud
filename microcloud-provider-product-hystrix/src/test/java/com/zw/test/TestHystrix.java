package com.zw.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zw.ProductApp;
import com.zw.vo.Product;

@SpringBootTest(classes = {ProductApp.class})
@RunWith(SpringRunner.class)
public class TestHystrix {

	@Resource
	TestBean testBean;
	
	
	
	@Test
	public void test1() {
		Product product=testBean.get(100);
		System.out.println(product.getProductName());
		
		
		
	}
	
}
