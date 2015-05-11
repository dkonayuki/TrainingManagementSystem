package com.rakuten.PenguinSoldiers.config;

import static org.springframework.context.annotation.ComponentScan.Filter;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.*;
import org.springframework.stereotype.Controller;

import com.rakuten.PenguinSoldiers.Application;

@Configuration
@ComponentScan(basePackageClasses = Application.class, excludeFilters = @Filter({Controller.class, Configuration.class}))
class ApplicationConfig {
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		Resource[] cprs=new Resource[2];
		
		cprs[0]=new ClassPathResource("/persistence.properties");
		cprs[1]=new FileSystemResource("/usr/local/tomcat/persistence.properties");
		ppc.setLocations(cprs);
		ppc.setIgnoreResourceNotFound(true);
		ppc.setOrder(1);
		return ppc;
	}
	
	
	
}