package simon.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotaoListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Chamou o botão listener");
		JogadorListener.botao = ((JButton) e.getSource()).getText();
		
	}

}
