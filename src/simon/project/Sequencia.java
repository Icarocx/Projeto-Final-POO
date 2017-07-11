package simon.project;

import java.util.ArrayList;

public class Sequencia {
	private ArrayList<Integer> seq;
	
	public Sequencia()
	{
		this.seq = new ArrayList<Integer>();
	}
	
	public void adicionar(int x)
	{
		this.seq.add(x);
	}
	
	public void listar()
	{
		for(int i=0;i<this.seq.size();i++)
		{
			System.out.println(this.seq.get(i));
		}
	}
	
	public int checar(int i)
	{
		return this.seq.get(i);
	}
	
	public int ultimo()
	{
		return this.seq.get(this.seq.size()-1);
	}
	
	public int tamanho()
	{
		return this.seq.size();
	}
}
