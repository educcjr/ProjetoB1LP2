package br.edu.ifsp.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileTXT extends File {
	public String getName() {
		return super.name;
	}
	public void setName(String name) {
		super.name = name;
	}
	public void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(super.name));
			String line = reader.readLine();
			
			while(line != null)
			{
				System.out.println(line);
				line = reader.readLine();
			}
			
			reader.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
