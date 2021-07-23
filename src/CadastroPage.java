import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CadastroPage implements ActionListener {
	JFrame frame = new JFrame();
	JLabel bemvindo = new JLabel();
	
	
	JLabel userIDLabel = new JLabel("*Nome: ");
	JTextField userIDField = new JTextField();
	
	
	JLabel userAgeLabel = new JLabel("*Idade: ");
	JTextField userAgeField = new JTextField();
	
	JLabel userInterLabel = new JLabel("Áreas de Interesse: ");
	JTextArea userInterField = new JTextArea();
	
	JLabel userDescLabel = new JLabel("Descrição: ");
	JTextArea userDescField = new JTextArea("Conte sobre vc!");	
	
	JButton botao = new JButton();
	
	String[] petStrings;
	
	JLabel comLabel = new JLabel("*Comunidade: ");
	
	
	JLabel userPasswordLabel = new JLabel("*Senha: ");
	JPasswordField userPasswordField =  new JPasswordField();
	
	JLabel userConfLabel = new JLabel("*Repetir a senha: ");
	JPasswordField userConfField =  new JPasswordField();
	
	
	JLabel warning = new JLabel("Todos os campos com * devem ser preenchidos!");
	
	public CadastroPage(String[] comStrings){
		
		
		this.petStrings = comStrings;
		
		JComboBox petList = new JComboBox(petStrings);
		
		bemvindo.setBounds(10,0,200,35);
		bemvindo.setFont(new Font(null,Font.BOLD,20));
		bemvindo.setText("Criar uma conta!");
		
		userIDLabel.setBounds(10,35,200,35);
		userIDLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userIDField.setBounds(75,40,200,25);
		
		userAgeLabel.setBounds(10,70,200,35);
		userAgeLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userAgeField.setBounds(75,75,35,25);
		
		userInterLabel.setBounds(10,105,200,25);
		userInterLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userInterField.setBounds(150,110,200,150);
		userInterField.setLineWrap(true);
		userInterField.setWrapStyleWord(true);
		userInterField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		userDescLabel.setBounds(10,265,200,25);
		userDescLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userDescField.setBounds(150,270,200,150);
		userDescField.setLineWrap(true);
		userDescField.setWrapStyleWord(true);
		userDescField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		petList.setBounds(125,445,200,25);
		comLabel.setBounds(10,445,200,25);
		comLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userPasswordLabel.setBounds(10,500,200,25);
		userPasswordLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userPasswordField.setBounds(75,500,200,25);
		
		
		userConfLabel.setBounds(10,550,200,25);
		userConfLabel.setFont(new Font(null,Font.ITALIC,15));
		
		userConfField.setBounds(135,550,200,25);
		
		botao.setBounds(100,625,200,30);
		botao.setText("Confirmar");
		botao.addActionListener(this);
		
		warning.setBounds(10,660,300,10);
		warning.setFont(new Font(null,Font.BOLD,10));
		warning.setForeground(Color.RED);
		warning.setVisible(false);
		
		frame.add(bemvindo);
		frame.add(userIDLabel);
		frame.add(userIDField);
		frame.add(userAgeLabel);
		frame.add(userAgeField);
		frame.add(userInterLabel);
		frame.add(userInterField);
		frame.add(userDescLabel);
		frame.add(userDescField);
		frame.add(petList);
		frame.add(comLabel);
		frame.add(userPasswordField);
		frame.add(userPasswordLabel);
		frame.add(userConfField);
		frame.add(userConfLabel);
		frame.add(botao);
		frame.add(warning);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 715);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		String[] Coms = {"SCC021","SSC000","SMA400"};
		@SuppressWarnings("unused")
		CadastroPage c = new CadastroPage(Coms);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botao) {
			if(userIDField.getText().isEmpty() || userPasswordField.getText().isEmpty() || 
					userConfField.getText().isEmpty() || userAgeField.getText().isEmpty()) {
				warning.setVisible(true);
			}else if(userConfField.getText().equals(userPasswordField.getText())){
				System.out.println("OK");
			}
		}
	}
}
