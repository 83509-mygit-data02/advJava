package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.pojos.User;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		java.util.Date birth = null;
		try {
			birth = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int status = 0;
		String role = req.getParameter("role");
		User u = new User(firstName,lastName,email,password, birth,status,role);
		
	}
}
