package com.bit.three;

public class Paper {
	private int paperDefault;
	private int paperUse;
	
	Paper(){
		this.paperDefault=50;
		this.paperUse=0;
	}
	
	public int getPaperUse() {
		return paperUse;
	}

	public void setPaperUse(int paperUse) {
		this.paperUse += paperUse; 
	}

	public int paperStatus() {
		return paperDefault -paperUse;
	}

	public int getPaperDefault() {
		return paperDefault;
	}
	
	
	
}