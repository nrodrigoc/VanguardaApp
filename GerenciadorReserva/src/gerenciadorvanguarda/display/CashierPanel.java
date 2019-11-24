package gerenciadorvanguarda.display;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class CashierPanel extends JPanel{
	
	private NumberFormat nf = new DecimalFormat("R$,##0.00");
	
	private RowPanel rowPanel;
	
	private JTextField nameField;
	private JTextField tfValorTotal;
	
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup sexo;
	
	private JLabel lblFemLabel;
	private JLabel lblMaleLabel;
	
	private JComboBox<String> ageComboBox;	
	private static final String[] idades = {"+18 anos", "13 a 17 anos", "6 até 12 anos", "5 anos ou menos"};
	private static final String[] itens = {"Flecha", "Tiro", "Alvo"};
	private static final Integer[] qntdFlechas = {10, 5, 1};
	
	//CB = COMBO BOX
	private ArrayList<JComboBox<String>> arrayCBProdutos;
	private ArrayList<JComboBox<Integer>> arrayCBQuantidades;
	private ArrayList<JTextField> valoresArray;
	
	private JLabel lblQuantidade;
	private JLabel lblProdutos;
	
	private JLabel lblValor;
	private JLabel idadeLabel;
	
	private int nDeValores, nameClicks; //Indice dos valores no array
	private JButton btnFechar;
	private JButton btnAdd;
	
	public CashierPanel() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 979, 676);
		setLayout(null);
		
		nDeValores = 1;
		nameClicks = 0;
		
		arrayCBProdutos = new ArrayList<JComboBox<String>>();
		valoresArray = new ArrayList<JTextField>();
		arrayCBQuantidades = new ArrayList<JComboBox<Integer>>();
		
		nameField = new JTextField();
		nameField.setForeground(SystemColor.textInactiveText);
		nameField.setText("  Nome do cliente");
		nameField.setFont(new Font("SansSerif", Font.BOLD, 17));
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setBounds(49, 57, 483, 32);
		nameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nameClicks == 0) {
					nameField.setText("");
					nameField.setFont(new Font("SansSerif", Font.PLAIN + Font.BOLD, 17));
					nameField.setForeground(Color.BLACK);
					nameClicks++;
				}
			}
		});
		
		male = new JRadioButton("", true);
		male.setBackground(Color.LIGHT_GRAY);
		male.setLocation(108, 178);
		male.setSize(20, 20);
		
		female = new JRadioButton("", false);
		female.setBackground(Color.LIGHT_GRAY);
		female.setSize(20, 20);
		female.setLocation(187, 178);
		
		sexo = new ButtonGroup();
		sexo.add(male);
		sexo.add(female);

		int posYItens = 241; 
		
		for(int i = 0; i < 3; i++) {
			arrayCBProdutos.add(new JComboBox<String>(itens));
			arrayCBProdutos.get(i).setBounds(49, posYItens, 200, 30);
			arrayCBProdutos.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			arrayCBProdutos.get(i).setMaximumRowCount(3);
			
			arrayCBQuantidades.add(new JComboBox<Integer>(qntdFlechas)); //Quantidade do produto
			arrayCBQuantidades.get(i).setBounds(350, posYItens, 70, 30);
			arrayCBQuantidades.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			
			valoresArray.add(new JTextField("R$ ")); //Valor do produto
			valoresArray.get(i).setBounds(462, posYItens, 80, 30);
			valoresArray.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			valoresArray.get(i).setEditable(false);
			valoresArray.get(i).setToolTipText("Valor unitário do produto");
			valoresArray.get(i).setOpaque(true);
			
			posYItens += 60;
		}
		
		for(int i = 1; i < 3; i++) {
			arrayCBProdutos.get(i).setVisible(false);
			arrayCBQuantidades.get(i).setVisible(false);
			valoresArray.get(i).setVisible(false);
		}
		
		for(int i = 0; i < 3; i++) {
			add(arrayCBProdutos.get(i));
			add(arrayCBQuantidades.get(i));
			add(valoresArray.get(i));
		}
		
		
		//Lista com idades
		ageComboBox = new JComboBox<String>();
		ageComboBox.setModel(new DefaultComboBoxModel<String>(idades)); //Necessario pra editar pelo windowbuilder
		ageComboBox.setBounds(392, 168, 200, 30);
		ageComboBox.setFont(new Font("SansSerif", Font.PLAIN, 15));
		ageComboBox.setMaximumRowCount(4);
		add(ageComboBox);
		
		lblMaleLabel = new JLabel("");
		lblMaleLabel.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/male.png")));
		lblMaleLabel.setBounds(97, 117, 54, 54);
		add(lblMaleLabel);
		
		lblFemLabel = new JLabel("");
		lblFemLabel.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/female.png")));
		lblFemLabel.setBounds(173, 120, 54, 54);
		add(lblFemLabel);
		
		lblProdutos = new JLabel("Produto");
		lblProdutos.setBounds(49, 218, 70, 14);
		lblProdutos.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		add(male);
		add(female);
		add(nameField);
		add(lblProdutos);
		
		idadeLabel = new JLabel("Idade aproximada");
		idadeLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		idadeLabel.setBounds(392, 145, 150, 14);
		add(idadeLabel);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuantidade.setBounds(350, 218, 90, 14);
		add(lblQuantidade);
		
		lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblValor.setBounds(462, 218, 90, 14);
		add(lblValor);
		
		btnAdd = new JButton("+");
		btnAdd.setBounds(475, 282, 54, 30);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nDeValores < itens.length) { //Se a quantidade de valores for menor que o numero de itens...
					
					arrayCBProdutos.get(nDeValores).setVisible(true);
					valoresArray.get(nDeValores).setVisible(true);
					arrayCBQuantidades.get(nDeValores).setVisible(true);
					
					btnAdd.setLocation(btnAdd.getX(), btnAdd.getY() + (60*nDeValores));
					nDeValores++;
				}
				if (nDeValores == 3)
					btnAdd.setVisible(false);
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setHorizontalAlignment(SwingConstants.CENTER);
		add(btnAdd);
		
		tfValorTotal = new JTextField("Valor total: R$ 0,00");
		tfValorTotal.setBackground(Color.WHITE);
		tfValorTotal.setBounds(49, 548, 287, 41);
		tfValorTotal.setFont(new Font("SansSerif", Font.PLAIN, 22));
		tfValorTotal.setEditable(false);
		add(tfValorTotal);
		
		rowPanel = new RowPanel();
		add(rowPanel);
		
		JButton btnFila = new JButton("Fila");
		btnFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rowPanel.isVisible())
					rowPanel.setVisible(false);
				else
					rowPanel.setVisible(true);
			}
		});
		btnFila.setBounds(682, 640, 287, 30);
		btnFila.setFont(new Font("SansSerif", Font.PLAIN, 22));
		add(btnFila);
		
		btnFechar = new JButton("");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnFechar.setMnemonic('W');
		btnFechar.setBackground(Color.LIGHT_GRAY);
		btnFechar.setForeground(Color.LIGHT_GRAY);
		btnFechar.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/cancel.png")));
		btnFechar.setBounds(929, 11, 30, 30);
		add(btnFechar);
		
		JButton btnConfirma = new JButton("GO");
		btnConfirma.setBounds(376, 548, 90, 41);
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 3; i++) {
					if(!nameField.getText().isEmpty() && !nameField.getText().equalsIgnoreCase("  Nome do cliente")) {
						System.out.println("Teste de envio 1");
						if(arrayCBProdutos.get(i).getSelectedIndex() == 0) {
							System.out.println("Teste de envio 2");
							String nome = nameField.getText();
							int quantidade = (int) arrayCBQuantidades.get(i).getSelectedItem();
							rowPanel.addToRow(nome, quantidade);
							break;
						}
					}else {
						JOptionPane.showMessageDialog(null, "  Campos \"Nome do cliente\" ou "
								+ "\nquantidade de flechas inválidos.");
						break;
					}
					
				}
			}
		});
		add(btnConfirma);
		
		JButton btnCancela = new JButton("CANCEL");
		btnCancela.setBounds(476, 548, 90, 41);
		add(btnCancela);
		
		definirEventos();
	}
	
	private void definirEventos() {
		EventsHandler handler = new EventsHandler();
		for(int i = 0; i < 3; i++) {
			arrayCBQuantidades.get(i).addActionListener(handler);
		}
	}
	
	private String verificarCombosFlecha(int i) {
		if(i == 10)
			return nf.format(5.00);
		else if(i == 5)
			return nf.format(3.00);
		else if(i == 1)
			return nf.format(1.00);
		
		return nf.format(0.00);	
	}
	
	private class EventsHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 3; i++) {
				if(e.getSource() == arrayCBQuantidades.get(i)){
						valoresArray.get(i).setText(verificarCombosFlecha((int) (arrayCBQuantidades.get(i).getSelectedItem())));
				
				}
			}
		}
		
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
}
