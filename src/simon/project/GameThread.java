package simon.project;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class GameThread implements Runnable{
	private File lista;
	private FileWriter listSaver;
	private BufferedWriter buffSaver;
	private Sequencia sequencia;
	private SCores cores;
	private JogadorListener jogador;
	private String cor;
	
	public GameThread()
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
		jogador = new JogadorListener();
	}
	@Override
	public void run() {
		TelaSimon.btnAmarelo.setEnabled(false);
		TelaSimon.btnAzul.setEnabled(false);
		TelaSimon.btnVerde.setEnabled(false);
		TelaSimon.btnVermelho.setEnabled(false);
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
			cor = cores.ler(sequencia.ultimo());
			Thread c = new Thread(new Runnable(){

				@Override
				public void run() {
					TelaSimon.btnAmarelo.setEnabled(false);
					TelaSimon.btnAzul.setEnabled(false);
					TelaSimon.btnVerde.setEnabled(false);
					TelaSimon.btnVermelho.setEnabled(false);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e5) {
						// TODO Auto-generated catch block
						e5.printStackTrace();
					}
					switch(cor){
					case "VERDE":
						TelaSimon.btnVerde.setBackground(Color.GREEN);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
						TelaSimon.btnVerde.setBackground(Color.WHITE);
						break;
					case "VERMELHO":
						TelaSimon.btnVermelho.setBackground(Color.RED);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						TelaSimon.btnVermelho.setBackground(Color.WHITE);
						break;
					case "AZUL":
						TelaSimon.btnAzul.setBackground(Color.BLUE);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						TelaSimon.btnAzul.setBackground(Color.WHITE);
						break;
					case "AMARELO":
						TelaSimon.btnAmarelo.setBackground(Color.YELLOW);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						TelaSimon.btnAmarelo.setBackground(Color.WHITE);
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					TelaSimon.btnAmarelo.setBackground(Color.WHITE);
					TelaSimon.btnAzul.setBackground(Color.WHITE);
					TelaSimon.btnVerde.setBackground(Color.WHITE);
					TelaSimon.btnVermelho.setBackground(Color.WHITE);
					TelaSimon.btnAmarelo.setEnabled(true);
					TelaSimon.btnAzul.setEnabled(true);
					TelaSimon.btnVerde.setEnabled(true);
					TelaSimon.btnVermelho.setEnabled(true);
				}
			});c.start();
		try{
			TelaSimon.btnVerde.removeActionListener(jogador);
			TelaSimon.btnVermelho.removeActionListener(jogador);
			TelaSimon.btnAzul.removeActionListener(jogador);
			TelaSimon.btnAmarelo.removeActionListener(jogador);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error!");
			System.exit(0);
		}
		TelaSimon.btnVerde.addActionListener(jogador);
		TelaSimon.btnVermelho.addActionListener(jogador);
		TelaSimon.btnAzul.addActionListener(jogador);
		TelaSimon.btnAmarelo.addActionListener(jogador);
		TelaSimon.btnAmarelo.setEnabled(true);
		TelaSimon.btnAzul.setEnabled(true);
		TelaSimon.btnVerde.setEnabled(true);
		TelaSimon.btnVermelho.setEnabled(true);

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
