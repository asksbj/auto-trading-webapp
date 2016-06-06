package com.lovo.cq.shopping10_1.model;

import java.util.List;

import com.lovo.cq.shopping10_1.dao.BookDao;
import com.lovo.cq.shopping10_1.dao.ReviewDao;
import com.lovo.cq.shopping10_1.dao.UserDao;
import com.lovo.cq.shopping10_1.dao.CarDao;
import com.lovo.cq.shopping10_1.daoimpl.BookDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.ReviewDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.UserDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.CarDaoImpl;
import com.lovo.cq.shopping10_1.po.User;
import com.lovo.cq.shopping10_1.po.Dealer;
import com.lovo.cq.shopping10_1.po.Review;
import com.lovo.cq.shopping10_1.po.Book;

import java.util.Map;






import com.lovo.cq.shopping10_1.dao.DealerDao;
import com.lovo.cq.shopping10_1.daoimpl.DealerDaoImpl;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.UserPager;

public class Model {
	private UserDao ud = new UserDaoImpl();
	private CarDao cd = new CarDaoImpl();
	private DealerDao dd=new DealerDaoImpl();
	private ReviewDao rd=new ReviewDaoImpl();
	private BookDao bd=new BookDaoImpl();

	//ÓÃ»§×¢²á

	public User userLogin(String name,String password) {
		return ud.userLogin(name,password);
	}
	
	public boolean addUser(User user) {
		return ud.addUser(user);
	}
	
	public boolean addBuyer(int userid){
		return ud.addBuyer(userid);
	}
	
	public boolean addSeller(int userid){
		return ud.addSeller(userid);
	}

	
	public User getUser(int userid){
		return ud.getUser(userid);
	}
	
	public User getBuyers(int carid){
		return ud.getBuyers(carid);
	}
	
	public boolean updateUser(User user){
		return ud.updateUser(user);
	}
	
	public Dealer dealerLogin(String name,String password){
		return dd.dealerLogin(name,password);
	}
	
	
	public Dealer getDealer(int dealerid){
		return dd.getDealer(dealerid);
	}
	
	public String[][] bestDealers(){
		return dd.bestDealers();
	}
	
	public String[][] getTrendTotal(int dealerid){
		return dd.getTrendTotal(dealerid);
	}
	
	public String[][] getTrendType(int dealerid){
		return dd.getTrendType(dealerid);
	}
	
	public String[][] getManage(int dealerid){
		return dd.getManage(dealerid);
	}
	
	public KindofCar[] popularCar(){
		return cd.popularCar();
	}
	
	public List getMake(){
		return cd.getMake();
	}
	
	public List getModel(String make){
		return cd.getModel(make);
	}
	
	public List getYear(String make){
		return cd.getYear(make);
	}
	
	public KindofCar getKindofCar(String make, String model,String year){
		return cd.getKindofCar(make, model, year);
	}
	
	public KindofCar getMykind(int kindid){
		return cd.getMykind(kindid);
	}
	
	public Car[] getCar(String make,String model,int price1,int price2){
		return cd.getCar(make, model, price1, price2);
	}
	
	public Car[] getMycar(int sellerid){
		return cd.getMycar(sellerid);
	}
	
	public Car[] getSoldcar(int sellerid){
		return cd.getSoldcar(sellerid);
	}
	
	public Car[] getboughtCar(int buyerid){
		return cd.getboughtCar(buyerid);
	}
	
	public Car getcaridCar(int carid){
		return cd.getcaridCar(carid);
	}
	
	public int getPrice(int kindid){
		return cd.getPrice(kindid);
	}
	
	public boolean addCar(String make, String model, String year, int sellerid, int mileage, String state, int price){
		return cd.addCar(make, model, year, sellerid, mileage, state, price);
	}
	
	public boolean removeCar(int carid){
		return cd.removeCar(carid);
	}
	
	public boolean removeSave(int carid, int userid){
		return cd.removeSave(carid,userid);
	}
	
	public boolean removeCompare(int userid, int carid){
		return cd.removeCompare(userid,carid);
	}
	
	public boolean deleteManage(int carid, int userid){
		return cd.deleteManage(carid, userid);
	}
	
	public boolean addCompare(int userid, int carid){
		return cd.addCompare(userid, carid);
	}
	
	public int[] getCompare(int userid){
		return cd.getCompare(userid);
	}
	
	public boolean addSave(int userid, int carid){
		return cd.addSave(userid, carid);
	}
	
	public int[] getSave(int userid){
		return cd.getSave(userid);
	}

	public Review getReview(int userid, int dealerid, int carid){
		return rd.getReview(userid,dealerid, carid);
	}
	
	public boolean updateReview(int reviwer, int reviewee, int rate, String content, int carid){
		return rd.updateReview(reviwer, reviewee, rate, content, carid);
	}
	
	public boolean addBook(int carid, int buyerid, int soldby, int price){
		return bd.addBook(carid, buyerid, soldby, price);
	}
	
	public String[][] getBook(int dealerid){
		return bd.getBook(dealerid);
	}
	
	public boolean confirmBook(int carid){
		return bd.confirmBook(carid);
	}
	
	public boolean denyBook(int carid){
		return bd.denyBook(carid);
	}
	
	public Book getCarBook(int carid){
		return bd.getCarBook(carid);
	}
	
	public Book[] getMyBook(int userid){
		return bd.getMyBook(userid);
	}
}
