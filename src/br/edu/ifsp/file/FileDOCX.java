package br.edu.ifsp.file;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;

public class FileDOCX extends File {

    @Override
    public void readFile() {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(super.getName()));
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            String text = extractor.getText();
            String[] words = this.getWords(text);
            this.putWordsToMap(words);
        }
        catch (Exception e) {
            System.out.println("File not found: " + super.getName());
        }

    }
}
