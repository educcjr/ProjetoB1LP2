package br.edu.ifsp.file;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FilePDF extends File {

	@Override
	public void readFile() {
		try {
		    PDDocument document = PDDocument.load(new java.io.File(super.getPath()));
		    if(!document.isEncrypted()) {
		        PDFTextStripper stripper = new PDFTextStripper();
		        String text = stripper.getText(document);
				String[] words = super.getWords(text);
				super.putWordsToMap(words);
		    }
			document.close();
	    }
		catch(Exception e) {
			e.printStackTrace();
	    }
	}
}
