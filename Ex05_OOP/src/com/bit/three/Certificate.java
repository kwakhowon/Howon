package com.bit.three;

public class Certificate extends Paper{
	String[] certificate;
	int[] certificatePrice;
	int certificateNumber;

	
	Certificate(){
		this.certificate= new String[]{"재학증명서","졸업증명서","졸업예정증명서","성적증명서","휴학증명서"};
		this.certificatePrice = new int[] {300,1000,500,400,150};
		
	}
	
	public int payment(int certificateNumber) {
		this.certificateNumber = certificateNumber;
		return certificatePrice[certificateNumber];
	}
	
}