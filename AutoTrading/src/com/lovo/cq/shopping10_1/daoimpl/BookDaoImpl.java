package com.lovo.cq.shopping10_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.dao.BookDao;
import com.lovo.cq.shopping10_1.dao.DealerDao;
import com.lovo.cq.shopping10_1.dao.UserDao;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.Dealer;
import com.lovo.cq.shopping10_1.po.Review;
import com.lovo.cq.shopping10_1.po.User;
import com.lovo.cq.shopping10_1.po.Book;

public class BookDaoImpl implements BookDao{
	
	public boolean addBook(int carid, int buyerid, int soldby, int price){
		boolean flag = false;
		int countid=0,setid=0;
		int kindid;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		PreparedStatement pre1 = null;
		ResultSet result = null;
		try{
			dbUtil = new DbUtil();
			String sql1 = "select max(listid) as mid from boughtlist";
			pre = dbUtil.getCon().prepareStatement(sql1);
			result = pre.executeQuery();
			result.next();	   
		    countid=result.getInt("mid");
			setid=countid+1;
			pre.close();
			result.close();
			String sql2= "insert into boughtlist values(?,?,?,?,?,'Unconfirm')";
			pre= dbUtil.getCon().prepareStatement(sql2);
			pre.setInt(1, setid);
			pre.setInt(2, buyerid);
			pre.setInt(3, carid);
			pre.setInt(4, price);
			pre.setInt(5, soldby);
			String sql3="update car set state='sold',boughtby=? where carid=?";
			pre1= dbUtil.getCon().prepareStatement(sql3);
			pre1.setInt(1, buyerid);
			pre1.setInt(2, carid);
			int i = pre.executeUpdate();
			int j= pre1.executeUpdate();
			if(i != 0 && j!=0) {
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
	
	public boolean confirmBook(int carid){
		boolean flag = false;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		try{
			dbUtil = new DbUtil();
			String sql="update boughtlist set state='success' where carid=?";
			pre= dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, carid);
			int i = pre.executeUpdate();
			if(i != 0 ) {
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
	
	public boolean denyBook(int carid){
		boolean flag = false;
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		PreparedStatement pre1 = null;
		try{
			dbUtil = new DbUtil();
			String sql="delete from boughtlist where carid=?";
			pre= dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, carid);
			String sql1="update car set state='avaliable',boughtby=null where carid=?";
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setInt(1, carid);
			int i = pre.executeUpdate();
			int j = pre1.executeUpdate();
			if(i != 0 && j!=0) {
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
	
	public String[][] getBook(int dealerid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		String[][] info=new String[10][4];
		int i=0;
		try{
			dbUtil=new DbUtil();
		    String sql="select * from boughtlist b, users u where b.buyerid=u.userid and b.soldby=? and b.state='Unconfirm'";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, dealerid);
			result=pre.executeQuery();
			while(result.next()){
				info[i][0]=Integer.toString(result.getInt("carid"));
				info[i][1]=Integer.toString(result.getInt("buyerid"));
				info[i][2]=result.getString("username");
				info[i][3]=Integer.toString(result.getInt("price"));
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
		String[][] Info=new String[i][4];
		for(int j=0;j<i;j++){
			Info[j][0]=info[j][0];
			Info[j][1]=info[j][1];
			Info[j][2]=info[j][2];
			Info[j][3]=info[j][3];
		}
		return Info;
	}
	
	public Book getCarBook(int carid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		Book book=new Book();
		int i=0;
		try{
			dbUtil=new DbUtil();
		    String sql="select * from boughtlist where carid=?";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, carid);
			result=pre.executeQuery();
			if(result.next()){
				book.setBoughtlist(result.getInt("listid"));
				book.setBuyerid(result.getInt("buyerid"));
				book.setCarid(carid);
				book.setPrice(result.getInt("price"));
				book.setSoldby(result.getInt("soldby"));
				book.setState(result.getString("state"));
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
		return book;
	}
	
	public Book[] getMyBook(int userid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		Book[] book=new Book[10];
		for(int i=0;i<10;i++){
			book[i]=new Book();
		}
		int i=0;
		try{
			dbUtil=new DbUtil();
		    String sql="select * from boughtlist where buyerid=?";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, userid);
			result=pre.executeQuery();
			while(result.next()){
				book[i].setBuyerid(result.getInt("buyerid"));
				book[i].setCarid(result.getInt("carid"));
				book[i].setPrice(result.getInt("price"));
				book[i].setSoldby(result.getInt("soldby"));
				book[i].setState(result.getString("state"));
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
		Book[] books=new Book[i];
		for(int j=0;j<i;j++){
			books[j]=book[j];
		}
		return books;
	}

}
