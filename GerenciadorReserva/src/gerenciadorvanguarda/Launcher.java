package gerenciadorvanguarda;

import java.awt.Dimension;
import java.awt.Toolkit;

import gerenciadorvanguarda.display.Display;

public class Launcher{
	
	public static void main(String[] args) {
		Display frame = new Display();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2, (tela.height - frame.getSize().height)/2);
		frame.setVisible(true);
	}
}
