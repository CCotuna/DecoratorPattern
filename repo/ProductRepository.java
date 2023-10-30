package com.decorator.repo;

public class ProductRepository implements Repository {
	private String product;
	
	@Override
	public void add(String item) {
		product = item;
		System.out.println("Added: " + item);
	}

	@Override
	public String read() {
		return product;
	}

	@Override
	public void update(String item) {
		product = item;
		System.out.println("Updated: " + item);
	}

	@Override
	public void delete() {
		product = null;
		System.out.println("Deleted");
		
	}
	
}
