package com.lovo.cq.shopping10_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.dao.UserDao;
import com.lovo.cq.shopping10_1.po.User;

public class UserDaoImpl implements UserDao{

	// ÓÃ»§×¢²á
	public boolean addUser(User user) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1=null;
		ResultSet res=null;
		DbUtil dbUtil = null;
		int countid,setid;
		String sql1 = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2= "select max(userid) as mid from users";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql1);
			pstmt1= dbUtil.getCon().prepareStatement(sql2);
			res = pstmt1.executeQuery();
			res.next();
			countid = res.getInt("mid");
			setid = countid+1;
			pstmt.setInt(1, setid);
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getFirstname());
			pstmt.setString(6, user.getLastname());
			pstmt.setString(7, user.getphone());
			pstmt.setInt(8, user.getzipcode());
			pstmt.setString(9, user.getCountry());
			pstmt.setString(10, user.getState());
			pstmt.setString(11, user.getCity());
			pstmt.setString(12, user.getStreetadd());
			int i = pstmt.executeUpdate();
			if(i != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				pstmt1.close();
				res.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return flag;
	}
	
	public boolean addBuyer(int userid){
		boolean flag = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet res=null;
		DbUtil dbUtil = null;
		String sql1= "select * from buyer where buyerid=?";
		String sql2 = "insert into buyer values(?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt1 = dbUtil.getCon().prepareStatement(sql1);
			pstmt2 = dbUtil.getCon().prepareStatement(sql2);
			pstmt1.setInt(1, userid);
			res=pstmt1.executeQuery();
			if(!res.next()){
				pstmt2.setInt(1, userid);
				pstmt2.setString(2, null);
				int i = pstmt2.executeUpdate();
				if(i != 0) {
					flag = true;
				}
			}
			else
				flag =true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt1.close();
				pstmt2.close();
				res.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return flag;
	}
	
	public boolean addSeller(int userid){
		boolean flag = false;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet res=null;
		DbUtil dbUtil = null;
		String sql1= "select * from seller where sellerid=?";
		String sql2 = "insert into seller values(?)";
		try {
			dbUtil = new DbUtil();
			pstmt1 = dbUtil.getCon().prepareStatement(sql1);
			pstmt2 = dbUtil.getCon().prepareStatement(sql2);
			pstmt1.setInt(1, userid);
			res=pstmt1.executeQuery();
			if(!res.next()){
				pstmt2.setInt(1, userid);
				int i = pstmt2.executeUpdate();
				if(i != 0) {
					flag = true;
				}
			}
			else{
				
				flag =true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt1.close();
				pstmt2.close();
				res.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return flag;
	}

	public User getUser(int userid){
		User user = new User();
		PreparedStatement pre1 = null;
		ResultSet result1 = null;
		DbUtil dbUtil = null;
		
		String sql1="select * from users where userid=?";
		try {
			dbUtil = new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setInt(1, userid);
			result1=pre1.executeQuery();
			if(result1.next()) {
				user.setId(result1.getInt("userid"));
				user.setEmail(result1.getString("email"));
				user.setFirstname(result1.getString("firstname"));
				user.setLastname(result1.getString("lastname"));
				user.setPhone(result1.getString("phonenumber"));
				user.setzipcode(result1.getInt("zipcode"));
				user.setCountry(result1.getString("country"));
				user.setState(result1.getString("state"));
				user.setCity(result1.getString("city"));
				user.setStreetadd(result1.getString("streetadd"));
				return user;
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
		return user;
	}
	
	public User getBuyers(int carid){
		User user = new User();
		PreparedStatement pre1 = null;
		ResultSet result1 = null;
		DbUtil dbUtil = null;
		String sql1="select * from users u, car c where c.boughtby=u.userid and c.carid=?";
		try {
			dbUtil = new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setInt(1, carid);
			result1=pre1.executeQuery();
			if(result1.next()) {
				user.setId(result1.getInt("userid"));
				user.setName(result1.getString("username"));
				user.setEmail(result1.getString("email"));
				user.setFirstname(result1.getString("firstname"));
				user.setLastname(result1.getString("lastname"));
				user.setPhone(result1.getString("phonenumber"));
				user.setzipcode(result1.getInt("zipcode"));
				user.setCountry(result1.getString("country"));
				user.setState(result1.getString("state"));
				user.setCity(result1.getString("city"));
				user.setStreetadd(result1.getString("streetadd"));
				return user;
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
		return user;
	}
	
	public boolean updateUser(User user) {
		Boolean flag = false;
		DbUtil dbUtil = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update users set  email = ? , firstname = ? , lastname = ? , phonenumber = ? ,zipcode = ?, country = ? , state = ? , city = ? , streetadd = ? where userid = ?";
		try {
           
			pre = dbUtil.getCon().prepareStatement(sql);
			
			pre.setString(1, user.getEmail());
			pre.setString(2, user.getFirstname());
			pre.setString(3, user.getLastname());
			pre.setString(4, user.getphone());
			pre.setInt(5, user.getzipcode());
			pre.setString(6, user.getCountry());
			pre.setString(7, user.getState());
			pre.setString(8, user.getCity());
			pre.setString(9, user.getStreetadd());
			pre.setInt(10, user.getId());	
			int i=pre.executeUpdate();
			if(i != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pre.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public User userLogin(String name,String password) {
		User user = new User();
		PreparedStatement pre1 = null;
		ResultSet result1 = null;
		DbUtil dbUtil = null;
		System.out.println(name);
		String sql1="select * from users where username=?";
		try {
			dbUtil = new DbUtil();
			pre1=dbUtil.getCon().prepareStatement(sql1);
			pre1.setString(1, name);
			result1=pre1.executeQuery();
			if(result1.next()) {
				
				if(!password.equals(result1.getString("password"))) {
					throw new ErrPwdException("Password wrong!");
					//System.out.println("wrong");
				}else {
					user.setId(result1.getInt("userid"));
					user.setEmail(result1.getString("email"));
					user.setFirstname(result1.getString("firstname"));
					user.setLastname(result1.getString("lastname"));
					user.setPhone(result1.getString("phonenumber"));
					user.setzipcode(result1.getInt("zipcode"));
					user.setCountry(result1.getString("country"));
					user.setState(result1.getString("state"));
					user.setCity(result1.getString("city"));
					user.setStreetadd(result1.getString("streetadd"));
					return user;
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
		return user;
	}
	
}