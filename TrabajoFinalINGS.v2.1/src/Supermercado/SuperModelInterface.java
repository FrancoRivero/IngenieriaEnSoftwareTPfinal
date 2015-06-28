package Supermercado;

import main.java.headfirst.combined.djview.HeartModelInterface;


public interface SuperModelInterface extends HeartModelInterface {
	
	public String toString();
	public int CantidadDeProductos();
	public void cargarProducto(Productos p);
	public void modificarCarrito(char s);
	public int getMax();
}
