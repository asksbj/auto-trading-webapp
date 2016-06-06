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


public class GetSaveCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		Model model = new Model();
		int[] carid=new int[3];
		int userid=Integer.parseInt(request.getParameter("userid"));
		carid=model.getSave(userid);
		KindofCar[] kcar=new KindofCar[carid.length];
		Car[] cars=new Car[carid.length];
		for(int i=0;i<carid.length;i++){
			cars[i]=model.getcaridCar(carid[i]);
			kcar[i]=model.getMykind(cars[i].getKindid());
		}
		List mpg=new ArrayList();
		List make=new ArrayList();
		List drivetype=new ArrayList();
		List price=new ArrayList();
		List mileage=new ArrayList();
		List carsid=new ArrayList();
		List name=new ArrayList();
		for(int i=0;i<cars.length;i++){
			mpg.add(i, kcar[i].getMPG());
		}
		for(int i=0;i<cars.length;i++){
			make.add(i, kcar[i].getMake());
		}
		for(int i=0;i<cars.length;i++){
			name.add(i, kcar[i].getModel());
		}
		for(int i=0;i<cars.length;i++){
			drivetype.add(i, kcar[i].getDrivetype());
		}
		for(int i=0;i<cars.length;i++){
			price.add(i, cars[i].getPrice());
		}
		for(int i=0;i<cars.length;i++){
			mileage.add(i, cars[i].getMileage());
		}
		for(int i=0;i<cars.length;i++){
			carsid.add(i, cars[i].getCarid());
		}
		String[][] info=new String[cars.length][7];
		for(int i=0;i<cars.length;i++){
			info[i][0]=Integer.toString((int)mpg.get(i));
			info[i][1]=(String)make.get(i);
			info[i][2]=(String)drivetype.get(i);
			info[i][3]=Integer.toString((int)price.get(i));
			info[i][4]=Integer.toString((int)mileage.get(i));
			info[i][5]=Integer.toString((int)carsid.get(i));
			info[i][6]=(String)name.get(i);
		}
		request.getSession().setAttribute("userid", Integer.toString(userid));
		request.getSession().setAttribute("info", info);
	    response.sendRedirect("Favourite.jsp");
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
