package vanguardamanager.display;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
	
public class Display extends JFrame{
	
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnExemplos;
	private JMenuItem 	miSair, miBotao;
	
	
	public Display() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() { 
		setTitle("Varguada's App");
		setBounds(0, 0, 975, 675);
		contentPane = getContentPane();
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnExemplos = new JMenu("Exemplos");
		mnExemplos.setMnemonic('E');
		Icon heart = new ImageIcon(getClass().getResource("heart.png"));
		miSair = new JMenuItem("Sair", heart);
		miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		miBotao = new JMenuItem("Botao");
		mnArquivo.add(miSair);
		mnExemplos.add(miBotao);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnExemplos);
		setJMenuBar(mnBarra);
		
		
		
	}
	
	
	private void definirEventos() {

		EventsHandler handler = new EventsHandler();
		miSair.addActionListener(handler);
		miBotao.addActionListener(handler);
	}
	
	public static void abrir() {
		Display frame = new Display();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2, (tela.height - frame.getSize().height)/2);
		frame.setVisible(true);
		
	}
	
	private class EventsHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//String string = "";
			
			if(e.getSource() == miSair)
				System.exit(0);
			
			else if(e.getSource() == miBotao) {
				GUIComponents botao = new GUIComponents();
				System.out.println("Aqui");
				contentPane.removeAll();
				contentPane.add(botao);
				contentPane.validate();
			}
				
			
			
			//if(e.getSource() == textField1)

				
			//JOptionPane.showMessageDialog(null, string); 
			
			
		}
		
	}
	
	
	
	
}

	
	
	