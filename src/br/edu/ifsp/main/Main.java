package br.edu.ifsp.main;

import br.edu.ifsp.directory.Directory;

public class Main {
	
	public static void main(String[] args) {
        MainController controller = new MainController();
        controller.readInitialInput("C:\\Users\\Duds\\Desktop\\initial.txt");
        for (Directory directory : controller.getDirectoryList()) {
            directory.getSubFiles();
            directory.getFileList().forEach(f -> {
                if(f != null) {
                    f.readFile();
                    f.printMap();
                    System.out.println();
                }
            });
        }
	}
}
