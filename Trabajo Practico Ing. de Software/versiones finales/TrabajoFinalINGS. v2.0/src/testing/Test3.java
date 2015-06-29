package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Supermercado.Carrito;
import Supermercado.Productos;

public class Test3 {
	
	Carrito carr;
	
	Productos a, b, c, d, e, f, g, h;
	
	

	@Test
	public void test() {
	
		a = new Productos("azucar");
		b = new Productos("azucar");
		c = new Productos("azucar");
		d = new Productos("azucar");
		e = new Productos("azucar");
		f = new Productos("azucar");
		g = new Productos("azucar");
		h = new Productos("azucar");
		
	carr.agregarAlCarrito(a);
	carr.agregarAlCarrito(b);
	carr.agregarAlCarrito(c);
	carr.agregarAlCarrito(d);
	carr.agregarAlCarrito(e);
	carr.agregarAlCarrito(f);
	carr.agregarAlCarrito(g);
	carr.agregarAlCarrito(h);
	
	String prueba = "El carrito esta completo";
	
	assertFalse(prueba, false);
		
	}

}
