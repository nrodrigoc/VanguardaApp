package gerenciadorvanguarda.display;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

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
	
	private JComboBox<String> itensComboBox;	
	private static final String[] itens = {"Flecha", "Tiro", "Alvo"};
	
	private JLabel lblProdutos;
	private JTextField textField;
	private JLabel lblQuantidade;
	private JTextField tfValor;
	private JLabel lblValor;
	
	
	public CashierPanel() {
		setBounds(0, 0, 969, 646);
		setLayout(null);
		
		nameField = new JTextField();
		nameField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setBounds(49, 57, 483, 32);
		
		male = new JRadioButton("", true);
		male.setLocation(108, 178);
		male.setSize(20, 20);
		
		female = new JRadioButton("", false);
		female.setSize(20, 20);
		female.setLocation(208, 178);
		
		sexo = new ButtonGroup();
		sexo.add(male);
		sexo.add(female);
		
		//Lista com idades
		ageComboBox = new JComboBox<String>();
		ageComboBox.setModel(new DefaultComboBoxModel<String>(idades)); //Necessario pra editar pelo windowbuilder
		ageComboBox.setBounds(392, 168, 200, 30);
		ageComboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		ageComboBox.setMaximumRowCount(4);
		add(ageComboBox);
		
		//Lista com produtos
		itensComboBox = new JComboBox<String>();
		itensComboBox.setModel(new DefaultComboBoxModel<String>(itens)); //Necessario pra editar pelo windowbuilder
		itensComboBox.setBounds(49, 241, 200, 30);
		itensComboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		itensComboBox.setMaximumRowCount(4);
		add(itensComboBox);
		
		lblMaleLabel = new JLabel("");
		lblMaleLabel.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/male.png")));
		lblMaleLabel.setBounds(97, 117, 54, 54);
		add(lblMaleLabel);
		
		lblFemLabel = new JLabel("");
		lblFemLabel.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/female.png")));
		lblFemLabel.setBounds(194, 120, 54, 54);
		add(lblFemLabel);
		
		lblProdutos = new JLabel("Produto");
		lblProdutos.setBounds(49, 218, 70, 14);
		lblProdutos.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		add(male);
		add(female);
		add(nameField);
		add(lblProdutos);
		
		
		JLabel idadeLabel = new JLabel("Idade aproximada");
		idadeLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		idadeLabel.setBounds(392, 145, 150, 14);
		add(idadeLabel);
		
		textField = new JTextField();
		textField.setBounds(350, 241, 70, 30);
		add(textField);
		textField.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuantidade.setBounds(350, 218, 90, 14);
		add(lblQuantidade);
		
		tfValor = new JTextField("R$");
		tfValor.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tfValor.setEditable(false);
		tfValor.setColumns(10);
		tfValor.setBounds(462, 241, 70, 30);
		add(tfValor);
		
		lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblValor.setBounds(462, 218, 90, 14);
		add(lblValor);
	}
}
