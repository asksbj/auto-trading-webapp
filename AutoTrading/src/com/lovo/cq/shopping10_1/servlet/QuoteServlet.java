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
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;


public class QuoteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String userid=request.getParameter("userid");
		String price="";
		request.getSession().setAttribute("userid", userid);
		request.getSession().setAttribute("price", price);
		request.getSession().setAttribute("make", "");
		request.getSession().setAttribute("model", "");
		request.getSession().setAttribute("year", "");
		request.getSession().setAttribute("mileage", "");
		request.getSession().setAttribute("boughtyear", "");
		request.getSession().setAttribute("singleowner", "");

		//request.getSession().setAttribute("Make",ls);
	    //request.getSession().setAttribute("Model",lss);
	    response.sendRedirect("GetAQuote.jsp");
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
