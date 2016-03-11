package br.edu.ifsp.main;

import br.edu.ifsp.file.File;

public class Main {
	
	public static void main(String[] args) {
		File file = File.createFile("files\\sample.txt");
		file.readFile();
	}
}
