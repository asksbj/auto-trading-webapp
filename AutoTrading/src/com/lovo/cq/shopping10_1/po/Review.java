package com.lovo.cq.shopping10_1.po;

public class Review {
	private int reviewer;
	
	private int reviewee;
	
	private int rate;
	
	private String content;
	
	private int carid;
	
	public int getReviewer(){
		return this.reviewer;
	}
	
	public void setReviewer(int reviewer){
		this.reviewer=reviewer;
	}
	
	public int getReviewee(){
		return this.reviewee;
	}
	
	public void setReviewee(int reviewee){
		this.reviewee=reviewee;
	}
	
	public int getRate(){
		return this.rate;
	}
	
	public void setRate(int rate){
		this.rate=rate;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public int getCarid(){
		return this.carid;
	}
	
	public void setCarid(int carid){
		this.reviewee=carid;
	}

}
