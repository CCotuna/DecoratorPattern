package com.decorator.ec;

public class EncryptionDecorator implements DataSource{
	private DataSource dataSource;
	private static final char ENCRYPTION_KEY = 'X'; // XOR ENCRYPTION KEY
	
	public EncryptionDecorator(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String read(String filePath) {
		String encryptedContent = dataSource.read(filePath);
		if (encryptedContent != null) {
			return Decrypt(encryptedContent);
		}
		return null;
	}

	@Override
	public void write(String filePath, String content) {
		String encryptedContent = Encrypt(content);
		dataSource.write(filePath, encryptedContent);
	}
	
	private String Encrypt(String input) {
		char[] inputChars = input.toCharArray();
		for(int i = 0; i < inputChars.length; i++) {
			inputChars[i] = (char) (inputChars[i] ^ ENCRYPTION_KEY);
		}
		return new String(inputChars);
	}
	
	private String Decrypt(String input) {
		return Encrypt(input);
	}
}
