package br.edu.ifsp.main;

import br.edu.ifsp.file.File;

public class Main {
	
	public static void main(String[] args) {
		File file = File.createFile("C:\\Users\\Aluno\\Desktop\\sample.txt");
		file.readFile();
	}
}
