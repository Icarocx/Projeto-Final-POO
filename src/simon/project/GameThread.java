package simon.project;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameThread implements Runnable{
	private File lista;
	private FileWriter listSaver;
	private BufferedWriter buffSaver;
	private Sequencia sequencia;
	private SCores cores;
	private JogadorListener jogador;
	private String cor;
	private JButton btnAzul;
	private JButton btnAmarelo;
	private JButton btnVerde;
	private JButton btnVermelho;
	
	private JFrame tela;
	
	public GameThread(JFrame tela, JButton amarelo, JButton azul, JButton verde, JButton vermelho)
	{
		lista = new File("ListaCores.txt");
		try {
			if(lista.exists())
			{
				lista.delete();
			}
			lista.createNewFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		sequencia = new Sequencia();
		cores = new SCores();
		jogador = new JogadorListener(amarelo,azul,verde,vermelho);
		this.btnAmarelo = amarelo;
		this.btnAzul = azul;
		this.btnVerde = verde;
		this.btnVermelho = vermelho;
		
		
		this.tela = tela;
	}
	@Override
	public void run() {
		btnAmarelo.setEnabled(false);
		btnAzul.setEnabled(false);
		btnVerde.setEnabled(false);
		btnVermelho.setEnabled(false);
		sequencia.adicionar(cores.gera());
		try {
			listSaver = new FileWriter(lista,true);
			buffSaver = new BufferedWriter(listSaver);
			buffSaver.write(cores.ler(sequencia.ultimo()));
			buffSaver.newLine();
			buffSaver.flush();
		} catch (IOException e5) {
			JOptionPane.showMessageDialog(null, "ERRO DE ESCRITA");
		}finally{
			this.close();
		}
		
			for (int i = 0;i<sequencia.getSeq().size();i++)	{	
			cor = cores.ler(sequencia.getSeq().get(i));
					btnAmarelo.setEnabled(false);
					btnAzul.setEnabled(false);
					btnVerde.setEnabled(false);
					btnVermelho.setEnabled(false);
					try {
						Thread.sleep(600);
					} catch (InterruptedException e5) {
						// TODO Auto-generated catch block
						e5.printStackTrace();
					}
					switch(cor){
					case "VERDE":
						btnVerde.setBackground(Color.GREEN);
						tela.revalidate();
						try {
							Thread.sleep(600);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
						btnVerde.setBackground(Color.WHITE);
						break;
					case "VERMELHO":
						btnVermelho.setBackground(Color.RED);
						try {
							Thread.sleep(600);
						} catch (InterruptedException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						btnVermelho.setBackground(Color.WHITE);
						break;
					case "AZUL":
						btnAzul.setBackground(Color.BLUE);
						try {
							Thread.sleep(600);
						} catch (InterruptedException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						btnAzul.setBackground(Color.WHITE);
						break;
					case "AMARELO":
						btnAmarelo.setBackground(Color.YELLOW);
						try {
							Thread.sleep(600);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						btnAmarelo.setBackground(Color.WHITE);
						break;
					}
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					btnAmarelo.setBackground(Color.WHITE);
					btnAzul.setBackground(Color.WHITE);
					btnVerde.setBackground(Color.WHITE);
					btnVermelho.setBackground(Color.WHITE);
					btnAmarelo.setEnabled(true);
					btnAzul.setEnabled(true);
					btnVerde.setEnabled(true);
					btnVermelho.setEnabled(true);
			}
		try{
			btnVerde.removeActionListener(jogador);
			btnVermelho.removeActionListener(jogador);
			btnAzul.removeActionListener(jogador);
			btnAmarelo.removeActionListener(jogador);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error!");
			System.exit(0);
		}
		btnVerde.addActionListener(jogador);
		btnVermelho.addActionListener(jogador);
		btnAzul.addActionListener(jogador);
		btnAmarelo.addActionListener(jogador);
		btnAmarelo.setEnabled(true);
		btnAzul.setEnabled(true);
		btnVerde.setEnabled(true);
		btnVermelho.setEnabled(true);
		
	}
	
	public void close()
	{
		try {
			buffSaver.close();
			listSaver.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
	}
	
}
