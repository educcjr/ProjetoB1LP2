package br.edu.ifsp.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileTXT extends File {
	
	@Override
	public void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(super.getPath()));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = super.getWords(line);
				super.putWordsToMap(words);
			}
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
