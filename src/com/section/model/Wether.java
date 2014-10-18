package com.section.model;


public class Wether implements Item{

	public final String title;
	

	public Wether(String title) {
		this.title = title;
	
	}
	
	@Override
	public boolean isSection() {
		return false;
	}

	@Override
	public boolean isWether() {
		return true;
	}

	@Override
	public boolean isTitle() {
		// TODO Auto-generated method stub
		return false;
	}


}
