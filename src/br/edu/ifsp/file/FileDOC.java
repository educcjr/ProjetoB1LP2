package br.edu.ifsp.file;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class FileDOC extends File {

	@Override
	public void readFile() {
		POIFSFileSystem fileSystem = null;
		WordExtractor extractor = null;  
		String text = "";
		
		try {
			fileSystem = new POIFSFileSystem(new FileInputStream(this.getPath()));
			extractor = new WordExtractor(fileSystem);  
			text = extractor.getText();
			String[] words = super.getWords(text);
            super.putWordsToMap(words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
