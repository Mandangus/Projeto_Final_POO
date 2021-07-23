import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class InfoLogin {
	private HashMap<String,Usuario> logs = new HashMap<String,Usuario>();
	
	
	public int add(Usuario usuario, String senha) {
		if(logs.containsKey(senha)) return -1;
		logs.put(senha, usuario);
		return 0;
	}
	
	
	protected HashMap<String,Usuario> getLogs(){
		//System.out.print(logs.toString());
		return logs;
	}
	
	public int writeFile() throws IOException {// escreve em um arquivo a serialização dos conteúdos de uma comunidade
		try {
			FileOutputStream file = new FileOutputStream("logins.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this.logs);
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não existente");
			e.printStackTrace();
		}
		return 0;
	}
	
}	
