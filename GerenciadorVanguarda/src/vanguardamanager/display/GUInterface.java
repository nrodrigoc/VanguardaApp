package vanguardamanager.display;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

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
	
	private JTextField nome, quantidade, valorUnit;
	
	private JComboBox<String> itensComboBox;	
	private static final String[] itens = {"Flecha", "Tiro", "Alvo"};
	private JComboBox<String> ageComboBox;	
	private static final String[] idades = {"+18 anos", "17 até 13 anos", "12 até 6 anos", "5 anos ou menos"};
	
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup sexo;
	
	private JButton adicionar;
	
	private ImageIcon maleIcon;
	private ImageIcon femaleIcon;
	
	private JLabel maleLabel, femaleLabel, idadeLabel;
	private JLabel produtosLabel, quantiddLabel, valorULabel;
	
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
		
		quantidade = new JTextField(); //Quantidade do produto
		quantidade.setBounds(350, 200, 70, 30);
		quantidade.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		valorUnit = new JTextField("R$ "); //Quantidade do produto
		valorUnit.setBounds(465, 200, 85, 30);
		valorUnit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		valorUnit.setEditable(false);
		valorUnit.setToolTipText("Valor unitário do produto");
		valorUnit.setOpaque(true);
		
		//Caixa de opções dos produtos
		itensComboBox = new JComboBox<String>(itens);
		itensComboBox.setBounds(80, 200, 200, 30);
		itensComboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		itensComboBox.setMaximumRowCount(3);
		
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
		add(itensComboBox);
		add(male);
		add(female);
		add(maleLabel);
		add(femaleLabel);
		add(produtosLabel);
		add(valorULabel);
		add(quantidade);
		add(valorUnit);
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
		quantidade.addActionListener(handler);
		
		
		
		itensComboBox.addItemListener(
			new ItemListener() {
					
				@Override
				public void itemStateChanged(ItemEvent event) {
					if(event.getStateChange() == ItemEvent.SELECTED)
						JOptionPane.showMessageDialog(null, itens[itensComboBox.getSelectedIndex()]);
					
				}
			}
		);
		
		
		
	}
	
	private class EventsHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == adicionar)
				JOptionPane.showMessageDialog(null, "Otario");
			
			else if(e.getSource() == quantidade)
				if(!isAlpha(quantidade.getText()))
					valorUnit.setText("R$ " + quantidade.getText());
				else
					JOptionPane.showMessageDialog(null, "              Por favor\n Digite apenas números");
			
		}
		
	}
	
	private class MouseController implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == nome)
				nome.setText("");
			
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
	
	
	public boolean isAlpha(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    return true;
	}
	
}
