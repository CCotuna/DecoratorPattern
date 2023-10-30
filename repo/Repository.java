package com.decorator.repo;

public interface Repository {
	void add(String item);
	String read();
	void update(String item);
	void delete();
}
