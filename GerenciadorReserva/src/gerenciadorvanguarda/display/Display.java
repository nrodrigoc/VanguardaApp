package gerenciadorvanguarda.display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;


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
		
		
	}

}
