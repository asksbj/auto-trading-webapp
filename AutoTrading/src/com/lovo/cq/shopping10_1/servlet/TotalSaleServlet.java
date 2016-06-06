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


public class TotalSaleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		Model model = new Model();
		KindofCar[] kcar=new KindofCar[100];
		Car[] cars=new Car[100];
		User[] buyers=new User[100];
		String userid=request.getParameter("userid");
		int dealerid=Integer.parseInt(userid);
		
		cars=model.getSoldcar(dealerid);
		for(int i=0;i<cars.length;i++){
			kcar[i]=model.getMykind(cars[i].getKindid());
			buyers[i]=model.getBuyers(cars[i].getCarid());
		}
		List Carid=new ArrayList();
		List Make=new ArrayList();
		List Model=new ArrayList();
		List Price=new ArrayList();
		List Buyerid=new ArrayList();
		List Buyername=new ArrayList();
		for(int i=0;i<cars.length;i++){
			Carid.add(i, cars[i].getCarid());
			Make.add(i, kcar[i].getMake());
			Model.add(i, kcar[i].getModel());
			Price.add(i, cars[i].getPrice());
			Buyerid.add(i, buyers[i].getId());
			Buyername.add(i, buyers[i].getName());
			
		}
		
		String[][] info=new String[cars.length][6];
		for(int i=0;i<cars.length;i++){
			info[i][0]=Integer.toString((int)Carid.get(i));
			info[i][1]=(String)Make.get(i);
			info[i][2]=(String)Model.get(i);
			info[i][3]=Integer.toString((int)Price.get(i));
			info[i][4]=Integer.toString((int)Buyerid.get(i));
			info[i][5]=(String)Buyername.get(i);
		}
		//System.out.println(cars[1].getPrice());
		//List cars=new ArrayList();
		request.getSession().setAttribute("userid", userid);
		request.getSession().setAttribute("info", info);
	    response.sendRedirect("Total_Sales_Report.jsp");
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
