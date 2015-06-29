package Supermercado;

import main.java.headfirst.combined.djview.BPMObserver;
import main.java.headfirst.combined.djview.BeatModelInterface;
import main.java.headfirst.combined.djview.BeatObserver;

public class Adaptador implements BeatModelInterface {
	private SuperModelInterface market;
	
	public Adaptador(SuperModelInterface market){
		this.market = market;
	}

	@Override
	public void initialize() {

		
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

	@Override
	public void registerObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		
	}
	

}
