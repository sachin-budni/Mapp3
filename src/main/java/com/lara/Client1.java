package com.lara;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Client1() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		GenderDAO genderDao=(GenderDAO) context.getBean("genderDao");
		PersonsDAO personDao=(PersonsDAO) context.getBean("personDao");
		
		Persons p1= new Persons();
		p1.setFirstName(firstName);
		p1.setLastName(lastName);
		p1.setAge(age);
		p1.setGenderId(gender);
		
		personDao.save(p1);
		out.println("Sucessfully added");
		System.out.println("Done");
	}
}
