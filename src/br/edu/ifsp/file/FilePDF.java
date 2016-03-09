package br.edu.ifsp.file;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class FilePDF extends File {

	@Override
	public void readFile() {
		try {
		    PDDocument document = null; 
		    document = PDDocument.load(new java.io.File("test.pdf"));
		    document.getClass();
		    
		    if(!document.isEncrypted()) {
		        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		        stripper.setSortByPosition( true );
		        PDFTextStripper Tstripper = new PDFTextStripper();
		        String st = Tstripper.getText(document);
		        System.out.println("Text:"+st);
		    }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
}
