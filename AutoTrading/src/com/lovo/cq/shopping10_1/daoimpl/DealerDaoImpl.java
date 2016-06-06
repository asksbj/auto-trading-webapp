package com.lovo.cq.shopping10_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.dao.DealerDao;
import com.lovo.cq.shopping10_1.dao.UserDao;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.Dealer;
import com.lovo.cq.shopping10_1.po.Review;
import com.lovo.cq.shopping10_1.po.User;

public class DealerDaoImpl implements DealerDao{
	public Dealer dealerLogin(String name,String password) {
		Dealer dealer=new Dealer();
		PreparedStatement pre1 = null;
		ResultSet result1 = null;
		DbUtil dbUtil = null;
		
		String sql1="select * from dealer where username=?";
		try {
			dbUtil = new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setString(1, name);
			result1=pre1.executeQuery();
			if(result1.next()) {
				
				if(!password.equals(result1.getString("password"))) {
					throw new ErrPwdException("Password wrong!");
				}else {
					dealer.setId(result1.getInt("registernum"));
					dealer.setEmail(result1.getString("email"));
					dealer.setCompany(result1.getString("companyname"));
					dealer.setLogo(result1.getString("logo"));
					return dealer;
				}
			}else {
				throw new NameNotFoundException("Username is invalid");
			}
		} catch (SQLException e) {
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
		return dealer;
	}
	
	public Dealer getDealer(int dealerid){
		Dealer dealer=new Dealer();
		PreparedStatement pre1 = null;
		ResultSet result1 = null;
		DbUtil dbUtil = null;
		String sql1="select * from dealer where registernum=?";
		try {
			dbUtil = new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setInt(1, dealerid);
			result1=pre1.executeQuery();
			result1.next();
			dealer.setId(result1.getInt("registernum"));
			dealer.setEmail(result1.getString("email"));
			dealer.setCompany(result1.getString("companyname"));
			dealer.setLogo(result1.getString("logo"));
			return dealer;
		} catch (SQLException e) {
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
		return dealer;
	}
	
	public String[][] bestDealers(){
		DbUtil dbUtil = null;
		PreparedStatement pre1 = null;
		PreparedStatement pre2 = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		List avgrate=new ArrayList();
		Dealer[] dealers=new Dealer[5];
		for(int i=0;i<5;i++){
			dealers[i]=new Dealer();
		}
		int i=0;
		try{
			dbUtil=new DbUtil();
			String sql1="select * from dealer where registernum in (select r.reviewee from (select reviewee,avg(rate) as avgrate from review group by(reviewee) order by(avgrate) desc) r) and rownum<6";
			String sql2="select avg(rate) as avgrate from review group by(reviewee) order by(avgrate) desc";
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre2=dbUtil.getCon().prepareStatement(sql2);
			result1=pre1.executeQuery();
			result2=pre2.executeQuery();
			while(result1.next()){
				result2.next();
				dealers[i].setId(result1.getInt("registernum"));
				dealers[i].setEmail(result1.getString("email"));
				dealers[i].setCompany(result1.getString("companyname"));
				dealers[i].setLogo(result1.getString("logo"));
				avgrate.add(i, result2.getFloat("avgrate"));
				i++;
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				pre1.close();
				pre2.close();
				result1.close();
				result2.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Dealer[] dealer=new Dealer[i];
		Review[] review=new Review[5];
		for(int j=0;j<i;j++){
			dealer[j]=dealers[j];
		}
		String[][] bestdealer=new String[dealer.length][5];
		for(int k=0;k<dealer.length;k++){
			bestdealer[k][0]=Integer.toString(dealer[k].getId());
			bestdealer[k][1]=dealer[k].getEmail();
			bestdealer[k][2]=dealer[k].getCompany();
			bestdealer[k][3]=dealer[k].getLogo();
			bestdealer[k][4]=Float.toString((float)avgrate.get(k));
		}
		return bestdealer;
	}
	
	public String[][] getTrendTotal(int dealerid){
		DbUtil dbUtil = null;
		PreparedStatement pre1 = null;
		ResultSet result1 = null;
		String[][] info=new String[50][2];
		int i=0;
		try{
			dbUtil=new DbUtil();
			String sql="select u.state, count(*) as stotal from users u, car c where c.boughtby=u.userid and c.soldby=? group by u.state order by stotal desc";
			pre1=dbUtil.getCon().prepareStatement(sql);
			pre1.setInt(1, dealerid);
			result1=pre1.executeQuery();
			while(result1.next()){
				info[i][0]=result1.getString("state");
				info[i][1]=Integer.toString(result1.getInt("stotal"));
				i++;
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
		String[][] Info=new String[i][2];
		for(int j=0;j<i;j++){
			Info[j][0]=info[j][0];
			Info[j][1]=info[j][1];
		}
		return Info;
	}
	
	public String[][] getTrendType(int dealerid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		PreparedStatement pre1 = null;
		PreparedStatement pre2 = null;
		PreparedStatement pre3 = null;
		PreparedStatement pre4 = null;
		ResultSet result = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		ResultSet result3 = null;
		ResultSet result4 = null;
		String[][] info=new String[50][5];
		String sql="select distinct u.state from kindofcar k, car c, users u where c.soldby=? and k.kindid=c.kindid and c.boughtby=u.userid";
		int i=0;
		try{
			dbUtil=new DbUtil();
			String sql1="select k.make from kindofcar k, car c, users u where c.soldby=? and k.kindid=c.kindid and c.boughtby=u.userid and u.state=? group by(k.make) having count(*)>=all(select count(*) from kindofcar k1, car c1, users u1 where c1.soldby=? and k1.kindid=c1.kindid and c1.boughtby=u1.userid and u1.state=? group by(k1.make))";
			String sql2="select k.bodystyle from kindofcar k, car c, users u where c.soldby=? and k.kindid=c.kindid and c.boughtby=u.userid and u.state=? and k.bodystyle is not null group by(k.bodystyle) having count(*)>=all(select count(*) from kindofcar k1, car c1, users u1 where c1.soldby=? and k1.kindid=c1.kindid and c1.boughtby=u1.userid and u1.state=? and k1.bodystyle is not null group by(k1.bodystyle))";
			String sql3="select k.drivetype from kindofcar k, car c, users u where c.soldby=? and k.kindid=c.kindid and c.boughtby=u.userid and u.state=? and k.drivetype is not null group by(k.drivetype) having count(*)>=all(select count(*) from kindofcar k1, car c1, users u1 where c1.soldby=? and k1.kindid=c1.kindid and c1.boughtby=u1.userid and u1.state=? and k1.drivetype is not null group by(k1.drivetype))";
			String sql4="select k.engine from kindofcar k, car c, users u where c.soldby=? and k.kindid=c.kindid and c.boughtby=u.userid and u.state=? and k.engine is not null group by(k.engine) having count(*)>=all(select count(*) from kindofcar k1, car c1, users u1 where c1.soldby=? and k1.kindid=c1.kindid and c1.boughtby=u1.userid and u1.state=? and k1.engine is not null group by(k1.engine))";
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, dealerid);
			result=pre.executeQuery();
			while(result.next()){
				info[i][0]=result.getString("state");
				pre1=dbUtil.getCon().prepareStatement(sql1);
				pre1.setInt(1, dealerid);
				pre1.setString(2, result.getString("state"));
				pre1.setInt(3, dealerid);
				pre1.setString(4, result.getString("state"));
				result1=pre1.executeQuery();
				if(result1.next())
					info[i][1]=result1.getString("make");
				else
					info[i][1]="";
				pre2=dbUtil.getCon().prepareStatement(sql2);
				pre2.setInt(1, dealerid);
				pre2.setString(2, result.getString("state"));
				pre2.setInt(3, dealerid);
				pre2.setString(4, result.getString("state"));
				result2=pre2.executeQuery();
				if(result2.next())
					info[i][2]=result2.getString("bodystyle");
				else
					info[i][2]="";
				pre3=dbUtil.getCon().prepareStatement(sql3);
				pre3.setInt(1, dealerid);
				pre3.setString(2, result.getString("state"));
				pre3.setInt(3, dealerid);
				pre3.setString(4, result.getString("state"));
				result3=pre3.executeQuery();
				if(result3.next())
					info[i][3]=result3.getString("drivetype");
				else
					info[i][3]="";
				pre4=dbUtil.getCon().prepareStatement(sql4);
				pre4.setInt(1, dealerid);
				pre4.setString(2, result.getString("state"));
				pre4.setInt(3, dealerid);
				pre4.setString(4, result.getString("state"));
				result4=pre4.executeQuery();
				if(result4.next())
					info[i][4]=result4.getString("engine");
				else
					info[i][4]="";
				i++;
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
		String[][] Info=new String[i][5];
		for(int j=0;j<i;j++){
			Info[j][0]=info[j][0];
			Info[j][1]=info[j][1];
			Info[j][2]=info[j][2];
			Info[j][3]=info[j][3];
			Info[j][4]=info[j][4];
		}
		return Info;
	}
	
	public String[][] getManage(int dealerid){
		DbUtil dbUtil = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		String[][] info=new String[50][5];
		String sql="select * from car c, kindofcar k where c.kindid=k.kindid and c.soldby=? and state='avaliable' and rownum<=50";
		int i=0;
		try{
			dbUtil=new DbUtil();
			pre=dbUtil.getCon().prepareStatement(sql);
			pre.setInt(1, dealerid);
			result=pre.executeQuery();
			while(result.next()){
				info[i][0]=Integer.toString(result.getInt("carid"));
				info[i][1]=result.getString("make");
				info[i][2]=result.getString("model");
				info[i][3]=result.getString("year");
				info[i][4]=result.getString("price");
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
		String[][] Info=new String[i][5];
		for(int j=0;j<i;j++){
			Info[j][0]=info[j][0];
			Info[j][1]=info[j][1];
			Info[j][2]=info[j][2];
			Info[j][3]=info[j][3];
			Info[j][4]=info[j][4];
		}
		return Info;
	}

}
