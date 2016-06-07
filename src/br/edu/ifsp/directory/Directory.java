package br.edu.ifsp.directory;

import br.edu.ifsp.file.File;
import br.edu.ifsp.main.Main;
import br.edu.ifsp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Runnable {
    private String path;
    private Extension[] extensions;
    private List<File> fileList;

    public Directory(String path, Extension[] extensions) {
        this.path = path;
        this.extensions = extensions;
        fileList = new ArrayList<>();
    }

    public List<File> getFileList() {
        return this.fileList;
    }

    public void getSubFiles() {
        Thread thread = new Thread(this);
        Main.directoryThreadList.add(thread);
        thread.start();
    }

    private void _getSubFiles() {
        List<String> directoryQueue = new ArrayList<>();
        directoryQueue.add(this.path);
        while (directoryQueue.size() > 0) {
            java.io.File file = new java.io.File(directoryQueue.get(0));
            java.io.File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (java.io.File subFile : subFiles) {
                    if (subFile.isFile()) {
                        if (verifyExtension(Util.getExtension(subFile.getAbsolutePath()))) {
                            fileList.add(File.createFile(subFile.getAbsolutePath()));
                        }
                    } else if (subFile.isDirectory()) {
                        directoryQueue.add(subFile.getAbsolutePath());
                    }
                }
            }
            directoryQueue.remove(0);
        }
    }

    public boolean verifyExtension(String extension) {
        for (Extension ext : extensions) {
            if (ext.getName().equals(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        _getSubFiles();
    }
}
