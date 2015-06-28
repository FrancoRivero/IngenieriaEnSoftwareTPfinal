package Supermercado;

import main.java.headfirst.combined.djview.BPMObserver;
import main.java.headfirst.combined.djview.BeatModelInterface;
import main.java.headfirst.combined.djview.BeatObserver;

public class SuperAdapter  implements BeatModelInterface {

	SuperModelInterface superModel;
	public SuperAdapter(SuperModelInterface sModel) {
		// TODO Auto-generated constructor stub
        superModel = sModel;		
	}
	public SuperModelInterface getModel(){
		return superModel;
	}
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBPM() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void registerObserver(BeatObserver o) {
		superModel.registerObserver(o);
	}
    
	public void removeObserver(BeatObserver o) {
		superModel.removeObserver(o);
	}
     
	public void registerObserver(BPMObserver o) {
		superModel.registerObserver(o);
	}
  
	public void removeObserver(BPMObserver o) {
		superModel.removeObserver(o);
	}
	
}
