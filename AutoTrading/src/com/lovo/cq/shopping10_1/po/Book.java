package com.lovo.cq.shopping10_1.po;

public class Book {
	
	private int boughtlist;
	
	private int buyerid;
	
	private int carid;
	
	private int price;
	
	private int soldby;
	
	private String state;
	
	public int getBoughtlist(){
		return this.boughtlist;
	}
	
	public void setBoughtlist(int boughtlist){
		this.boughtlist=boughtlist;
	}
	
	public int getBuyerid(){
		return this.buyerid;
	}
	
	public void setBuyerid(int buyerid){
		this.buyerid=buyerid;
	}
	
	public int getCarid(){
		return this.carid;
	}
	
	public void setCarid(int carid){
		this.carid=carid;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	public int getSoldby(){
		return this.soldby;
	}
	
	public void setSoldby(int soldby){
		this.soldby=soldby;
	}
	
	public String getState(){
		return this.state;
	}
	
	public void setState(String state){
		this.state=state;
	}

}
