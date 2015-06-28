package main.java.headfirst.combined.djview;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = HeartModel.obtenerPaso();
        ControllerInterface model = new HeartController(heartModel);
    }
}
