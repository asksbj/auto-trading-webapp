package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.Dealer;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.User;
import com.lovo.cq.shopping10_1.po.Review;


public class RateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		int userid=Integer.parseInt(request.getParameter("userid"));
		Model model = new Model();
		Car[] cars=new Car[10];
		Dealer dealer=new Dealer();
		Review review=new Review();
		cars=model.getboughtCar(userid);
		
		List dealerid=new ArrayList();
		List dealername=new ArrayList();
		List logo=new ArrayList();
		List rate=new ArrayList();
		List content=new ArrayList();
		List carid=new ArrayList();
		for(int i=0;i<cars.length;i++){
			dealerid.add(i, cars[i].getSellerid());
			carid.add(i, cars[i].getCarid());
			dealer=model.getDealer(cars[i].getSellerid());
			review=model.getReview(userid, cars[i].getSellerid(), cars[i].getCarid());
			dealername.add(i, dealer.getCompany());
			logo.add(i, dealer.getLogo());
			rate.add(i, review.getRate());
			content.add(i, review.getContent());
		}
		String[][] info=new String[cars.length][7];
		for(int i=0;i<cars.length;i++){
			info[i][0]=Integer.toString((int)dealerid.get(i));
			info[i][1]=(String)dealername.get(i);
			info[i][2]=(String)logo.get(i);
			info[i][3]=Integer.toString((int)rate.get(i));
			info[i][4]=(String)content.get(i);
			info[i][5]=Integer.toString((int)carid.get(i));
			info[i][6]="area"+i;
		}
		request.getSession().setAttribute("info", info);
		request.getSession().setAttribute("userid", Integer.toString(userid));
		response.sendRedirect("Rate&Review.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
