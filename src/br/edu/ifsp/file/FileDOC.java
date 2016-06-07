package br.edu.ifsp.file;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class FileDOC extends File {

	@Override
	public void readFile() {
		try {
			POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(this.getPath()));
			WordExtractor extractor = new WordExtractor(fileSystem);
			String text = extractor.getText();
			String[] words = super.getWords(text);
            super.putWordsToMap(words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
