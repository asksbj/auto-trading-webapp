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

public class AddNewCarrServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String Make = request.getParameter("make");
		String Model=request.getParameter("model");
		int Mileage = Integer.parseInt(request.getParameter("mileage"));
		int sellerid=Integer.parseInt(request.getParameter("userid"));
		//int sellerid=request.getParameter("userid");
		String Year=request.getParameter("year");
		String state=request.getParameter("state");
		int Price=Integer.parseInt(request.getParameter("price"));
		int kindid=0;
		Model model1=new Model();
		Car car = new Car();
		if(model1.addCar(Make,Model,Year,sellerid,Mileage,state,Price)){
				response.sendRedirect("DealerHomepage.jsp");
		}else {
				//×¢²áÊ§°Ü
			response.sendRedirect("DealerHomepage.jsp");
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
