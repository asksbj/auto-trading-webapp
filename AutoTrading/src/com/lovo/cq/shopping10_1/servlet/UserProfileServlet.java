package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.daoimpl.ErrPwdException;
import com.lovo.cq.shopping10_1.daoimpl.NameNotFoundException;
import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.User;

public class UserProfileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户端提交过来的数据
		request.setCharacterEncoding("gb2312");
		int userid = Integer.parseInt(request.getParameter("userid"));
		User user=new User();
		Model model=new Model();
		user=model.getUser(userid);
		String name=user.getName();
		String email=user.getEmail();
		String lname=user.getLastname();
		String fname=user.getFirstname();
		String phone=user.getphone();
		int zipcode=user.getzipcode();
		String country=user.getCountry();
		String state=user.getState();
		String city=user.getCity();
		String add=user.getStreetadd();
			//System.out.println(user.getCity());
			//ServletContext context = this.getServletContext();
		request.getSession().setAttribute("userid", Integer.toString(userid));
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("lname", lname);
		request.getSession().setAttribute("fname", fname);
		request.getSession().setAttribute("phone", phone);
		request.getSession().setAttribute("zipcode", Integer.toString(zipcode));
		request.getSession().setAttribute("country", country);
		request.getSession().setAttribute("state", state);
		request.getSession().setAttribute("city", city);
		request.getSession().setAttribute("add", add);
		request.getSession().setAttribute("userid", Integer.toString(userid));
		response.sendRedirect("Userprofile.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
