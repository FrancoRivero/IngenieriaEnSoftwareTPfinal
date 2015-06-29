package Supermercado;

import java.util.ArrayList;

import main.java.headfirst.combined.djview.BPMObserver;
import main.java.headfirst.combined.djview.BeatObserver;

public class SuperModel implements SuperModelInterface {
	
	private ArrayList<BPMObserver> BPMObservers = new ArrayList<BPMObserver>();
	private ArrayList<BeatObserver> BeatObservers = new ArrayList<BeatObserver>();
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
	public void registerObserver(BeatObserver o){
		BeatObservers.add(o);
	}
	@Override
	public void removeObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		try{
			BeatObservers.remove(BeatObservers.indexOf(o));
		}catch(IndexOutOfBoundsException e){}
	}
	@Override
			public void removeObserver(BPMObserver o) {
		// TODO Auto-generated method stub
			try{
				BPMObservers.remove(BPMObservers.indexOf(o));
			}catch(IndexOutOfBoundsException e){}
		}
	public void registerObserver(BPMObserver o) {
		BPMObservers.add(o);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		carrito.setMax(bpm);
	}

	@Override
	public int getBPM() {
		// TODO Auto-generated method stub
		return getMax();
	}
	

}

