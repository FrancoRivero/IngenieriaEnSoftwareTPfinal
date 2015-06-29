package main.java.headfirst.combined.djview;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = HeartModel.obtenerPaso();
        @SuppressWarnings("unused")
		ControllerInterface model = new HeartController(heartModel);
    }
}
