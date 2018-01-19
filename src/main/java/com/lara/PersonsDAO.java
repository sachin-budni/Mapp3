package com.lara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonsDAO 
{
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void save(Persons p1)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO PERSON VALUES(");
		sql.append("'"+p1.getFirstName()+"',");
		sql.append("'"+p1.getLastName()+"',");
		sql.append(p1.getAge()+",");
		sql.append(p1.getGenderId()+")");
		template.update(sql.toString());
	}
}
