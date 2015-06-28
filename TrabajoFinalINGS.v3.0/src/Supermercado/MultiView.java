package Supermercado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import main.java.headfirst.combined.djview.BPMObserver;
import main.java.headfirst.combined.djview.BeatController;
import main.java.headfirst.combined.djview.BeatModel;
import main.java.headfirst.combined.djview.BeatModelInterface;
import main.java.headfirst.combined.djview.BeatObserver;
import main.java.headfirst.combined.djview.ControllerInterface;
import main.java.headfirst.combined.djview.DJView;
import main.java.headfirst.combined.djview.HeartAdapter;
import main.java.headfirst.combined.djview.HeartController;
import main.java.headfirst.combined.djview.HeartModel;
import main.java.headfirst.combined.djview.HeartModelInterface;


public class MultiView extends DJView{

	  JComboBox<String> comboBox;
	    BeatModelInterface BModel,SAdapter,HAdapter;
	    SuperModelInterface SModel;
	    HeartModelInterface HModel;
	    ControllerInterface controller;
	    
	    
	public MultiView(ControllerInterface controller, BeatModelInterface sModel2) {
		super(controller, sModel2);
		this.model = sModel2;
		this.controller = controller;
		
		// TODO Auto-generated constructor stub
		if(sModel2 instanceof BeatModel){
    		BModel = sModel2;
    	}
    	else if(sModel2 instanceof HeartAdapter){
    		HAdapter = sModel2;
    		HModel = ((HeartAdapter)HAdapter).getModel();
    	}
    	else if(sModel2 instanceof SuperAdapter){
    		SAdapter = sModel2;	SModel = ((SuperAdapter)SAdapter).getModel();
    	}
	}
		public void createView() {
	    	super.createView();
	        comboBox = new JComboBox<String>(new String[] {"BeatModel", "HeartModel", "SuperModel"});
			comboBox.addActionListener(this);
			bpmPanel.add(comboBox, BorderLayout.CENTER);
			viewFrame.setSize(150, 80);
		}
		public void createControls(){
	    	super.createControls();
	    	if(this.model == BModel)
	    		comboBox.setSelectedIndex(0);
	    	else if(this.model == HAdapter)
	    		comboBox.setSelectedIndex(1);
	    	else if(this.model == SAdapter)
	    		comboBox.setSelectedIndex(2);
	    
	}
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == setBPMButton) {
				try{
					int bpm = Integer.parseInt(bpmTextField.getText());
		        	controller.setBPM(bpm);
				}catch(NumberFormatException e){}
			} else if (event.getSource() == increaseBPMButton) {
				controller.increaseBPM();
			} else if (event.getSource() == decreaseBPMButton) {
				controller.decreaseBPM();
			}
			else if(event.getSource() == comboBox ){
				if(comboBox.getSelectedIndex() == 0){
					setModelBeat();
					setControllerBeat();
				}
				else if(comboBox.getSelectedIndex() == 1){
					setModelHeart();
					setControllerHeart();
				}
				else if(comboBox.getSelectedIndex() == 2){
					setSuper();
					setControllerSuper();
				}
			}
		}
		public void updateBPM() {
			if (model != null) {
				int bpm = ((BeatModelInterface)(model)).getBPM();
				if (bpm == 0) {
					if (bpmOutputLabel != null) {
	        			bpmOutputLabel.setText("offline");
					}
				} else {
					if (bpmOutputLabel != null) {
	        			bpmOutputLabel.setText("Current BPM: " + bpm);
					}
				}
			}
			
		}
		public void updateBeat() {
			if (beatBar != null) {
				 beatBar.setValue(100);
			}
		}
		public void setModelBeat(){
			try{
				BModel.equals(BModel);
			}catch(NullPointerException e){
				BModel = new BeatModel();
				BModel.initialize();
				BModel.off();
			}finally{
				BModel.registerObserver((BeatObserver)this);
				BModel.registerObserver((BPMObserver)this);
				model = BModel;
			}
			try{
				HModel.equals(HModel);
				HModel.removeObserver((BeatObserver)this);
				HModel.removeObserver((BPMObserver)this);
			}catch(NullPointerException e){}
			try{
				SModel.equals(SModel);
				SModel.removeObserver((BeatObserver)this);
				SModel.removeObserver((BPMObserver)this);
			}catch(NullPointerException e){}
			updateBPM();
		}
		
		public void setControllerBeat(){
			this.controller = new BeatController(BModel,this);
			if(BModel.getBPM() == 0){
				this.disableStopMenuItem();
				this.enableStartMenuItem();
			}
			else{	
				this.enableStopMenuItem();
				this.disableStartMenuItem();
			}
		}
		
		public void setControllerHeart(){
			this.controller = new HeartController(HModel,(DJView) this);
		}
		public void setModelHeart(){
			try{
				HModel.equals(HModel);
			}catch(NullPointerException e){
				HModel = HeartModel.obtenerPaso();
				HAdapter = new HeartAdapter(HModel);
			}finally{
				HModel.registerObserver((BeatObserver)this);
				HModel.registerObserver((BPMObserver)this);
				model = HAdapter;
			}
			try{
				BModel.equals(BModel);
				BModel.removeObserver((BeatObserver)this);
				BModel.removeObserver((BPMObserver)this);
			}catch(NullPointerException e){}
			try{
				SModel.equals(SModel);
				SModel.removeObserver((BeatObserver)this);
				SModel.removeObserver((BPMObserver)this);
			}catch(NullPointerException e){}
			updateBPM();
		}
		public void setControllerSuper(){
			this.controller = new SuperController(SModel, this);
			if( SAdapter.getBPM() == 0){
				this.disableStopMenuItem();
				this.enableStartMenuItem();
			}else{
				this.enableStopMenuItem();
				this.disableStartMenuItem();
			}
		}
	public void setSuper(){
			try{
				SModel.equals(SModel);
			}catch(NullPointerException e){
				SModel = new SuperModel();
				SAdapter = new SuperAdapter(SModel);
			}finally{
				SModel.registerObserver((BeatObserver)this);
				SModel.registerObserver((BPMObserver)this);
				model = SAdapter;
			}
			try{
				BModel.equals(BModel);
				BModel.removeObserver((BeatObserver)this);
				BModel.removeObserver((BPMObserver)this);
			}catch(NullPointerException e){}
			try{
				HModel.equals(HModel);
				HModel.removeObserver((BeatObserver)this);
				HModel.removeObserver((BPMObserver)this);
			}catch(NullPointerException e){}
			updateBPM();
		}
}
	

