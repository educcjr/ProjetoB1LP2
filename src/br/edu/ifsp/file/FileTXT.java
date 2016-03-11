package br.edu.ifsp.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileTXT extends File {
	
	@Override
	public void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(super.getName()));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = super.getWords(line);
				this.putWordsToMap(words);

			}
			reader.close();
		}
		catch(Exception e) {
			System.out.println("File not found: " + super.getName());
		}
	}
}
