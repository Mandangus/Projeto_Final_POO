import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Contents {
	
	private HashMap<String, Tema> content = new HashMap<String, Tema>();
	
	public int add(String titulo, Tema t) {
		if(content.containsKey(titulo)) return -1;
		content.put(titulo, t);
		return 0;
	}
	
	protected HashMap<String , Tema> getContents(){
		return content;
	}
	
	public int getHash(String filenameSer) throws ClassNotFoundException, IOException {
		try {
			FileInputStream file = new FileInputStream(filenameSer);
			ObjectInputStream in = new ObjectInputStream(file);
			content = (HashMap<String, Tema>)in.readObject();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não existente");
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
}
