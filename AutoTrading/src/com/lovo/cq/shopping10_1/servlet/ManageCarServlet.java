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


public class ManageCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		Model model = new Model();
		int userid=Integer.parseInt(request.getParameter("userid"));
		String[][] info=new String[50][5];
		info=model.getManage(userid);
		request.getSession().setAttribute("userid", Integer.toString(userid));
		request.getSession().setAttribute("info", info);
	    response.sendRedirect("Manage_Cars.jsp");
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
