package br.edu.ifsp.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileTXT extends File {
	
	@Override
	public void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(super.name));

			String line = reader.readLine();
			while(line != null) {
				String nLine = line.replaceAll("\\p{P}","").toLowerCase();
				String[] words = nLine.split(" ");
				for (String word : words) {
					System.out.println(word);
				}
				line = reader.readLine();
			}

			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public String getName() {
		return super.name;
	}
	
	@Override
	public void setName(String name) {
		super.name = name;
	}
}
