package com.decorator.ec;

public class MainDataSource {

	public static void main(String[] args) {

		DataSource fileDataSource = new FileDataSource();
		
		//encrypte and compreesed
		DataSource ECDataSource = new CompressionDecorator(new EncryptionDecorator(fileDataSource));
		
		String contentW = "Yay, this is my message.";
		String filePath = "example.txt";
		
		ECDataSource.write(filePath, contentW);
		String contentR = ECDataSource.read(filePath);
		
		System.out.println("content: " + contentR);
	}

}
