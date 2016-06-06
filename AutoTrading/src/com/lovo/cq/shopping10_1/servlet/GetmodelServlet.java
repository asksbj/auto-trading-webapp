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


public class GetmodelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String make=request.getParameter("Make");
		String userid=request.getParameter("userid");
		Model model = new Model();
		List lmake=model.getMake();
		List lmodel=model.getModel(make);
		List lyear=model.getYear(make);
		List ls=new ArrayList();
		List lss=new ArrayList();
		List ly=new ArrayList();
		ls.add(0, make);
		lss.add(0, "Model");
		ly.add(0,"year");
		for(int i=0;i<lmake.size();i++){
			ls.add(i+1, lmake.get(i));
		}
		for(int i=0;i<lmodel.size();i++){
			lss.add(i+1, lmodel.get(i));
		}
		for(int i=0;i<lyear.size();i++){
			ly.add(i+1, lyear.get(i));
		}
		request.getSession().setAttribute("userid", userid);
		request.getSession().setAttribute("Make",ls);
	    request.getSession().setAttribute("Model",lss);
	    request.getSession().setAttribute("Year", ly);
	    request.getSession().setAttribute("gmake", make);
	    response.sendRedirect("BuyACar.jsp");
		/*String[] Make=model.getModel();
		List l=new ArrayList();
		l=Arrays.asList(Make);
		request.getSession().setAttribute("Make",l);
		response.sendRedirect("BuyACar.jsp");*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
