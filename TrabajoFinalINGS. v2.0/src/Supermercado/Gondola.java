package Supermercado;

import java.util.ArrayList;

public class Gondola {
	
	private ArrayList <Productos> catalogo = new ArrayList <Productos>();
	
	public Gondola (){
		this.agregarStock();	
	}
	
	private void agregarStock(){
		
		Productos a = new Productos ("azucar");
		catalogo.add(a);
		
		Productos b = new Productos ("aceite");
		catalogo.add(b);
		
		Productos c = new Productos ("yerba");
		catalogo.add(c);
		
		Productos d = new Productos ("jugo");
		catalogo.add(d);
		
		Productos e = new Productos ("arroz");
		catalogo.add(e);
		
		Productos f = new Productos ("sal");
		catalogo.add(f);
		
		Productos g = new Productos ("tapa de asado");
		catalogo.add(g);
		
		Productos h = new Productos ("chinchulin");
		catalogo.add(h);
		
		Productos i = new Productos ("chimi");
		catalogo.add(i);
		
	}
	
	public ArrayList<Productos> retornarCatalogo(){
		return catalogo;
	}

}
