package com.kishoreb.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.kishoreb.dao")
public class Config {
@Bean
DriverManagerDataSource source1() {
	DriverManagerDataSource da=new DriverManagerDataSource();
	da.setUrl("jdbc:mysql://localhost:3306/history?characterEncoding=utf8");
	da.setUsername("root");
	da.setPassword("kishore");
	
	return da;
}
@Bean
JdbcTemplate temp() {
	JdbcTemplate tem=new JdbcTemplate();
	tem.setDataSource(source1());
	return tem;
}
	
}
