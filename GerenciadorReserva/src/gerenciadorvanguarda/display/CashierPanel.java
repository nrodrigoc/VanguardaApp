package gerenciadorvanguarda.display;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class CashierPanel extends JPanel{
	private JTextField nameField;
	
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup sexo;
	
	private JLabel lblFemLabel;
	private JLabel lblMaleLabel;
	
	private JComboBox<String> ageComboBox;	
	private String[] idades = {"+18 anos", "13 a 17 anos", "6 até 12 anos", "5 anos ou menos"};
	private JLabel lblProdutos;
	
	
	public CashierPanel() {
		setBounds(0, 0, 969, 646);
		setLayout(null);
		
		nameField = new JTextField();
		nameField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setBounds(41, 99, 525, 32);
		
		male = new JRadioButton("", true);
		male.setLocation(100, 220);
		male.setSize(25, 25);
		
		female = new JRadioButton("", false);
		female.setSize(25, 25);
		female.setLocation(200, 220);
		
		sexo = new ButtonGroup();
		sexo.add(male);
		sexo.add(female);
		
		//Lista com idades
		ageComboBox = new JComboBox<String>();
		ageComboBox.setModel(new DefaultComboBoxModel<String>(idades)); //Necessario pra editar pelo windowbuilder
		ageComboBox.setLocation(41, 302);
		ageComboBox.setSize(200, 30);
		
		
		
		ageComboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		ageComboBox.setMaximumRowCount(4);
		
		lblMaleLabel = new JLabel("");
		lblMaleLabel.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/male.png")));
		lblMaleLabel.setBounds(89, 159, 54, 54);
		add(lblMaleLabel);
		
		lblFemLabel = new JLabel("");
		lblFemLabel.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/female.png")));
		lblFemLabel.setBounds(186, 169, 54, 54);
		add(lblFemLabel);
		
		lblProdutos = new JLabel("Produto");
		lblProdutos.setBounds(41, 279, 70, 14);
		lblProdutos.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		add(male);
		add(female);
		add(nameField);
		add(ageComboBox);
		add(lblProdutos);
	}
}
