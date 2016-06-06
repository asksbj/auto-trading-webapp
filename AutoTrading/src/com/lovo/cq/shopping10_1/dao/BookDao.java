package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Book;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.User;

public interface BookDao {
	
	public boolean addBook(int carid, int buyerid, int soldby, int price);
	
	public String[][] getBook(int dealerid);
	
	public Book getCarBook(int carid);
	
	public Book[] getMyBook(int userid);
	
	public boolean confirmBook(int carid);
	
	public boolean denyBook(int carid);

}
