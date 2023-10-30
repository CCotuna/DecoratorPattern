package com.decorator.repo;

public class LoggingDec implements Repository {
	private Repository repository;
	
	public LoggingDec(Repository repository) {
		this.repository = repository;
	}

	@Override
	public void add(String item) {
		System.out.println("Logging: adding " + item);
		repository.add(item);
	}

	@Override
	public String read() {
		System.out.println("Logging: reading");
		return repository.read();
	}

	@Override
	public void update(String item) {
		System.out.println("Logging: updating " + item);
		repository.update(item);
	}

	@Override
	public void delete() {
		System.out.println("Logging: deleting");
		repository.delete();
	}

}
