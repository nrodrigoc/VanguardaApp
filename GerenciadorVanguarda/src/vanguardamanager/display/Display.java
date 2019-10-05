package vanguardamanager.display;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
	
	public class Display extends JFrame{
		
	private static final long serialVersionUID = 1L;
	
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	
	private int width, height;
	
	public Display() {
		super("Vanguarda's Manager");
		setLayout(new FlowLayout());
		label1 = new JLabel("Aqui vai o texto");
		
		Icon heart = new ImageIcon(getClass().getResource( "heart.png"));
		label2 = new JLabel("Label com texto e icone", heart, SwingConstants.LEFT);
		
		label3 = new JLabel();
		
		this.width = 260;
		this.height = 180;
		
		createDisplay();
		initLabels();
	}

	private void createDisplay() {
		setBounds(0, 0, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		add(label1);
		add(label2);
		add(label3);
		//frame.pack();
	}
	
	private void initLabels() {
		Icon heart = new ImageIcon(getClass().getResource( "heart.png"));
		label3.setText("Label com icone e texto em baixo");
		label3.setIcon(heart);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.TOP); 
		label3.setToolTipText("This is label3"); 
		
		label2.setBounds(0, 0, 32, 32);
		
		label1.setToolTipText("This is label1"); 
		label2.setToolTipText("This is label2"); 
		//label1.setBounds(30, 0, 80, 80);
	}
		
	
}
