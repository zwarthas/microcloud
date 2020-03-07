package com.zw.test;

import java.util.Map;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class PersonImportBean implements ImportBeanDefinitionRegistrar{

	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		
		System.out.println(metadata.getClassName());
		Map<String, Object> defaultAttrs = metadata
				.getAnnotationAttributes(Configuration.class.getName(), true);
		RootBeanDefinition beanDefinition=new RootBeanDefinition(Person.class);
		registry.registerBeanDefinition("person", beanDefinition);
		
	}

}
