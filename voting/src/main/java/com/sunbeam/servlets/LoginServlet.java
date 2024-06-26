package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginServlet extends HttpServlet {

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
	//The request.getParameter() is being used here to retrieve form data from client side.
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		try(UserDao userDao = new UserDaoImpl()){
			User user = userDao.findByEmail(email);
			
			if(user != null && user.getPassword().equals(passwd)) {
				Cookie c = new Cookie("uname", user.getFirstName());
				c.setMaxAge(3600);
				resp.addCookie(c);// store cookie inside browser
				
				// session is server site method inside httpsession library
				HttpSession session = req.getSession();
				session.setAttribute("curuser", user);
				
				if(user.getRole().equals("voter")) {
					
					resp.sendRedirect("candlist");
					
			
				}else {
					// Admin login
					resp.sendRedirect("result");
				}
			}else {
				//Login failed 
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Invalid email or password. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
