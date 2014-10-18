package com.section.model;

public class Title implements Item{

	public final String name;
	

	public Title(String title) {
		this.name = title;
		
	}
	
	@Override
	public boolean isSection() {
		return false;
	}

	@Override
	public boolean isWether() {
		return false;
	}

	@Override
	public boolean isTitle() {
		// TODO Auto-generated method stub
		return true;
	}

	
}