package main.java.headfirst.combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new HeartBeat(this, new HeartAdapter(model),(HeartModel)model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
   
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		model = HeartModel.obtenerPaso();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}





