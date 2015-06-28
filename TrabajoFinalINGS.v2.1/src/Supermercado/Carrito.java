package Supermercado;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Carrito {
	
	private ArrayList<Productos> carrito = new ArrayList <Productos>();
	private int max, cantidad;
	
	public Carrito (){
		cantidad=0;
		max = 10;
	}
	
	public void agregarAlCarrito(Productos p){
		
		if(cantidad == max){
			JFrame ventana = new JFrame();
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setVisible(true);
			ventana.setSize(new Dimension(250,150));
			ventana.getContentPane().setLayout(new FlowLayout());
			JLabel productos = new JLabel("CARRITO LLENO");
			ventana.getContentPane().add(productos);
		}
		else{
			cantidad++;	
			carrito.add(p);	
		}
		
	}
	public ArrayList<Productos> getCarrito()
	{
		return carrito;
	}
	
	public int getCantidad(){
		return cantidad;
	}
	
	public void setMax(int n){
		max = n;
	}
	
	public int getMax(){
		return max;
	}
}

