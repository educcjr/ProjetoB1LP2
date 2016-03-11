package br.edu.ifsp.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileTXT extends File {
	
	@Override
	public void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(super.getName()));

			String line = reader.readLine();
			while(line != null) {
				String[] words = super.getWords(line);
				for (String word : words) {
					System.out.println(word);
				}
				line = reader.readLine();
			}

			reader.close();
		}
		catch(Exception e) {
			System.out.println("File not found: " + super.getName());
		}
	}
}
