package gerenciadorvanguarda.display;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Display extends JFrame{
		
	CashierPanel cashier;
	
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 975, 675);
		getContentPane().setLayout(null);
		
		cashier = new CashierPanel();
		getContentPane().add(cashier);
		
		
	}

}
