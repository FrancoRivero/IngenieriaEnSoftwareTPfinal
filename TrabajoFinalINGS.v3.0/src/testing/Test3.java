package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Supermercado.Carrito;
import Supermercado.Productos;

public class Test3 {
	
	Carrito carr;
	Productos a, b, c, d, e, f, g, h, i, j, k;

	@Test
	public void test() {
		
		carr = new Carrito();
		
		a = new Productos("Azucar");
		b = new Productos("Azucar");
		c = new Productos("Azucar");
		d = new Productos("Azucar");
		e = new Productos("Azucar");
		f = new Productos("Azucar");
		g = new Productos("Azucar");
		h = new Productos("Azucar");
		i = new Productos("Azucar");
		j = new Productos("Azucar");
		k = new Productos("Azucar");
		
		String prueba = "CARRITO LLENO";
		
		assertFalse(prueba, false);
		
	}

}
