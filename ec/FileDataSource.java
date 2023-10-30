package com.decorator.ec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataSource implements DataSource {

	@Override
	public String read(String filePath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			StringBuilder content = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				content.append(line).append("\n");
			}
			return content.toString();
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void write(String filePath, String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
