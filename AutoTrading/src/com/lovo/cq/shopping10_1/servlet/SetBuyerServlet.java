package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.User;


public class SetBuyerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int userid=Integer.parseInt(request.getParameter("userid"));
		Model model = new Model();
			if(model.addBuyer(userid)){
				//×¢²á³É¹¦
				List l=model.getMake();
				List ls=new ArrayList();
				List lm=new ArrayList();
				List ly=new ArrayList();
				ls.add(0, "Make");
				lm.add(0,"Model");
				ly.add(0,"Year");
				for(int i=0;i<l.size();i++){
					ls.add(i+1, l.get(i));
				}
				request.getSession().setAttribute("userid", Integer.toString(userid));
				request.getSession().setAttribute("Make",ls);
				request.getSession().setAttribute("Model",lm);
				request.getSession().setAttribute("Year",ly);
				response.sendRedirect("BuyACar.jsp");
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
