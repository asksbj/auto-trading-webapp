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


public class DeleteManageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int Carid=Integer.parseInt(request.getParameter("carid"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		Model model = new Model();
		if(model.deleteManage(Carid,userid)){
			String[][] info=new String[50][5];
			info=model.getManage(userid);
			request.getSession().setAttribute("userid", Integer.toString(userid));
			request.getSession().setAttribute("info", info);
		    response.sendRedirect("Manage_Cars.jsp");
	    }else {
			response.sendRedirect("errRegister.jsp");
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
