package com.decorator.ec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator implements DataSource{
	private DataSource dataSource;
	
	public CompressionDecorator(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String read(String filePath) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new InflaterInputStream(new FileInputStream(filePath))));
			StringBuilder content = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				content.append(line).append("\n");
			}
			return content.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}	

	@Override
	public void write(String filePath, String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new DeflaterOutputStream(new FileOutputStream(filePath))));
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
