package br.edu.ifsp.main;

import br.edu.ifsp.file.File;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<File> files = new ArrayList<>();
		files.add(File.createFile("files\\sample.txt"));
		files.add(File.createFile("files\\sample.pdf"));
		files.add(File.createFile("files\\sample.docx"));

		files.stream().forEach(f -> { if(f != null) {
			f.readFile();
			System.out.println();
		}});
	}
}
