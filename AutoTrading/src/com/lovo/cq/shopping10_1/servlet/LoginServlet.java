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
import com.lovo.cq.shopping10_1.po.Book;
import com.lovo.cq.shopping10_1.po.User;
import com.lovo.cq.shopping10_1.po.Dealer;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户端提交过来的数据
		request.setCharacterEncoding("gb2312");
		String name = request.getParameter("name");
		String password=request.getParameter("password");
		if(name==""){
			System.out.println("username is null");
			response.sendRedirect("login.jsp");
			return;
		}
		else if(password==""){
			System.out.println("password is null");
			response.sendRedirect("login.jsp");
			return;
		}
		//System.out.println(name+"."+password);
		Model model = new Model();
		try {
			User user = model.userLogin(name, password);
			user.setName(name);
			int Userid=user.getId();
			String userid=Integer.toString(user.getId());
			request.getSession().setAttribute("Name", name);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("userid", userid);
			response.sendRedirect("index.jsp");
		}catch (NameNotFoundException e) {
			try{
				Dealer dealer=model.dealerLogin(name, password);
				dealer.setName(name);
				int registernum=dealer.getId();
				Model model1=new Model();
				String[][] info=new String[10][4];
				info=model1.getBook(registernum);
				request.getSession().setAttribute("Name", name);
				request.getSession().setAttribute("registerid", Integer.toString(registernum));
				request.getSession().setAttribute("info", info);
				response.sendRedirect("DealerHomepage.jsp");
			}catch(Exception ex){request.setAttribute("NameNotFoundException",e.getMessage() );
			response.sendRedirect("login.jsp");
			return;
			}
			
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}catch(ErrPwdException e){
			request.setAttribute("ErrPwdException",e.getMessage() );
			response.sendRedirect("login.jsp");
			return;
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
