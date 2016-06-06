package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.User;


public class UpdateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int userid=Integer.parseInt(request.getParameter("userid"));
		System.out.println(userid);
		String email = request.getParameter("email");
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String phone=request.getParameter("phone");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String streetadd = request.getParameter("address");
		User user = new User();
		user.setId(userid);
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
		if(model.updateUser(user)){
				//×¢²á³É¹¦
			request.getSession().setAttribute("userid", Integer.toString(userid));
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("lname", lastname);
			request.getSession().setAttribute("fname", firstname);
			request.getSession().setAttribute("phone", phone);
			request.getSession().setAttribute("zipcode", Integer.toString(zipcode));
			request.getSession().setAttribute("country", country);
			request.getSession().setAttribute("state", state);
			request.getSession().setAttribute("city", city);
			request.getSession().setAttribute("add", streetadd);
			request.getSession().setAttribute("userid", Integer.toString(userid));
			response.sendRedirect("Userprofile.jsp");
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
