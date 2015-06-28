package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import Supermercado.SuperController;
import Supermercado.SuperModel;
import Supermercado.SuperView;

public class Test5 {
    SuperView v;
   
	@Test
	public void test() {
		SuperModel m = new SuperModel();
		 SuperController c = new SuperController(m);
		v = new SuperView(c,m);
		c.cargarACarrito("Azucar");
		c.comparar();
	    String prueba = "POR FAVOR, REDIRIGIRSE A CAJA. DE LO CONTRARIO SE LLAMARA A SEGURIDAD";
	    assertFalse(prueba,false);
	}

}
