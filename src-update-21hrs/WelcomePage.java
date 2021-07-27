import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class WelcomePage implements ActionListener{

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel();
	
	JLabel searchLabel = new JLabel("Pesquisar por temas:");
	JTextField searchField = new JTextField();
	
	JTextArea prompt = new JTextArea();
	
	JLabel userAge = new JLabel();
	JLabel userInter = new JLabel();
	JLabel userDesc = new JLabel();
	
	String filenameCom = new String();
	
	JButton botaoPesquisa = new JButton("Pesquisar");
	
	public static void main(String[] args) {
		Usuario a = new Usuario(19,"Antonio",null,"Estudante do ICMC");
		@SuppressWarnings("unused")
		WelcomePage w = new WelcomePage(a);
	}
	
	public WelcomePage(Usuario user){
		
		filenameCom = user.tituloComu + ".ser";
		
		welcomeLabel.setBounds(10,0,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,20));
		welcomeLabel.setText("Hello "+user.nome+"!");
		
		searchLabel.setBounds(300,10,200,35);
		searchLabel.setFont(new Font(null,Font.ITALIC,15));
		
		searchField.setBounds(450,20,150,20);
		searchField.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		
		prompt.setBounds(300,70,300,300);
		prompt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		prompt.setLineWrap(true);
        prompt.setWrapStyleWord(true);
        JScrollPane promptScroll = new JScrollPane(prompt);
        promptScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        promptScroll.setBounds(600,70,15,300);
        promptScroll.setVisible(true);
        
        
        userAge.setBounds(10,80,200,35);
        userAge.setFont(new Font(null,Font.BOLD,12));
        userAge.setText("Idade: " + user.idade);
        
        userDesc.setBounds(10,130,500,35);
        userDesc.setFont(new Font(null,Font.BOLD,12));
        userDesc.setText("Descrição: " + user.desc);
        if(user.desc==null || user.desc.equals("Conte sobre vc!")) userDesc.setText("Descrição não informada");
        
        userInter.setBounds(10,180,500,35);
        userInter.setFont(new Font(null,Font.BOLD,12));
        userInter.setText("Interesses: "+user.interesse);
        if(user.interesse==null) userInter.setText("Interesses não informados");
        
        botaoPesquisa.addActionListener(this);
        botaoPesquisa.setBounds(420,390,100,30);
        
        
		frame.add(welcomeLabel);
		frame.add(searchLabel);
		frame.add(searchField);
		frame.add(prompt);
		frame.add(promptScroll);
		frame.add(userAge);
		frame.add(userDesc);
		frame.add(userInter);
		frame.add(botaoPesquisa);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,470);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoPesquisa) {
			String topico = searchField.getText();
			Contents c = new Contents();
			try {
				c.getHash(filenameCom);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String titulo = c.getContents().get(topico).title;
			prompt.setText(titulo);
		}
	}
}