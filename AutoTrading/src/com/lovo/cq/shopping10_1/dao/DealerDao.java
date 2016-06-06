package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Dealer;

public interface DealerDao {
	public Dealer dealerLogin(String name,String password);
	
	public Dealer getDealer(int dealerid);
	
	public String[][] bestDealers();
	
	public String[][] getTrendTotal(int dealerid);
	
	public String[][] getTrendType(int dealerid);
	
	public String[][] getManage(int dealerid);

}
