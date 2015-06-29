package testing;

import static org.junit.Assert.*;
import main.java.headfirst.combined.djview.HeartModel;

import org.junit.Test;

public class Test1 {
	
	HeartModel m;

	@Test
	public void test() {
		m = HeartModel.obtenerPaso();
		boolean prueba = false;
		prueba = (m==HeartModel.obtenerPaso());
		assertEquals(prueba, true);
	}
}
