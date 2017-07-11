package simon.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class JogadorListener implements ActionListener{
	private File lista;
	private FileReader listLoader;
	private BufferedReader buffLoader;
	private String botao;
	public static int i=0;
	
	public JogadorListener()
	{
		lista = new File("ListaCores.txt");
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		botao = ((JButton) a.getSource()).getText();
		TelaSimon.btnAmarelo.setEnabled(false);
		TelaSimon.btnAzul.setEnabled(false);
		TelaSimon.btnVerde.setEnabled(false);
		TelaSimon.btnVermelho.setEnabled(false);
		try {
			listLoader = new FileReader(lista);
			buffLoader = new BufferedReader(listLoader);
			
			ArrayList<String> cores = new ArrayList<String>();
			while(buffLoader.ready())
			{
				cores.add(buffLoader.readLine());
			}
				try{
					if(cores.get(i).compareTo(botao)!=0)
					{

						JOptionPane.showMessageDialog(null,"VOCÊ PERDEU!\n A cor era " + cores.get(i)+", PONTUAÇÃO: "+(cores.size()-1));
						FileWriter pontuacao = new FileWriter("Player.txt",true);
						@SuppressWarnings("resource")
						BufferedWriter buffpont = new BufferedWriter(pontuacao);
						buffpont.write("> "+(cores.size()-1));
						buffpont.newLine();
						buffpont.flush();
						System.exit(0);
					}
					else
					{
						TelaSimon.btnAmarelo.setEnabled(true);
						TelaSimon.btnAzul.setEnabled(true);
						TelaSimon.btnVerde.setEnabled(true);
						TelaSimon.btnVermelho.setEnabled(true);
					}
					
					i++;
					if(i>= cores.size())
					{
						i=0;
						TelaSimon.gthread.run();
					}
				}catch(Exception e){
					i=0;
				}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"ERRO NO BANCO DE DADOS");
		}finally{
			this.close();
		}	
		
	}
	
	public void close()
	{
		try{
			buffLoader.close();
			listLoader.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"ERRO NO BANCO DE DADOS");
		}
		
	}
	
}
