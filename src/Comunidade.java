import java.io.*;

public class Comunidade {

	private Contents contents = new Contents();// Hash map dos conteudos do arquivo
	String titulo;
	private String desc;
	private String filenameSer;// nome do aqruivo serializado do HashMap<Tema,String>.
	
	public Comunidade(String titulo, String desc) {
		this.titulo = titulo;
		this.desc = desc;
		filenameSer = titulo + ".ser";
	}
	
	@Override
	public String toString() {
		String s = "Titulo: " + titulo + "\n" + "Descri��o: " + desc + "\n" + "Nome do arquivo: " + filenameSer;
		return s;
	}
	
	
	public int writeFile() throws IOException {// escreve em um arquivo a serializa��o dos conte�dos de uma comunidade
		try {
			FileOutputStream file = new FileOutputStream(filenameSer);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(contents.getContents());
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o existente");
			e.printStackTrace();
		}
		return 0;
	}
	public int readFile() throws IOException, ClassNotFoundException {// le um arquivo e coleta a hash contendo os temas e titulos da comunidade
		int status = contents.getHash(filenameSer);
		return status;
	}
	
}
