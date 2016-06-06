package com.lovo.cq.shopping10_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.dao.CarDao;
import com.lovo.cq.shopping10_1.dao.ReviewDao;
import com.lovo.cq.shopping10_1.po.Car;
import com.lovo.cq.shopping10_1.po.KindofCar;
import com.lovo.cq.shopping10_1.po.Review;

public class ReviewDaoImpl implements ReviewDao{
	public Review getReview(int userid, int dealerid, int carid){
		Review review=new Review();
		PreparedStatement pre1 = null;
		PreparedStatement pre2 = null;
		PreparedStatement pre3 = null;
		ResultSet result1 = null;
		DbUtil dbUtil = null;
		String sql1="select * from review where reviewer=? and reviewee=? and carid=?";
		try{
			dbUtil=new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setInt(1, userid);
			pre1.setInt(2, dealerid);
			pre1.setInt(3, carid);
			result1=pre1.executeQuery();
			if(result1.next()){
				review.setRate(result1.getInt("rate"));
				review.setContent(result1.getString("content"));
				review.setReviewer(userid);
				review.setReviewee(dealerid);
				review.setCarid(carid);
			}
			
		}catch (SQLException e) {
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
		return review;
	}
	
	public boolean updateReview(int reviewer, int reviewee, int rate, String content, int carid){
		PreparedStatement pre1 = null;
		PreparedStatement pre2 = null;
		PreparedStatement pre3 = null;
		ResultSet result1 = null;
		DbUtil dbUtil = null;
		String sql1="select * from review where reviewer=? and reviewee=? and carid=?";
		boolean flag=false;
		try{
			dbUtil=new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setInt(1, reviewer);
			pre1.setInt(2, reviewee);
			pre1.setInt(3, carid);
			result1=pre1.executeQuery();
			if(!result1.next()){
				System.out.println(carid);
				String sql2="insert into review values(?,?,?,?,?)";
				pre2=dbUtil.getCon().prepareStatement(sql2);
				pre2.setInt(1, reviewer);
				pre2.setInt(2, reviewee);
				pre2.setInt(3, rate);
				pre2.setString(4, content);
				pre2.setInt(5, carid);
				int i=pre2.executeUpdate();
				if(i != 0) {
					flag = true;
				}
			}
			else{
				String sql3="update review set rate=?, content=? where reviewer=? and reviewee=? and carid=?";
				pre3=dbUtil.getCon().prepareStatement(sql3);
				pre3.setInt(1, rate);
				pre3.setString(2, content);
				pre3.setInt(3, reviewer);
				pre3.setInt(4, reviewee);
				pre3.setInt(5, carid);
				int i=pre3.executeUpdate();
				if(i != 0) {
					flag = true;
				}
			}
		}catch (SQLException e) {
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
		return flag;
	}

}
