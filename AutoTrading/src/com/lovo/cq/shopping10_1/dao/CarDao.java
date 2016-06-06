package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.User;

public interface CarDao {
	
	public List getMake();
	
	public List getModel(String make);
	
	public List getYear(String make);
	
	public KindofCar getKindofCar(String make, String model,String year);
	
	public KindofCar getMykind(int kindid);
	
	public Car[] getCar(String make,String model, int price1,int price2);
	
	public Car[] getMycar(int sellerid);
	
	public Car[] getSoldcar(int sellerid);
	
	public Car[] getboughtCar(int buyerid);
	
	public Car getcaridCar(int carid);
	
	public int getPrice(int kindid);
	
	public boolean addCar(String make, String model, String year, int sellerid, int mileage, String state, int price);
	
	public boolean removeCar(int carid);
	
	public boolean removeSave(int carid,int userid);
	
	public boolean removeCompare(int userid,int carid);
	
	public boolean deleteManage(int carid,int userid);
	
	public KindofCar[] popularCar();
	
	public boolean addCompare(int userid, int carid);
	
	public int[] getCompare(int userid);
	
	public int[] getSave(int userid);
	
	public boolean addSave(int userid, int carid);

}
