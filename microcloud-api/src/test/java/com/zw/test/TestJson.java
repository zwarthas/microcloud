package com.zw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.alibaba.fastjson.JSONArray;
import com.zw.vo.Product;

@RunWith(JUnit4.class)
public class TestJson {

	@Test
	public void toJson() {
		Product product=new Product();
		product.setProductName("大虎逼");
		product.setProductDesc("asdfas");
		Object obj = JSONArray.toJSON(product);
        String json = obj.toString();
        System.out.println(json);
	}
	
}
