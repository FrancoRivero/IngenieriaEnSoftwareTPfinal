package Supermercado;

import java.security.InvalidParameterException;

import main.java.headfirst.combined.djview.BPMObserver;
import main.java.headfirst.combined.djview.BeatObserver;
import main.java.headfirst.combined.djview.HeartModel;

public class SuperModel implements SuperModelInterface {
	
	
	private Carrito carrito;
	
	public SuperModel(){
		carrito = new Carrito ();	
	}
	
	public String toString(){
		String a = "" ;
	
		for (Productos p:carrito.getCarrito()) {
			String c;
			c = p.nombre();
			a += c + "   ||   ";
		    }
		return a;
	}
	
	public int CantidadDeProductos(){
		return carrito.getCantidad();
	}
	
	public void cargarProducto(Productos p){
		carrito.agregarAlCarrito(p);	
	}
	
	public void modificarCarrito(char s){
		if(s == '+' && carrito.getMax() < 40)
		carrito.setMax(carrito.getMax()+1);
		else if(s == '-' && carrito.getMax() > 0)
			carrito.setMax(carrito.getMax()-1);
		
	}
	
	public int getMax(){
		return carrito.getMax();
	}
	

	@Override
	public int getHeartRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}

