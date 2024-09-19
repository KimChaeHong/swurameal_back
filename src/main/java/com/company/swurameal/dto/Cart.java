package com.company.swurameal.dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartDto> contents = new ArrayList<>();

	public List<CartDto> getContents() {
		return contents;
	}
	
	public void addItem(CartDto item) {
		contents.add(item);
	}
	
	public void removeItem(CartDto item) {
		contents.remove(item);
	}

}
