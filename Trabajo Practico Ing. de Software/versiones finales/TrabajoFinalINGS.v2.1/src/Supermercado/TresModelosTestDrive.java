package Supermercado;

import main.java.headfirst.combined.djview.BeatController;
import main.java.headfirst.combined.djview.BeatModel;
import main.java.headfirst.combined.djview.HeartController;
import main.java.headfirst.combined.djview.HeartModel;


public class TresModelosTestDrive {
	public static void main(String args[]) {
		SuperModel Super = new SuperModel();
		HeartModel corazon = HeartModel.obtenerPaso();
		BeatModel beat = new BeatModel();
		
		SuperController sc = new SuperController(Super);
		HeartController hc = new HeartController(corazon);
		BeatController bc = new BeatController(beat);
	}

}