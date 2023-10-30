package com.decorator.repo;

public class MainRepo {

	public static void main(String[] args) {
		Repository prodRepository = new ProductRepository();
		
		Repository repoLogging = new LoggingDec(prodRepository);
		
		repoLogging.add("Prod. A");
		repoLogging.read();
		repoLogging.update("Prod. B");
		repoLogging.delete();
	}
}
