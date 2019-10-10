package vanguardamanager.display;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import vanguardamanager.gfx.Assets;

public class GUInterface extends JPanel{
	
	private JTextField nome;
	private JComboBox<String> itens;	
	private static final String[] names = {"Flecha", "Tiro", "Alvo"};
	
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup sexo;
	
	private ImageIcon maleIcon;
	private ImageIcon femaleIcon;
	
	private JLabel maleLabel;
	private JLabel femaleLabel;
	
	public GUInterface() {
		iniciarComponentes();
		definirEventos();
	}
	
	private void iniciarComponentes() {
		setLayout(null);
		
		//Ícones
		
		maleIcon = new ImageIcon(Assets.maleIcon);
		femaleIcon = new ImageIcon(Assets.femaleIcon);
		
		//Labels com ícones
		maleLabel = new JLabel(maleIcon);
		maleLabel.setBounds(90, 85, 50, 50);
		femaleLabel = new JLabel(femaleIcon);
		femaleLabel.setBounds(155, 85, 50, 50);
		
		//TextField nome do cliente
		nome = new JTextField("Nome do Cliente");
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nome.setBounds(80, 50, 500, 28);
		
		//Caixa de opções
		itens = new JComboBox<String>(names);
		itens.setBounds(80, 170, 200, 30);
		itens.setFont(new Font("SansSerif", Font.PLAIN, 15));
		itens.setMaximumRowCount(3);
		
		//Botoes de rádio
		male = new JRadioButton("", true);
		male.setBounds(100, 140, 25, 25);
		female = new JRadioButton("", false);
		female.setBounds(170, 140, 25, 25);
		sexo = new ButtonGroup();
		sexo.add(male);
		sexo.add(female);
		
		add(nome);
		add(itens);
		add(male);
		add(female);
		add(maleLabel);
		add(femaleLabel);
	}
	
	private void definirEventos() {
		itens.addItemListener(
			new ItemListener() {
					
				@Override
				public void itemStateChanged(ItemEvent event) {
					if(event.getStateChange() == ItemEvent.SELECTED)
						JOptionPane.showMessageDialog(null, names[itens.getSelectedIndex()]);
					
				}
			}
		);
		
		
		
	}
	
}
