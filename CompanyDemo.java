package com.bridgelabz.oops;

public class CompanyDemo {
	 String cname;
	int numberofshare;
	double sharePrice;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getNumberofshare() {
		return numberofshare;
	}
	public void setNumberofshare(int numberofshare) {
		this.numberofshare = numberofshare;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	public String toString()
	{
		return cname+"---"+numberofshare+"---"+sharePrice;
		
	}
	
}
