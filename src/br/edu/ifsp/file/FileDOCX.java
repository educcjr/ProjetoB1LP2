package br.edu.ifsp.file;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;

public class FileDOCX extends File {

    @Override
    public void readFile() {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(super.getPath()));
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            String text = extractor.getText();
            String[] words = super.getWords(text);
            super.putWordsToMap(words);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
