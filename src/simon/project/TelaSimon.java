package simon.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaSimon extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNewPlayer;
	public static JButton btnAzul;
	public static JButton btnAmarelo;
	public static JButton btnVerde;
	public static JButton btnVermelho;
	public static Thread t;
	
	private JogadorListener jogador;
	public static GameThread gthread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSimon frame = new TelaSimon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaSimon() {
		setTitle("Simon Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Digite seu nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		txtNewPlayer = new JTextField();
		txtNewPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPlayer.setText("new player");
		panel.add(txtNewPlayer);
		txtNewPlayer.setColumns(10);
		
		JButton btnComecar = new JButton("Come\u00E7ar!");
		btnComecar.setBackground(new Color(206,147,216));
		btnComecar.setForeground(Color.WHITE);
		btnComecar.addActionListener(this);
		panel.add(btnComecar);
		
		JPanel cores = new JPanel();
		contentPane.add(cores, BorderLayout.CENTER);
		cores.setLayout(new GridLayout(2, 2, 0, 0));
		
		btnAzul = new JButton("AZUL");
		btnAzul.setForeground(Color.BLUE);
		btnAzul.setBackground(new Color(255,255,255));
		cores.add(btnAzul);
		
		btnAmarelo = new JButton("AMARELO");
		btnAmarelo.setForeground(Color.ORANGE);
		btnAmarelo.setBackground(Color.WHITE);
		cores.add(btnAmarelo);
		
		btnVermelho = new JButton("VERMELHO");
		btnVermelho.setBackground(new Color(255, 255, 255));
		btnVermelho.setForeground(Color.RED);
		cores.add(btnVermelho);
		
		btnVerde = new JButton("VERDE");
		btnVerde.setForeground(Color.GREEN);
		btnVerde.setBackground(new Color(255, 255, 255));
		cores.add(btnVerde);

		
		JLabel lblcaroDeLima = new JLabel("\u00CDcaro de Lima POO 2017");
		lblcaroDeLima.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblcaroDeLima, BorderLayout.SOUTH);
//		TelaSimon.btnVerde.addActionListener(jogador);
//		TelaSimon.btnVermelho.addActionListener(jogador);
//		TelaSimon.btnAzul.addActionListener(jogador);
//		TelaSimon.btnAmarelo.addActionListener(jogador);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		File arq = new File("Player.txt");
		FileWriter fw = null;
//		TelaSimon.btnVerde.addActionListener(jogador);
//		TelaSimon.btnVermelho.addActionListener(jogador);
//		TelaSimon.btnAzul.addActionListener(jogador);
//		TelaSimon.btnAmarelo.addActionListener(jogador);
		try {
			arq.createNewFile();
			fw = new FileWriter(arq,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bf = new BufferedWriter(fw);
		try {
			bf.write(txtNewPlayer.getText()+" --");
			bf.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		txtNewPlayer.setEditable(false);
		
		gthread = new GameThread();
//		t = new Thread(gthread);
//		t.start();
		gthread.run();
	}

}

