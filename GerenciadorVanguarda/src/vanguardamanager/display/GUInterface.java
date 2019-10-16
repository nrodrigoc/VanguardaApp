package vanguardamanager.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ButtonGroup;
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
	
	private int count;
	
	private NumberFormat nf = new DecimalFormat("R$,##0.00");
	
	private JTextField nome, valorTotal;
	
	private ArrayList<JTextField> quantidade, valorUnit;
	private ArrayList<JComboBox<String>> itensComboBox;	
	
	private static final String[] itens = {"Flecha", "Tiro", "Alvo"};
	private JComboBox<String> ageComboBox;	
	private static final String[] idades = {"+18 anos", "13 a 17 anos", "6 até 12 anos", "5 anos ou menos"};
	
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup sexo;
	
	private JButton adicionar;
	
	private ImageIcon maleIcon;
	private ImageIcon femaleIcon;
	
	private JLabel maleLabel, femaleLabel, idadeLabel;
	private JLabel produtosLabel, quantiddLabel, valorULabel;
	
	public GUInterface() {
		itensComboBox = new ArrayList<JComboBox<String>>();
		quantidade = new ArrayList<JTextField>();
		valorUnit = new ArrayList<JTextField>();
		iniciarComponentes();
		definirEventos(); 
		
		
		count = 0;
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
		
		//Labels sem ícones
		produtosLabel = new JLabel("Produto");
		produtosLabel.setBounds(80, 170, 70, 30);
		produtosLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		quantiddLabel = new JLabel("Quantidade");
		quantiddLabel.setBounds(350, 170, 100, 30);
		quantiddLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		idadeLabel = new JLabel("Idade aproximada");
		idadeLabel.setBounds(350, 85, 150, 30);
		idadeLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		valorULabel = new JLabel("Valor");
		valorULabel.setBounds(465, 170, 70, 30);
		valorULabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		//TextFields
		nome = new JTextField("Nome do Cliente"); //Nome do Cliente
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nome.setBounds(80, 50, 400, 28);
		
		valorTotal = new JTextField("Valor total: R$ 0,00");
		valorTotal.setBounds(80, 500, 300, 40);
		valorTotal.setFont(new Font("SansSerif", Font.PLAIN, 22));
		valorTotal.setBackground(Color.WHITE);
		valorTotal.setEditable(false);
		
		
		//Caixa de opções dos produtos
		quantidade.add(new JTextField()); //Quantidade do produto
		int z = 200;
		for(int i = 0; i < 3; i++) {
			itensComboBox.add(new JComboBox<String>(itens));
			itensComboBox.get(i).setBounds(80, z, 200, 30);
			itensComboBox.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			itensComboBox.get(i).setMaximumRowCount(3);
			
			quantidade.add(new JTextField()); //Quantidade do produto
			quantidade.get(i).setBounds(350, z, 70, 30);
			quantidade.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			
			valorUnit.add(new JTextField("R$ ")); //Valor do produto
			valorUnit.get(i).setBounds(465, z, 85, 30);
			valorUnit.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			valorUnit.get(i).setEditable(false);
			valorUnit.get(i).setToolTipText("Valor unitário do produto");
			valorUnit.get(i).setOpaque(true);
			
			z += 50;
		}
		
		for(int i = 1; i < 3; i++) {
			itensComboBox.get(i).setVisible(false);
			quantidade.get(i).setVisible(false);
			valorUnit.get(i).setVisible(false);
		}
		
		
		//Caixa de opções das idades
		ageComboBox = new JComboBox<String>(idades);
		ageComboBox.setBounds(350, 115, 200, 30);
		ageComboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		ageComboBox.setMaximumRowCount(4);
		
		//Botoes comuns
		adicionar = new JButton("+");
		adicionar.setBounds(487, 235, 43, 30);
		adicionar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		//Botoes de rádio
		male = new JRadioButton("", true);
		male.setBounds(100, 140, 25, 25);
		female = new JRadioButton("", false);
		female.setBounds(170, 140, 25, 25);
		sexo = new ButtonGroup();
		sexo.add(male);
		sexo.add(female);
		
		add(nome);
		add(valorTotal);
		for(int i = 0; i < 3; i++) {
			add(itensComboBox.get(i));
			add(quantidade.get(i));
			add(valorUnit.get(i));
		}
		add(male);
		add(female);
		add(maleLabel);
		add(femaleLabel);
		add(produtosLabel);
		add(valorULabel);
		add(ageComboBox);
		add(quantiddLabel);
		add(idadeLabel);
		add(adicionar);
	}
	
	private void definirEventos() {
		EventsHandler handler = new EventsHandler();
		MouseController mouseHandler = new MouseController();
		nome.addMouseListener(mouseHandler);
		adicionar.addActionListener(handler);
		this.addMouseListener(mouseHandler);
		
		for(int i = 0; i < 3; i++) {
			quantidade.get(i).addActionListener(handler);
			itensComboBox.get(i).addItemListener(handler);
		}
		
		
		
		
	}
	
	private class EventsHandler implements ActionListener, ItemListener{
		
		private int index;
		
		public EventsHandler() {
			index = 0;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == adicionar)
				addComboBox();
			
			for(int i = 0; i < 3; i++) {
				if(e.getSource() == quantidade.get(i)){
					if(!isAlpha(quantidade.get(i).getText()))
						valorUnit.get(i).setText(verificarCombosFlecha(Integer.parseInt(quantidade.get(i).getText())));
					else
					 JOptionPane.showMessageDialog(null, "              Por favor\n Digite apenas números");
				
				}
			}
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			for(int i = 0; i < 3; i++)
				if(e.getSource() == itensComboBox.get(i))
					setIndex(i);
					
			if(e.getStateChange() == ItemEvent.SELECTED)
				JOptionPane.showMessageDialog(null, itens[itensComboBox.get(index).getSelectedIndex()]);
			
		}
		
		public void setIndex(int i) {
			index = i;
		}
		
	}
	
	private class MouseController implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() instanceof JTextField)
				nome.setText("");
			
			if(e.getSource() == this)
				JOptionPane.showMessageDialog(null, "Vai tomar no cu tranquilo");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private void addComboBox() {
		
	}
	
	public static boolean isAlpha(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(Character.isLetter(c)) {
	            return true;
	        }
	    }

	    return false;
	}
	
	private String verificarCombosFlecha(int i) {
		if(i == 10)
			return nf.format(5.00);
		else if(i == 5)
			return nf.format(3.00);
		else if(i == 1)
			return nf.format(2.00);
				
		return nf.format(0.00);	
	}
	
}
