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


public class RemoveCompareServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int Caid=Integer.parseInt(request.getParameter("carid"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		int kindid=0;
		Model model1 = new Model();
		System.out.println(Caid);
		if(model1.removeCompare(userid, Caid)){
			Model model = new Model();
			int[] carid=new int[3];
			carid=model.getCompare(userid);
			KindofCar[] kcar=new KindofCar[carid.length];
			Car[] cars=new Car[carid.length];
			for(int i=0;i<carid.length;i++){
				cars[i]=model.getcaridCar(carid[i]);
				kcar[i]=model.getMykind(cars[i].getKindid());
			}
			List mpg=new ArrayList();
			List Make=new ArrayList();
			List Model=new ArrayList();
			List Year=new ArrayList();
			List Mileage=new ArrayList();
			List Carid=new ArrayList();
			List Drivetype=new ArrayList();
			List Price=new ArrayList();
			int[] mp=new int[100];
			String[] MAKE=new String[100];
			String[] MODEL=new String[100];
			String[] YEAR=new String[100];
			int[] MILEAGE=new int[100];
			String[] DRIVETYPE=new String[100];
			int[] prices=new int[100];
			String[] PRICE=new String[100];
			String[] MILEAGES=new String[100];
			String[] MPG=new String[100];
			for(int i=0;i<3;i++){
				mp[i]=kcar[i].getMPG();
				if(mp[i]==0)
					MPG[i]="";
				else
					MPG[i]=Integer.toString(mp[i]);
				MAKE[i]=kcar[i].getMake();
				if(MAKE[i]==null)
					MAKE[i]="";
				MODEL[i]=kcar[i].getModel();
				if(MODEL[i]==null)
					MODEL[i]="";
				YEAR[i]=kcar[i].getYear();
				if(YEAR[i]==null)
					YEAR[i]="";
				MILEAGE[i]=cars[i].getMileage();
				if(MILEAGE[i]==0)
					MILEAGES[i]="";
				else
					MILEAGES[i]=Integer.toString(MILEAGE[i]);
				DRIVETYPE[i]=kcar[i].getDrivetype();
				if(DRIVETYPE[i]==null)
					DRIVETYPE[i]="";
				prices[i]=cars[i].getPrice();
				if(prices[i]==0)
					PRICE[i]="";
				else
					PRICE[i]=Integer.toString(prices[i]);
			}
			for(int i=0;i<cars.length;i++){
				Make.add(i, MAKE[i]);
				Model.add(i, MODEL[i]);
				Year.add(i, YEAR[i]);
				mpg.add(i, MPG[i]);
				Drivetype.add(i, DRIVETYPE[i]);
				Mileage.add(i, MILEAGES[i]);
				Carid.add(i, cars[i].getCarid());
				Price.add(i, PRICE[i]);
			}
			String[][] info=new String[cars.length][8];
			for(int i=0;i<cars.length;i++){
				info[i][0]=(String)Make.get(i);
				info[i][1]=(String)Model.get(i);
				info[i][2]=(String)Year.get(i);
				info[i][3]=(String)mpg.get(i);
				info[i][4]=(String)Drivetype.get(i);
				info[i][5]=(String)Mileage.get(i);
				info[i][6]=(String)Price.get(i);
				info[i][7]=Integer.toString((int)Carid.get(i));
			}
			request.getSession().setAttribute("userid", Integer.toString(userid));
			request.getSession().setAttribute("info", info);
		    response.sendRedirect("CompareCars.jsp");
			}else {
				response.sendRedirect("CompareCars.jsp");
			}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
