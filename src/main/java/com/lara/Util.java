package com.lara;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Util {
	private static JdbcTemplate template;
	static
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		template = (JdbcTemplate) context.getBean("template");
	}
	public static JdbcTemplate getTemplate()
	{
		return template;
	}

}
