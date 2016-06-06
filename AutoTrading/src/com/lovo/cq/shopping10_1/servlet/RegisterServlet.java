package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.User;


public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String name = request.getParameter("name");
		String password=request.getParameter("password");
		String email = request.getParameter("email");
		String firstname=request.getParameter("firstName");
		String lastname=request.getParameter("lastName");
		String phone=request.getParameter("phone");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String streetadd = request.getParameter("address");
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setPhone(phone);
			user.setzipcode(zipcode);
			user.setCountry(country);
			user.setState(state);
			user.setCity(city);
			user.setStreetadd(streetadd);
			Model model = new Model();
			if(model.addUser(user)){
				//×¢²á³É¹¦
				request.getSession().setAttribute("user", user);
				response.sendRedirect("login.jsp");
			}else {
				//×¢²áÊ§°Ü
				response.sendRedirect("errRegister.jsp");
			}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
