package simon.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaInicialGame extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[]Args)
	{
		TelaInicialGame tela = new TelaInicialGame();
		tela.setVisible(true);
	}

	public TelaInicialGame() {
		setTitle("Bem-Vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRegras = new JLabel("REGRAS");
		lblRegras.setFont(new Font("Swis721 Lt BT", Font.BOLD, 18));
		lblRegras.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRegras, BorderLayout.NORTH);
		
		JTextArea txtRegras = new JTextArea();
		txtRegras.setFont(new Font("Humnst777 BT", Font.PLAIN, 13));
		txtRegras.setEditable(false);
		panel.add(txtRegras, BorderLayout.CENTER);
		txtRegras.setText("1. Digite seu nome e pressione começar para iniciar o jogo."+"\n"+
		"2. Os quadros acenderão um por rodada, porém,"+"\n"+"para prosseguir, você deve memorizar toda a sequencia"+"\n"+
				"3. A cada rodada só será acesso o quadro que representa a nova cor da\n sequência! Então memorize bem todo o resto!"+
		"\n\n BOA SORTE!");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		JButton btnNewButton = new JButton("Pontua\u00E7\u00F5es");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				TelaRecordes recordes = new TelaRecordes();
				recordes.setVisible(true);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("JOGAR!");
		btnNewButton_2.setBackground(new Color(67,160,71));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				TelaSimon simon = new TelaSimon();
				simon.setVisible(true);
			}
		});
		panel_1.add(btnNewButton_2);
	}

}
