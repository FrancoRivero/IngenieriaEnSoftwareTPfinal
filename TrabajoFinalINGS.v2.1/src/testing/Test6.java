package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Supermercado.SuperController;
import Supermercado.SuperModel;
import Supermercado.SuperView;

public class Test6 {
    SuperView v;
   
	@Test
	public void test() {
		SuperModel m = new SuperModel();
		 SuperController c = new SuperController(m);
		v = new SuperView(c,m);
		c.cargarACarrito("Azucar");
		c.pagar();
		c.comparar();
	    String prueba = "Gracias por su compra, lo esperamos pronto..";
	    assertFalse(prueba,false);
	}

}
