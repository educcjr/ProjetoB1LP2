package br.edu.ifsp.main;

import br.edu.ifsp.directory.Directory;
import br.edu.ifsp.directory.Extension;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainController {
    private Directory[] directoryList;

    public MainController() {

    }

    public Directory[] getDirectoryList() {
        return this.directoryList;
    }

    public void readInitialInput(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            this.directoryList = new Directory[((Long) reader.lines().count()).intValue()];
            reader.close();
            reader = new BufferedReader(new FileReader(path));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parameters = line.split("\\{");
                String directoryPath = parameters[0].trim();
                String extensionsLine = parameters[1].split("}")[0];
                String extensionsStrings[] = extensionsLine.split(";");
                Extension[] extensions = new Extension[extensionsStrings.length];
                int j = 0;
                for (String extensionString : extensionsStrings) {
                    String extensionParameters[] = extensionString.split(",");
                    extensions[j] =  new Extension(extensionParameters[0], extensionParameters[1].equals("S"));
                    j++;
                }
                this.directoryList[i] = new Directory(directoryPath, extensions);
                i++;
            }
            reader.close();
        }
        catch(Exception e) {
            System.out.println("File not found: " + path);
            e.printStackTrace();
        }
    }
}
