package gerenciadorvanguarda.display;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;


public class Display extends JFrame{
		
	CashierPanel cashier;
	
	public Display() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Display.class.getResource("/images/heart.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 975, 675);
		getContentPane().setLayout(null);
		setUndecorated(true);
		cashier = new CashierPanel();
		getContentPane().add(cashier);
		
		RowPanel rowPanel = new RowPanel();
		rowPanel.setBounds(682, 234, 287, 402);
		cashier.add(rowPanel);
		
		JButton btnConfirma = new JButton("GO");
		btnConfirma.setBounds(350, 548, 90, 41);
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 3; i++) {
					if(!cashier.getClientName().isEmpty() && !cashier.getClientName().equalsIgnoreCase("  Nome do cliente")) {
						System.out.println("Teste de envio 1");
						if(cashier.getArrayProdutos().get(i).getSelectedIndex() == 0) {
							System.out.println("Teste de envio 2");
							String nome = cashier.getClientName();
							int quantidade = (int) cashier.getArrayQuantidades().get(i).getSelectedItem();
							rowPanel.addToRow(nome, quantidade);
							break;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Campo \"Nome do cliente\" inválido.");
						break;
					}
					
				}
			}
		});
		cashier.add(btnConfirma);
		
		JButton btnCancela = new JButton("CANCEL");
		btnCancela.setBounds(450, 548, 90, 41);
		cashier.add(btnCancela);
		
		JButton btnFila = new JButton("Fila");
		btnFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rowPanel.isVisible())
					rowPanel.setVisible(false);
				else
					rowPanel.setVisible(true);
			}
		});
		btnFila.setBounds(682, 637, 287, 30);
		btnFila.setFont(new Font("SansSerif", Font.PLAIN, 22));
		cashier.add(btnFila);
		
		JButton btnFechar = new JButton("");
		btnFechar.setIcon(new ImageIcon(CashierPanel.class.getResource("/images/cancel.png")));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnFechar.setMnemonic('W');
		btnFechar.setBackground(Color.LIGHT_GRAY);
		btnFechar.setForeground(Color.LIGHT_GRAY);
		
		btnFechar.setBounds(929, 11, 30, 30);
		cashier.add(btnFechar);
		
		
	}
}
