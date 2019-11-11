package gerenciadorvanguarda.display;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RowPanel extends JPanel{
	
	private ArrayList<String> individuals;
	
	public RowPanel() {
		setBounds(682, 238, 287, 402);
		setLayout(null);
		setVisible(false);
		
		
		JLabel lblEspera = new JLabel("Nathan Rodrigo");
		lblEspera.setBounds(60, 335, 168, 32);
		lblEspera.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspera.setFont(new Font("SansSerif", Font.PLAIN, 18));
		add(lblEspera);
		
		
	}
	
	public void addToRow(String name){
		individuals.add(name);
	}
}
