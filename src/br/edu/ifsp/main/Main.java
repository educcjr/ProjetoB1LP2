package br.edu.ifsp.main;

import br.edu.ifsp.directory.Directory;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Thread> directoryThreadList = new ArrayList<>();

	public static void main(String[] args) {
        MainController controller = new MainController();
        controller.readInitialInput("files\\initial.txt");
        for (Directory directory : controller.getDirectoryList()) {
            directory.getSubFiles();
        }

        try {
            for (Thread thread : Main.directoryThreadList) {
                thread.join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Directory directory : controller.getDirectoryList()) {
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
