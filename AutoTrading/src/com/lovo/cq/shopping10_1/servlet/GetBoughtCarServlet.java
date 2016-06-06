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
import com.lovo.cq.shopping10_1.po.Book;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.Dealer;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.User;


public class GetBoughtCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int userid=Integer.parseInt(request.getParameter("userid"));
		int kindid=0;
		int dealerid=0;
		int carid=0;
		Model model = new Model();
		Car[] cars=new Car[10];
		KindofCar[] kcar=new KindofCar[10];
		Dealer[] dealer=new Dealer[10];
		Book[] book=new Book[10];
		book=model.getMyBook(userid);
		for(int i=0;i<book.length;i++){
			cars[i]=new Car();
			carid=book[i].getCarid();
			cars[i]=model.getcaridCar(carid);
			kcar[i]=new KindofCar();
			kindid=cars[i].getKindid();
			kcar[i]=model.getMykind(kindid);
			dealer[i]=new Dealer();
			dealerid=cars[i].getSellerid();
			dealer[i]=model.getDealer(dealerid);
		}
		List Carid=new ArrayList();
		List Make=new ArrayList();
		List Model=new ArrayList();
		List Dealername=new ArrayList();
		List State=new ArrayList();
		for(int i=0;i<book.length;i++){
			Carid.add(i,cars[i].getCarid());
			Make.add(i,kcar[i].getMake());
			Model.add(i, kcar[i].getModel());
			Dealername.add(i, dealer[i].getCompany());
			State.add(i, book[i].getState());
		}
		String[][] info=new String[book.length][5];
		for(int i=0;i<book.length;i++){
			info[i][0]=Integer.toString((int)Carid.get(i));
			info[i][1]=(String)Make.get(i);
			info[i][2]=(String)Model.get(i);
			info[i][3]=(String)Dealername.get(i);
			info[i][4]=(String)State.get(i);
		}
				//System.out.println(cars[1].getPrice());
				//List cars=new ArrayList();
				request.getSession().setAttribute("userid", Integer.toString(userid));
				request.getSession().setAttribute("info", info);
				response.sendRedirect("My Cars.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
