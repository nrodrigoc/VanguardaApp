package gerenciadorvanguarda.display;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class RowPanel extends JPanel{
	
	private ArrayList<String> individuals;
	
	private ArrayList<JTextField> positionsNumber;
	private ArrayList<JTextField> nomesDaFila;
	
	JTextField txtAtendido1;
	JTextField txtAtendido2;
	
	private JTextField txtDisparos2;
	private JTextField txtDisparos1;
	private JTextField txtInstrutorB;
	private JTextField txtInstrutorA;
	private JTextField txtFila2;
	private JTextField txtPos2;
	
	private HashMap<String, Integer> disparosHash;
	
	public RowPanel() {
		setBounds(682, 238, 287, 402);
		setLayout(null);
		setVisible(false);
		
		individuals = new ArrayList<String>();
		disparosHash = new HashMap<String, Integer>();
		
		positionsNumber = new ArrayList<JTextField>();
		nomesDaFila = new ArrayList<JTextField>();
		
		
		int posLocY = 198;
		for(int i = 0; i < 5; i++) {
			
			positionsNumber.add(new JTextField("00" + (i+2)));
			positionsNumber.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			positionsNumber.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			positionsNumber.get(i).setBounds(60, posLocY, 47, 22);
			positionsNumber.get(i).setBackground(Color.WHITE);
			positionsNumber.get(i).setEditable(false);
			positionsNumber.get(i).setVisible(true);
			
			nomesDaFila.add(new JTextField());
			nomesDaFila.get(i).setFont(new Font("SansSerif", Font.PLAIN, 15));
			nomesDaFila.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			nomesDaFila.get(i).setBounds(117, posLocY, 124, 22);
			nomesDaFila.get(i).setBackground(Color.WHITE);
			nomesDaFila.get(i).setEditable(false);
			nomesDaFila.get(i).setVisible(true);
			
			add(nomesDaFila.get(i));
			add(positionsNumber.get(i));
			posLocY-=29;
		}
		
		txtAtendido1 = new JTextField("Giorgia Tavares");
		txtAtendido1.setBackground(Color.WHITE);
		txtAtendido1.setEditable(false);
		txtAtendido1.setBounds(91, 331, 168, 32);
		txtAtendido1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtendido1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		add(txtAtendido1);
		
		txtAtendido2 = new JTextField("Nathan Rodrigo");
		txtAtendido2.setBackground(Color.WHITE);
		txtAtendido2.setEditable(false);
		txtAtendido2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtendido2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtAtendido2.setBounds(91, 263, 168, 32);
		add(txtAtendido2);
		
		JLabel lblDisparos2 = new JLabel("Disparos:");
		lblDisparos2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisparos2.setBounds(101, 304, 74, 14);
		add(lblDisparos2);
		
		JLabel lblDisparos1 = new JLabel("Disparos:");
		lblDisparos1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisparos1.setBounds(101, 372, 74, 14);
		add(lblDisparos1);
		
		txtDisparos2 = new JTextField();
		txtDisparos2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisparos2.setBounds(173, 300, 75, 25);
		add(txtDisparos2);
		txtDisparos2.setColumns(10);
		
		txtDisparos1 = new JTextField();
		txtDisparos1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisparos1.setColumns(10);
		txtDisparos1.setBounds(173, 366, 75, 25);
		add(txtDisparos1);
		
		txtInstrutorB = new JTextField();
		txtInstrutorB.setEditable(false);
		txtInstrutorB.setBackground(Color.WHITE);
		txtInstrutorB.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstrutorB.setToolTipText("");
		txtInstrutorB.setText("B");
		txtInstrutorB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtInstrutorB.setBounds(24, 263, 57, 32);
		add(txtInstrutorB);
		
		txtInstrutorA = new JTextField();
		txtInstrutorA.setBackground(Color.WHITE);
		txtInstrutorA.setEditable(false);
		txtInstrutorA.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstrutorA.setToolTipText("");
		txtInstrutorA.setText("A");
		txtInstrutorA.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtInstrutorA.setBounds(24, 331, 57, 32);
		add(txtInstrutorA);
		
		txtFila2 = new JTextField("Aluísio Santos");
		txtFila2.setBackground(Color.WHITE);
		txtFila2.setEditable(false);
		txtFila2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFila2.setFont(new Font("SansSerif", Font.PLAIN, 17));
		txtFila2.setBounds(103, 227, 138, 25);
		add(txtFila2);
		
		txtPos2 = new JTextField();
		txtPos2.setToolTipText("");
		txtPos2.setText("001");
		txtPos2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPos2.setFont(new Font("SansSerif", Font.PLAIN, 17));
		txtPos2.setEditable(false);
		txtPos2.setBackground(Color.WHITE);
		txtPos2.setBounds(43, 227, 50, 25);
		add(txtPos2);
		
	}
	
	public void addToRow(String name, int disparos){
		disparosHash.put(name, disparos);
		individuals.add(name);
	}
	
	/**Método responsável por fazer a fila andar
	 * 
	 * @author Nathan Rodrigo
	 * @param nDoInstrutor
	 */
	public void andarFila(int nDoInstrutor) {
		String atual = individuals.get(nDoInstrutor);
		individuals.remove(nDoInstrutor);
		
		String proximo = individuals.get(2);
		if(nDoInstrutor == 0) {
			txtAtendido1.setText(individuals.get(2));
			txtDisparos1.setText("" + disparosHash.get(proximo));
			disparosHash.remove(atual);
		}else if(nDoInstrutor == 1) {
			txtAtendido2.setText(individuals.get(2));
			txtDisparos2.setText("" + disparosHash.get(proximo));
			disparosHash.remove(atual);
		}
			
		
	}
}
