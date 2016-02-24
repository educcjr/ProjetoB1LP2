package br.edu.ifsp.file;

public abstract class File {
	protected String name;
	//private Map<String, Integer> words = new HashMap<>();
	
	public abstract void setName(String name);
	public abstract String getName();
	public abstract void readFile();
	public static File createFile(String name) {
		File file;
		String ext = name.split("\\.")[1];
		
		if (ext.equals("txt")) {
			file = new FileTXT();
			file.setName(name);
			return file;
		}
		
		return null;
	}
}
