package Supermercado;

import main.java.headfirst.combined.djview.BeatModelInterface;


public interface SuperModelInterface extends BeatModelInterface {
	
	public String toString();
	public int CantidadDeProductos();
	public void cargarProducto(Productos p);
	public void modificarCarrito(char s);
	public int getMax();
}
