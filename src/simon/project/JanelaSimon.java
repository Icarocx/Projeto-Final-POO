package simon.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaSimon extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JanelaSimon()
	{
		setTitle("Simon Game");
		setSize(700, 500);
		setVisible(true);
		
		//LABELS
		JPanel tela = new JPanel();
		tela.setVisible(true);
		tela.setBackground(Color.GRAY);
		tela.setLayout(new BorderLayout());
		this.add(tela);
		JLabel titulo = new JLabel("SIMON GAME");
		tela.add(titulo,BorderLayout.NORTH);
		JPanel cores = new JPanel();
		cores.setLayout(new GridLayout(2,2));
		JButton azul = new JButton();
		azul.setBackground(new Color(30,136,229));
		JButton amarelo = new JButton();
		amarelo.setBackground(new Color(255,235,59));
		JButton vermelho = new JButton();
		vermelho.setBackground(new Color(229,57,53));
		JButton verde = new JButton("Verde");
		verde.setBackground(new Color(67,160,71));
		cores.add(azul);
		cores.add(amarelo);
		cores.add(vermelho);
		cores.add(verde);
		cores.setVisible(true);
		tela.add(cores);
		JLabel rodape = new JLabel("Icaro de Lima");
		tela.add(rodape,BorderLayout.SOUTH);
	}
	
}
