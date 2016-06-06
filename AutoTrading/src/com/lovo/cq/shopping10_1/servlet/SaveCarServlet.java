package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.Dealer;
import com.lovo.cq.shopping10_1.po.User;


public class SaveCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int userid=Integer.parseInt(request.getParameter("userid"));
		int carid=Integer.parseInt(request.getParameter("carid"));
		Model model = new Model();
		if(model.addSave(carid, userid)){
			 request.getSession().setAttribute("userid", Integer.toString(userid));
			   response.sendRedirect("SearchResults.jsp");
		}
		else{
			 request.getSession().setAttribute("userid", Integer.toString(userid));
			   response.sendRedirect("SearchResults.jsp");
		}
	      
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
