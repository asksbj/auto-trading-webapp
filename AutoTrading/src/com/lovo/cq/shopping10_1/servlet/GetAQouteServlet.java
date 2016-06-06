package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.User;


public class GetAQouteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int userid=Integer.parseInt(request.getParameter("userid"));
		String make=request.getParameter("Make");
		String model=request.getParameter("Model");
		String year=request.getParameter("Year");
		String boughtyear=request.getParameter("BoughtYear");
		int mileage=Integer.parseInt(request.getParameter("Mileage"));
		int single=Integer.parseInt(request.getParameter("Single Owner"));
		Model model1 = new Model();
		KindofCar kcar=new KindofCar();
		kcar=model1.getKindofCar(make, model, year);
		int price=0;
		price=model1.getPrice(kcar.getKindid());
		price=(1-3*(2015-Integer.parseInt(boughtyear))/80)*price;
		double mileagecount=1-((int)mileage/20000)*0.05;
		double ownercount=1-(single-1)*0.05;
		price=(int)(price*mileagecount*ownercount);
		String Price="$"+price;
		request.getSession().setAttribute("price", Price);
		request.getSession().setAttribute("make", make);
		request.getSession().setAttribute("model", model);
		request.getSession().setAttribute("year", year);
		request.getSession().setAttribute("mileage", Integer.toString(mileage));
		request.getSession().setAttribute("boughtyear", boughtyear);
		request.getSession().setAttribute("singleowner", Integer.toString(single));
		request.getSession().setAttribute("userid", Integer.toString(userid));
		response.sendRedirect("GetAQuote.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
