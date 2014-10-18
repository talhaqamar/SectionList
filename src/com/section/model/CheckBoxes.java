package com.section.model;

public class CheckBoxes implements Item{

	public final String check;
	

	public CheckBoxes(String title) {
		this.check = title;
		
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
		return false;
	}

	
}