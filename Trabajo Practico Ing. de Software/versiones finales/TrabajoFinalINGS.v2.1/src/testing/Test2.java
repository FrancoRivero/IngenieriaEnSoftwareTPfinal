package testing;

import static org.junit.Assert.*;
import main.java.headfirst.combined.djview.HeartModel;

import org.junit.Test;

public class Test2 {

	HeartModel m;
	
	@Test
	public void test() {
		
		m.obtenerPaso();
		String prueba = "No se puede crear mas de una instancia...";
		assertFalse(prueba, false);
	}
}
