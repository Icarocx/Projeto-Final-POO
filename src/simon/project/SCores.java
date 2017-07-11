package simon.project;

import java.util.Random;

public class SCores {
	private String cor;
	private Random gerador;
	
	public SCores()
	{
		cor="";
		gerador = new Random();
	}
	
	public int gera()
	{
		return gerador.nextInt(4);
	}
	
	public String ler(int x)
	{
		switch(x)
		{
		case 0:
			cor = "AZUL";break;
		case 1:
			cor = "AMARELO";break;
		case 2:
			cor = "VERDE";break;
		case 3:
			cor = "VERMELHO";break;
		}
		return cor;
	}
	
	
	
}
