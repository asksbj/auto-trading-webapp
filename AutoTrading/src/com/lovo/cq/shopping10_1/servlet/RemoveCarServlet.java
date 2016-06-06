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


public class RemoveCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int Carid=Integer.parseInt(request.getParameter("carid"));
		int sellerid=Integer.parseInt(request.getParameter("userid"));
		int kindid=0;
		Model model = new Model();
		if(model.removeCar(Carid)){
			Model model2 = new Model();
			Car[] cars=new Car[4];
			if(model2.addSeller(sellerid)){
				cars=model2.getMycar(sellerid);
				KindofCar[] kcar=new KindofCar[cars.length];
				for(int i=0;i<cars.length;i++){
					kcar[i]=new KindofCar();
					kindid=cars[i].getKindid();
					kcar[i]=model2.getMykind(kindid);
				}
				List mpg=new ArrayList();
				List make=new ArrayList();
				List drivetype=new ArrayList();
				List price=new ArrayList();
				List mileage=new ArrayList();
				List carid=new ArrayList();
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
					carid.add(i, cars[i].getCarid());
				}
				String[][] info=new String[cars.length][7];
				for(int i=0;i<cars.length;i++){
					info[i][0]=Integer.toString((int)mpg.get(i));
					info[i][1]=(String)make.get(i);
					info[i][2]=(String)drivetype.get(i);
					info[i][3]=Integer.toString((int)price.get(i));
					info[i][4]=Integer.toString((int)mileage.get(i));
					info[i][5]=Integer.toString((int)carid.get(i));
					info[i][6]=(String)name.get(i);
				}
				//System.out.println(cars[1].getPrice());
				//List cars=new ArrayList();
				request.getSession().setAttribute("userid", Integer.toString(sellerid));
				request.getSession().setAttribute("cars", cars);
				request.getSession().setAttribute("mpg", mpg);
				request.getSession().setAttribute("make", make);
				request.getSession().setAttribute("drivetype", drivetype);
				request.getSession().setAttribute("price", price);
				request.getSession().setAttribute("model", name);
				request.getSession().setAttribute("info", info);
				response.sendRedirect("SellACar.jsp");
			}else {
				//×¢²áÊ§°Ü
				response.sendRedirect("errRegister.jsp");
			}	
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
