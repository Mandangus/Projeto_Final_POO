
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class LoginPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Entrar");
	JButton cadastroButton = new JButton("Cadastro");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("username:");
	JLabel userPasswordLabel = new JLabel("password:");
	JTextArea a = new JTextArea();
	JLabel messageLabel = new JLabel();
	HashMap<String,Usuario> logininfo = new HashMap<String,Usuario>();
	JTextArea areatexto = new JTextArea("Testando uma area de texto!!");
	JScrollPane areaScrollPane = new JScrollPane(areatexto);
	
	String[] Comunidades;
	
	
	public LoginPage(HashMap<String,Usuario> li,String[] Coms){
		
		this.Comunidades = Coms;
		logininfo = li;
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		cadastroButton.setBounds(225,200,100,25);
		cadastroButton.setFocusable(false);
		cadastroButton.addActionListener(this);
        
        
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(cadastroButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cadastroButton) {
			frame.dispose();
			@SuppressWarnings("unused")
			CadastroPage c = new CadastroPage(logininfo,this.Comunidades);
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			
			if(logininfo.containsKey(password)) {
				if(logininfo.get(password).nome.contentEquals(userID)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
					@SuppressWarnings("unused")
					WelcomePage welcomePage = new WelcomePage(logininfo.get(password));
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Usuario errado");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Senha errada");
			}
		}
	}	
}
	

