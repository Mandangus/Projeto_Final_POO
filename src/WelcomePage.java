import java.awt.*;
import javax.swing.*;

public class WelcomePage {

	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel();
	
	JLabel searchLabel = new JLabel("Pesquisar por temas:");
	JTextField searchField = new JTextField();
	
	JTextArea prompt = new JTextArea();
	
	
	public static void main(String[] args) {
		Usuario a = new Usuario(19,"Antonio","Matematica e comp-sci","Estudante do ICMC");
		WelcomePage w = new WelcomePage(a);
	}
	
	public WelcomePage(Usuario user){
		
		
		
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
        
        
        
		frame.add(welcomeLabel);
		frame.add(searchLabel);
		frame.add(searchField);
		frame.add(prompt);
		frame.add(promptScroll);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
		
		
	}
}