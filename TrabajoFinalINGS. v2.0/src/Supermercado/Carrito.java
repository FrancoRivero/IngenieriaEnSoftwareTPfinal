package Supermercado;

import java.util.ArrayList;

public class Carrito {
	
	private ArrayList<Productos> carrito = new ArrayList <Productos>();
	private int max;
	private Gondola g;
	
	public Carrito (int max){
		
		Gondola g = new Gondola();
		
		if (max > 6)
			System.out.println("El carrito esta completo");
		else
			this.max = max;
	}
	
	public void agregarAlCarrito(Productos p){
		ArrayList<Productos> gon = g.retornarCatalogo();
		for(Productos pro: gon)
		{
			if(p.nombre().equals(pro.nombre()))
				carrito.add(pro);
			else
				System.out.println("No existe el producto");
		}
	}
	public void borrarProducto(Productos p)
	{
		ArrayList<Productos> gon = g.retornarCatalogo();
		for(Productos pro: gon)
		{
			if(p.nombre().equals(pro.nombre()))
				carrito.remove(pro);
			else
				System.out.println("No existe el producto");
		}
	}

}

