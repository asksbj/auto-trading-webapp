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


public class SearchResultsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		Model model = new Model();
		KindofCar kcar=new KindofCar();
		Car[] cars=new Car[4];
		String userid=request.getParameter("userid");
		String gmake=request.getParameter("gmake");
		String gmodel=request.getParameter("gmodel");
		String gprice=request.getParameter("gprice");
		String gyear=request.getParameter("gyear");
		int price1=0,price2=0;
		String[] Price;
		
		if(!gprice.equals("Price")){
			Price=gprice.split("-");
			price1=Integer.parseInt(Price[0]);
			price2=Integer.parseInt(Price[1]);
		}
		
		kcar=model.getKindofCar(gmake, gmodel, gyear);
		cars=model.getCar(gmake, gmodel, price1, price2);
		List mpg=new ArrayList();
		List make=new ArrayList();
		List drivetype=new ArrayList();
		List price=new ArrayList();
		List mileage=new ArrayList();
		List name=new ArrayList();
		List sellerid=new ArrayList();
		List carid=new ArrayList();
		for(int i=0;i<cars.length;i++){
			mpg.add(i, kcar.getMPG());
		}
		for(int i=0;i<cars.length;i++){
			make.add(i, kcar.getMake());
		}
		for(int i=0;i<cars.length;i++){
			name.add(i, kcar.getModel());
		}
		for(int i=0;i<cars.length;i++){
			drivetype.add(i, kcar.getDrivetype());
		}
		for(int i=0;i<cars.length;i++){
			price.add(i, cars[i].getPrice());
		}
		for(int i=0;i<cars.length;i++){
			mileage.add(i, cars[i].getMileage());
		}
		for(int i=0;i<cars.length;i++){
			sellerid.add(i, cars[i].getSellerid());
		}
		for(int i=0;i<cars.length;i++){
			carid.add(i, cars[i].getCarid());
		}
		String[][] info=new String[cars.length][8];
		for(int i=0;i<cars.length;i++){
			info[i][0]=Integer.toString((int)mpg.get(i));
			info[i][1]=(String)make.get(i);
			info[i][2]=(String)drivetype.get(i);
			info[i][3]=Integer.toString((int)price.get(i));
			info[i][4]=Integer.toString((int)mileage.get(i));
			info[i][5]=(String)name.get(i);
			info[i][6]=Integer.toString((int)sellerid.get(i));
			info[i][7]=Integer.toString((int)carid.get(i));
		}
		//System.out.println(cars[1].getPrice());
		//List cars=new ArrayList();
		request.getSession().setAttribute("cars", cars);
		request.getSession().setAttribute("userid", userid);
		request.getSession().setAttribute("mpg", mpg);
		request.getSession().setAttribute("make", make);
		request.getSession().setAttribute("drivetype", drivetype);
		request.getSession().setAttribute("price", price);
		request.getSession().setAttribute("model", name);
		request.getSession().setAttribute("info", info);
	   

		//request.getSession().setAttribute("Make",ls);
	    //request.getSession().setAttribute("Model",lss);
	    response.sendRedirect("SearchResults.jsp");
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
