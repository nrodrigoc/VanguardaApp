package vanguardamanager.display;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
	
public class Display extends JFrame{
		
	private static final long serialVersionUID = 1L;
	
	private final JTextField textField1;
	private final JButton btConfirma;
	private final JTextField textField3;
	private final JPasswordField passwordField;
	private final JMenuBar fila;
	
	
	private int width, height;
	
	public Display() {
		super("Vanguarda's Manager");
		fila = new JMenuBar();
		
		
		setLayout(null);
		textField1 = new JTextField(10); 
		textField1.setBounds(10, 40, 100, 30);
		
		btConfirma = new JButton("Confirma");
		btConfirma.setBounds(120, 40, 100, 30);
		add(btConfirma); 
		
		textField3 = new JTextField("Uneditable text field", 21);
		textField3.setBounds(10, 80, 120, 20);
		textField3.setEditable(false);
		textField3.setToolTipText("Vai tomar no cu tranquilo");
		
		passwordField = new JPasswordField("Hidden text");
		
		//Icon heart = new ImageIcon(getClass().getResource( "heart.png"));
		//label2 = new JLabel("Label com texto e icone", heart, SwingConstants.LEFT);
		
		//label3 = new JLabel();
		
		this.width = 500;
		this.height = 300;
		
		createDisplay();
		initLabels();
	}

	private void createDisplay() {
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		add(textField1);
		add(btConfirma);
		add(textField3);
		add(passwordField);
		
		
		//frame.pack();
	}
	
	
	private void initLabels() {
		//Icon heart = new ImageIcon(getClass().getResource( "heart.png"));
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler); 
		btConfirma.addActionListener(handler); 
		textField3.addActionListener(handler); 
		passwordField.addActionListener(handler); 
		//label1.setBounds(30, 0, 80, 80);
	}
		
	private class TextFieldHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String string = "";
			
			
			if(e.getSource() == textField1)
				string = textField1.getText().equalsIgnoreCase("bomdia") ? "Login certo" : "Login errado";
			
			else if(e.getSource() == btConfirma)
				string = textField1.getText().equalsIgnoreCase("bomdia") ? "Login certo" : "Login errado";
			
			else if(e.getSource() == textField3)
				string = String.format("textField3: %s", e.getActionCommand());
				
			else if (e.getSource() == passwordField)
				string = String.format("passwordField: %s", e.getActionCommand());

			
			JOptionPane.showMessageDialog(null, string); 
			
			
		}
		
	}
	
	
	
}

	
	
	