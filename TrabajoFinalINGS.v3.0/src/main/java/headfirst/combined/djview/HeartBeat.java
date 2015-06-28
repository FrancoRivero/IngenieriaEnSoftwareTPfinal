package main.java.headfirst.combined.djview;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HeartBeat extends DJView implements PasoObserver {

	HeartModel m;
	JLabel pasos;
	
	public HeartBeat(ControllerInterface controller, BeatModelInterface model,HeartModel m) {
		super(controller, model);
		// TODO Auto-generated constructor stub
		this.m = m;
		m.registerObserver((PasoObserver)this);
	}
//reestruc
	@Override
	public void updatePaso() {
		// TODO Auto-generated method stub
        pasos.setText("Numero de Instancias: "+m.obtenerNumPaso());
	}
    public void createView()
    {
    	super.createView();
    	pasos = new JLabel("Numero de Instancias: "+ m.obtenerNumPaso(),SwingConstants.CENTER);
    	bpmPanel.add(pasos);
    }
}
