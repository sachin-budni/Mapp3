package com.lara;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javafx.beans.binding.ListBinding;

public class GenderDAO 
{
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	private List<Gender> readAllGender() 
	{
		String sql="SELECT ID,NAME FROM GENDER";
		List<Gender> genders=template.query(sql, (ResultSet rs,int rowNum)->
		{
			Gender g1=new Gender();
			g1.setId(rs.getInt("Id"));
			g1.setName(rs.getString("name"));
			return g1;
		});
		return genders; 
	}
}
