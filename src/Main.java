import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InfoLogin listLogin = new InfoLogin();
		Comunidade[] coms = new Comunidade[1];
		coms[0] = new Comunidade("SCC0215","Comunidade para a disciplina SCC0215 do ICMC");
		System.out.println(coms[0].toString());
		coms[0].writeFile();
		String[] titulos = {"SMA400",coms[0].titulo};
		@SuppressWarnings("unused")
		LoginPage l = new LoginPage(listLogin.getLogs(),titulos);
	}

}
