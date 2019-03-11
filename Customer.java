package com.bridgelabz.oops;

public class Customer {
	int custid;
	String custname;
	long mobileno;
	String city;
	int customerAvailableShare;
	String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCustomerAvailableShare() {
		return customerAvailableShare;
	}
	public void setCustomerAvailableShare(int customerAvailableShare) {
		this.customerAvailableShare = customerAvailableShare;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString()
	{
		return city+"---"+custid+"---"+custname+"---"+mobileno+"---"+customerAvailableShare+"---"+date;
		
	}
	

}
