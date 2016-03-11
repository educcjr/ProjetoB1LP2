package br.edu.ifsp.file;

import br.edu.ifsp.util.Util;

import java.util.HashMap;
import java.util.Map;

public abstract class File {
	private String name;
	private Map<String, Integer> words = new HashMap<>();
	
	public abstract void readFile();

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static File createFile(String name) {
		File file;
		String ext = name.split("\\.")[1];
		switch (ext) {
			case "txt":
				file = new FileTXT();
				file.setName(name);
				return file;
			case "pdf":
				file = new FilePDF();
				file.setName(name);
				return file;
			case "docx":
				file = new FileDOCX();
				file.setName(name);
				return file;
		}
		return null;
	}

	public void putWordsToMap(String[] words) {
		for (String word : words) {
			System.out.println(word);
		}
	}

	public String[] getWords(String text) {
		text = text.replaceAll("\\p{P}","").toLowerCase();
		return Util.trimStringArray(text.split("[\\s\\xA0]+"));
	}
}
