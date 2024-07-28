package Documents;

public class Main {
	public static void main(String[] args) {
		DocumentFactory wordFactory = new WordDocumentFactory();
		Document wordDoc = wordFactory.createDocument();
		
		wordDoc.open();
		wordDoc.save();
		wordDoc.close();
		System.out.println();
		
		DocumentFactory pdfFactory = new PdfDocumentFactory();
		Document pdfDoc = pdfFactory.createDocument();
		
		pdfDoc.open();
		pdfDoc.save();
		pdfDoc.close();
		System.out.println();
		
		DocumentFactory ExcelFactory = new ExcelDocumentFactory();
		Document ExcelDoc = ExcelFactory.createDocument();
		
		ExcelDoc.open();
		ExcelDoc.save();
		ExcelDoc.close();
		
	}
}
