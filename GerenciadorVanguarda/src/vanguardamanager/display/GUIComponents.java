package vanguardamanager.display;

import java.awt.Button;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIComponents extends JPanel{
	/**
	 * 
	 */
	//private static final long serialVersionUID = -1137362641783025927L;
	private JTextField nome;
	private JCheckBox boldJCheckBox, italicJCheckBox;
	
	private Font fPlain;
	private Font fBold;
	private Font fItalic;
	private Font fBoldItalic;
	private JTextField cep;
	private JRadioButton rbtPlain;
	private JRadioButton rbtItalic;
	private JRadioButton rbtBold;
	private JRadioButton rbtBoldItalic;
	private ButtonGroup radioGroup;
	
	private JButton btVerificar, btMarcar, btDesmarcar;
	private ImageIcon imageIcon1;
	private JCheckBox ckIngles, ckInformatica;
	
	
	
	public GUIComponents() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		nome = new JTextField("Nome do Cliente");
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		nome.setFont(new Font("Serif", Font.PLAIN, 14));
		boldJCheckBox = new JCheckBox("Bold");
		italicJCheckBox = new JCheckBox("Italic"); 
		
		cep = new JTextField("Digite seu endereço");
		cep.setHorizontalAlignment(SwingConstants.CENTER);
		cep.setFont(new Font("Serif", Font.PLAIN, 13));
		rbtPlain = new JRadioButton("Plain", true);
		rbtBold = new JRadioButton("Bold", false);
		rbtBold.setFont(new Font("Serif", Font.BOLD, 13));
		rbtItalic = new JRadioButton("Italic", false);
		rbtItalic.setFont(new Font("Serif", Font.ITALIC, 13));
		rbtBoldItalic = new JRadioButton("Bold & Italic", false);
		rbtBoldItalic.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 13));
		radioGroup = new ButtonGroup();
		radioGroup.add(rbtPlain);
		radioGroup.add(rbtBold);
		radioGroup.add(rbtItalic);
		radioGroup.add(rbtBoldItalic);
		
		btVerificar = new JButton("Verificar");
		ckIngles = new JCheckBox("Inglês");
		ckInformatica = new JCheckBox("Informática");
		btMarcar = new JButton("Marcar");
		btDesmarcar = new JButton("Desmarcar");
		
		setLayout(null);
		imageIcon1 = new ImageIcon(getClass().getResource("java.png"));
		
		nome.setBounds(200, 15, 200, 25);
		boldJCheckBox.setBounds(240, 45, 50, 25);
		italicJCheckBox.setBounds(300, 45, 60, 25);
		
		cep.setBounds(200, 90, 250, 25);
		rbtPlain.setBounds(185, 120, 60, 25);
		rbtBold.setBounds(246, 120, 60, 25);
		rbtItalic.setBounds(306, 120, 60, 25);
		rbtBoldItalic.setBounds(366, 120, 120, 25);
		
		fPlain = new Font("Serif", Font.PLAIN, 14);
		fBold  = new Font("Serif", Font.BOLD, 14);
		fItalic  = new Font("Serif", Font.ITALIC, 14);
		fBoldItalic = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		
		btVerificar.setBounds(20, 70, 100, 20);
		ckIngles.setBounds(15, 15, 100, 25);
		ckInformatica.setBounds(15, 40, 100, 25);
		btMarcar.setBounds(20, 100, 100, 20);
		btDesmarcar.setBounds(20, 130, 100, 20);
		
		
		add(btVerificar);
		add(ckIngles);
		add(ckInformatica);
		add(btMarcar);
		add(btDesmarcar);
		
		add(nome);
		add(boldJCheckBox);
		add(italicJCheckBox);
		
		add(cep);
		add(rbtBold);
		add(rbtItalic);
		add(rbtPlain);
		add(rbtBoldItalic);
		
	}
	
	private void definirEventos() {
		EventsHandler handler = new EventsHandler();
		btMarcar.addActionListener(handler);
		btDesmarcar.addActionListener(handler);
		btVerificar.addActionListener(handler);
		nome.addMouseListener(handler);
		
		checkHandler checkHandler = new checkHandler();
		boldJCheckBox.addItemListener(checkHandler);
		italicJCheckBox.addItemListener(checkHandler);
		
		rbtPlain.addItemListener(new radioHandler(fPlain));
		rbtBold.addItemListener(new radioHandler(fBold));
		rbtItalic.addItemListener(new radioHandler(fItalic));
		rbtBoldItalic.addItemListener(new radioHandler(fBoldItalic));
		
		//botoes[1].addMouseListener(handler);
	}
	
	private class EventsHandler implements MouseListener, ActionListener{
				
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == nome)
				nome.setText("");
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btMarcar) {
				ckInformatica.setSelected(true);
				ckIngles.setSelected(true);
			}
			
			else if(e.getSource() == btDesmarcar){
				ckInformatica.setSelected(false);
				ckIngles.setSelected(false);
			}
			
			else if(e.getSource() == btVerificar) {
				String selecao = "Selecionados: ";
				if(ckIngles.isSelected())
					selecao += "\nInglês";
				if(ckInformatica.isSelected())
					selecao += "\nInformática";
				
				JOptionPane.showMessageDialog(null, selecao);
			}
			
			
		}
		
	}
	
	private class checkHandler implements ItemListener{
		
		@Override
		public void itemStateChanged(ItemEvent event) {
			
			Font font = null;
			
			if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			
			else if(boldJCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD, 14);
			
			else if(italicJCheckBox.isSelected())
				font = new Font("Serif", Font.ITALIC, 14);
			
			nome.setFont(font);
			
	
			
		}
		
	}
	
	private class radioHandler implements ItemListener{
		
		private Font font;
		
		public radioHandler(Font f) {
			font = f;
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			cep.setFont(font);
		}
		
	}
	
}
