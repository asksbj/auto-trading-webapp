package com.lovo.cq.shopping10_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.dao.CarDao;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;

public class CarDaoImpl implements CarDao{
	public List getMake(){
		String[] make=new String[193];
		List l=new ArrayList();
		int i=0;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		try{
			dbUtil = new DbUtil();
			String sql="select distinct make from kindofcar order by ascii(lower(make))";
			pre=dbUtil.getCon().prepareStatement(sql);
			result=pre.executeQuery();
			result.getRow();
			while(result.next()){
				make[i]=result.getString("make");
				i++;
			};
			l=Arrays.asList(make);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;
	}
	
	public List getModel(String make){
		String[] model=new String[150];
		List l=new ArrayList();
		int i=0;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		try{
			dbUtil = new DbUtil();
			String sql="select distinct model from kindofcar where make=? order by ascii(lower(model)) ";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setString(1, make);
			result=pre.executeQuery();
			while(result.next()){
				model[i]=result.getString("model");
				i++;
			};
			l=Arrays.asList(model);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;
	}
	
	public List getYear(String make){
		String[] year=new String[150];
		List l=new ArrayList();
		int i=0;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		try{
			dbUtil = new DbUtil();
			String sql="select distinct year from kindofcar where make=? order by year";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setString(1, make);
			result=pre.executeQuery();
			while(result.next()){
				year[i]=result.getString("year");
				i++;
			};
			l=Arrays.asList(year);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;
	}
	
	public KindofCar getKindofCar(String make, String model,String year){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		KindofCar kcar=new KindofCar();
		try{
			dbUtil=new DbUtil();
			String sql="select * from kindofcar where make=? and model=? and year=?";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setString(1, make);
			pre.setString(2, model);
			pre.setString(3, year);
			result=pre.executeQuery();
			if(result.next()){
				kcar.setKindid(result.getInt("kindid"));
				kcar.setMake(result.getString("make"));
				kcar.setModel(result.getString("model"));
				kcar.setYear(result.getString("year"));
				kcar.setBodystyle(result.getString("bodystyle"));
				kcar.setColor(result.getString("color"));
				kcar.setDrivetype(result.getString("drivetype"));
				kcar.setEngine(result.getString("engine"));
				kcar.setMPG(result.getInt("mpg"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kcar;
	}
	
	public KindofCar getMykind(int kindid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		KindofCar kcar=new KindofCar();
		try{
			dbUtil=new DbUtil();
			String sql="select * from kindofcar where kindid=?";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, kindid);
			result=pre.executeQuery();
			if(result.next()){
			    kcar.setKindid(result.getInt("kindid"));
			    kcar.setMake(result.getString("make"));
			    kcar.setModel(result.getString("model"));
			    kcar.setYear(result.getString("year"));
			    kcar.setBodystyle(result.getString("bodystyle"));
			    kcar.setColor(result.getString("color"));
			    kcar.setDrivetype(result.getString("drivetype"));
			    kcar.setEngine(result.getString("engine"));
			    kcar.setMPG(result.getInt("mpg"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kcar;
	}
	
	public Car[] getCar(String make,String model,int price1,int price2){
		DbUtil dbUtil = null;
		PreparedStatement pre1 = null;
		PreparedStatement pre2 = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		Car[] cars=new Car[4];
		for(int i=0;i<4;i++){
			cars[i]=new Car();
		}
		int i=0;
		int kindid;
		try{
			dbUtil=new DbUtil();
			String sql1="select kindid from kindofcar where make=? and model=?";
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setString(1, make);
			pre1.setString(2, model);
			result1=pre1.executeQuery();
			if(result1.next()){
				kindid=result1.getInt("kindid");
				String sql2="select * from car where kindid=? and price>=? and price<=? and state='avaliable'";
				pre2=dbUtil.getCon().prepareStatement(sql2);
				pre2.setInt(1, kindid);
				pre2.setInt(2, price1);
				pre2.setInt(3, price2);
				result2=pre2.executeQuery();
				while(result2.next()){
					cars[i].setCarid(result2.getInt("carid"));
				    cars[i].setKindid(result2.getInt("kindid"));
				    cars[i].setSellerid(result2.getInt("soldby"));
				    cars[i].setMileage(result2.getInt("mileage"));
				    cars[i].setBuyerid(result2.getInt("boughtby"));
				    cars[i].setState(result2.getString("state"));
				    cars[i].setPrice(result2.getInt("price"));
				    i++;
				}
				pre2.close();
				result2.close();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre1.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Car[] car=new Car[i];
		for(int j=0;j<i;j++){
			car[j]=cars[j];
		}
		return car;
	}
	
	public Car[] getMycar(int sellerid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		Car[] cars=new Car[4];
		for(int i=0;i<4;i++){
			cars[i]=new Car();
		}
		int i=0;
		int kindid;
		try{
			dbUtil=new DbUtil();
			String sql1="select * from car where soldby=?";
			pre=dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, sellerid);
			result=pre.executeQuery();
			while(result.next()){
				cars[i].setCarid(result.getInt("carid"));
			    cars[i].setKindid(result.getInt("kindid"));
			    cars[i].setSellerid(result.getInt("soldby"));
			    cars[i].setMileage(result.getInt("mileage"));
			    cars[i].setBuyerid(result.getInt("boughtby"));
			    cars[i].setState(result.getString("state"));
			    cars[i].setPrice(result.getInt("price"));
			    i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Car[] car=new Car[i];
		for(int j=0;j<i;j++){
			car[j]=cars[j];
		}
		return car;
	}
	
	public Car[] getSoldcar(int sellerid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		Car[] cars=new Car[100];
		for(int i=0;i<100;i++){
			cars[i]=new Car();
		}
		int i=0;
		int kindid;
		try{
			dbUtil=new DbUtil();
			String sql1="select * from car where soldby=? and state='sold'";
			pre=dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, sellerid);
			result=pre.executeQuery();
			while(result.next()){
				cars[i].setCarid(result.getInt("carid"));
			    cars[i].setKindid(result.getInt("kindid"));
			    cars[i].setSellerid(result.getInt("soldby"));
			    cars[i].setMileage(result.getInt("mileage"));
			    cars[i].setBuyerid(result.getInt("boughtby"));
			    cars[i].setState(result.getString("state"));
			    cars[i].setPrice(result.getInt("price"));
			    i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Car[] car=new Car[i];
		for(int j=0;j<i;j++){
			car[j]=cars[j];
		}
		return car;
	}
	
	public Car[] getboughtCar(int buyerid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		Car[] cars=new Car[10];
		for(int i=0;i<10;i++){
			cars[i]=new Car();
		}
		int i=0;
		int kindid;
		try{
			dbUtil=new DbUtil();
			String sql1="select * from car where boughtby=?";
			pre=dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, buyerid);
			result=pre.executeQuery();
			while(result.next()){
				cars[i].setCarid(result.getInt("carid"));
			    cars[i].setKindid(result.getInt("kindid"));
			    cars[i].setSellerid(result.getInt("soldby"));
			    cars[i].setMileage(result.getInt("mileage"));
			    cars[i].setBuyerid(result.getInt("boughtby"));
			    cars[i].setState(result.getString("state"));
			    cars[i].setPrice(result.getInt("price"));
			    i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Car[] car=new Car[i];
		for(int j=0;j<i;j++){
			car[j]=cars[j];
		}
		return car;
	}
	
	public Car getcaridCar(int carid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		Car car=new Car();
		try{
			dbUtil=new DbUtil();
			String sql1="select * from car where carid=?";
			pre=dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, carid);
			result=pre.executeQuery();
			while(result.next()){
				car.setCarid(result.getInt("carid"));
			    car.setKindid(result.getInt("kindid"));
			    car.setSellerid(result.getInt("soldby"));
			    car.setMileage(result.getInt("mileage"));
			    car.setBuyerid(result.getInt("boughtby"));
			    car.setState(result.getString("state"));
			    car.setPrice(result.getInt("price"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return car;
	}
	
	public int getPrice(int kindid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		int price=0;
		try{
			dbUtil=new DbUtil();
			String sql1="select avg(price) as avgp from car where kindid=? and mileage=0 group by kindid";
			pre=dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, kindid);
			result=pre.executeQuery();
			if(result.next()){
				price=result.getInt("avgp");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return price;
	}
	
	public boolean addCar(String make, String model, String year, int sellerid, int mileage, String state, int price){
		boolean flag = false;
		int countid=0,setid=0;
		int kindid;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "select max(carid) as mid from car";
			pre = dbUtil.getCon().prepareStatement(sql1);
			result = pre.executeQuery();
			result.next();	   
		    countid=result.getInt("mid");
			setid=countid+1;
			pre.close();
			result.close();
			String sql2 = "select kindid from kindofcar where make=? and model=?and year=?";
			pre = dbUtil.getCon().prepareStatement(sql2);
			pre.setString(1,make);
			pre.setString(2, model);
			pre.setString(3, year);
			result = pre.executeQuery();
			result.next();
			kindid=result.getInt("kindid");
			pre.close();
			result.close();
			String sql3= "insert into car values(?,?,?,?,?,?,?,?)";
			pre= dbUtil.getCon().prepareStatement(sql3);
			pre.setInt(1, setid);
			pre.setInt(2, kindid);
			pre.setInt(3, sellerid);
			pre.setInt(4, mileage);
			pre.setString(5, null);
			pre.setString(6, state);
			pre.setInt(7, price);
			pre.setString(8, null);
			int i = pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
	
	public boolean removeCar(int carid){
		boolean flag = false;
		int kindid;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "delete from car where carid=?";
			pre = dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, carid);
			int i = pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
	   }
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
	
	
	
	public KindofCar[] popularCar(){
		DbUtil dbUtil = null;
		PreparedStatement pre1 = null;
		PreparedStatement pre2 = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		KindofCar[] kcars=new KindofCar[5];
		String sql1="select kindid from (select kindid from car where boughtby is not null group by kindid order by(count(*)) desc) where rownum<6";
		String sql2="select * from kindofcar where kindid=?";
		for(int i=0;i<5;i++){
			kcars[i]=new KindofCar();
		}
		int i=0;
		int kindid;
		try{
			dbUtil=new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			result1=pre1.executeQuery();
			while(result1.next()){
				kindid=result1.getInt("kindid");
				pre2=dbUtil.getCon().prepareStatement(sql2);
				pre2.setInt(1, kindid);
				result2=pre2.executeQuery();
				result2.next();
				kcars[i].setMake(result2.getString("make"));
				kcars[i].setModel(result2.getString("model"));
				kcars[i].setYear(result2.getString("year"));
				kcars[i].setBodystyle(result2.getString("bodystyle"));
				kcars[i].setColor(result2.getString("color"));
				kcars[i].setDrivetype(result2.getString("drivetype"));
				kcars[i].setEngine(result2.getString("engine"));
				kcars[i].setMPG(result2.getInt("mpg"));
				i++;
				pre2.close();
				result2.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre1.close();
				result1.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kcars;
	}
	
	public boolean addCompare(int userid, int carid){
		boolean flag = false;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "insert into compare values(?,?)";
			pre = dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, userid);
			pre.setInt(2, carid);
			int i = pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
	   }
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
	
	public int[] getCompare(int userid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		int[] carid=new int[3];
		String sql1="select selectedcar from compare where buyer=?";
		for(int i=0;i<3;i++){
			carid[i]=0;
		}
		try{
			dbUtil=new DbUtil();
			pre=dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, userid);
			result=pre.executeQuery();
			int i=0;
			while(result.next()){
				carid[i]=result.getInt("selectedcar");
				i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return carid;
	}
	
	public boolean removeCompare(int userid, int carid){
		boolean flag = false;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "delete from compare where buyer=? and selectedcar=?";
			pre = dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, userid);
			pre.setInt(2, carid);
			int i = pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
	   }
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
	
	public boolean addSave(int carid, int userid){
		boolean flag = false;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "insert into favourite values(?,?)";
			pre = dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, carid);
			pre.setInt(2, userid);
			int i = pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
	   }
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
	
	public int[] getSave(int userid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		int[] carid=new int[3];
		String sql1="select carsaved from favourite where savedby=?";
		for(int i=0;i<3;i++){
			carid[i]=0;
		}
		int i=0;
		try{
			dbUtil=new DbUtil();
			pre=dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, userid);
			result=pre.executeQuery();
			while(result.next()){
				carid[i]=result.getInt("carsaved");
				i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				result.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		int[] Carid=new int[i];
		for(int j=0;j<i;j++){
			Carid[j]=carid[j];
		}
		return Carid;
	}
	
	public boolean removeSave(int carid, int userid){
		boolean flag = false;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "delete from favourite where carsaved=? and savedby=?";
			pre = dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, carid);
			pre.setInt(2, userid);
			int i = pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
	   }
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}
	
	public boolean deleteManage(int carid, int userid){
		boolean flag = false;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "delete from car where carid=? and soldby=?";
			pre = dbUtil.getCon().prepareStatement(sql1);
			pre.setInt(1, carid);
			pre.setInt(2, userid);
			int i = pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
	   }
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return flag;
	}

}
