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
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.User;


public class PopularCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String userid=request.getParameter("userid");
		Model model = new Model();
		KindofCar[] kcars=new KindofCar[5];
		kcars=model.popularCar();	
		String[][] info=new String[5][4];
		for(int i=0;i<5;i++){
			info[i][0]=Integer.toString(kcars[i].getKindid());
			info[i][1]=kcars[i].getMake();
			info[i][2]=kcars[i].getModel();
			info[i][3]=kcars[i].getYear();
		}
	    request.getSession().setAttribute("info", info);
	    request.getSession().setAttribute("userid", userid);
		response.sendRedirect("PopularCar.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
