package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Supermercado.SuperController;
import Supermercado.SuperModel;
import Supermercado.SuperModelInterface;

public class Test4 {
	
	SuperController s;
	@Test
	public void test() {
		SuperModel m1 = new SuperModel();
		s= new SuperController(m1);

	    String prueba = "Productos pagados de mas";
		s.cargarACarrito("Azucar");
		s.cargarACarrito("Azucar");
		s.cargarACarrito("Azucar");
		s.cargarACarrito("Azucar");
		s.pagar();
		s.pagar();
		s.pagar();
		s.pagar();
		s.pagar();
		
		assertFalse(prueba,false);
		
	}

}
