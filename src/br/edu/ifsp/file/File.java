package br.edu.ifsp.file;

import br.edu.ifsp.util.Util;

import java.util.HashMap;
import java.util.Map;

public abstract class File {
	private String path;
	private Map<String, Integer> wordMap = new HashMap<>();
	
	public abstract void readFile();

	public String getPath() {
		return this.path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public static File createFile(String path) {
		File file;
		String ext = Util.getExtension(path);
		switch (ext) {
			case "txt":
				file = new FileTXT();
				file.setPath(path);
				return file;
			case "pdf":
				file = new FilePDF();
				file.setPath(path);
				return file;
			case "docx":
				file = new FileDOCX();
				file.setPath(path);
				return file;
			case "doc":
				file = new FileDOC();
				file.setPath(path);
				return file;
		}
		return null;
	}

	public void putWordsToMap(String[] words) {
		for (String word : words) {
			if(this.wordMap.containsKey(word)) {
				this.wordMap.replace(word, this.wordMap.get(word) + 1);
			}
			else {
				this.wordMap.put(word, 1);
			}
		}
	}

    public void printMap() {
        this.wordMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + ", " + entry.getValue()));
    }

	public String[] getWords(String text) {
		text = text.replaceAll("\\p{P}","").toLowerCase();
		return Util.trimStringArray(text.split("[\\s\\xA0]+"));
	}
}
