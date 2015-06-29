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
	    BeatModelInterface model;
	    
	public MultiView(ControllerInterface controller, BeatModelInterface sModel2) {
		super(controller, sModel2);
		model = sModel2;
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
    		SAdapter = sModel2;	
    		SModel = ((SuperAdapter)SAdapter).getModel();
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
					int bpm = Integer.parseInt(bpmTextField.getText());
		        	controller.setBPM(bpm);
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
					try {
						setModelHeart();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setControllerHeart();
				}
				else if(comboBox.getSelectedIndex() == 2){
					try {
						setSuper();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
			if(BModel.equals(BModel))
			{
				BModel = new BeatModel();
				BModel.initialize();
				BModel.off();
			}else{
				BModel.registerObserver((BeatObserver)this);
				BModel.registerObserver((BPMObserver)this);
				model = BModel;
			}
				if(HModel.equals(HModel)){
				HModel.removeObserver((BeatObserver)this);
				HModel.removeObserver((BPMObserver)this);
			}
			if(SModel.equals(SModel)){
				SModel.removeObserver((BeatObserver)this);
				SModel.removeObserver((BPMObserver)this);
			}updateBPM();
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
		public void setModelHeart() throws Exception{
			if(!HModel.equals(HModel))
			{
				HModel = HeartModel.obtenerPaso();
				HAdapter = new HeartAdapter(HModel);
			}
			else
				throw new Exception();
				HModel.registerObserver((BeatObserver)this);
				HModel.registerObserver((BPMObserver)this);
				model = HAdapter;
			
			    if(	BModel.equals(BModel)){
				BModel.removeObserver((BeatObserver)this);
				BModel.removeObserver((BPMObserver)this);}
			    else
			    	throw new Exception();
			if(SModel.equals(SModel)){
				SModel.removeObserver((BeatObserver)this);
				SModel.removeObserver((BPMObserver)this);
			}
			else
			throw new Exception();
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
	public void setSuper() throws Exception{
				if(!SModel.equals(SModel)){
				SModel = new SuperModel();
				SAdapter = new SuperAdapter(SModel);
			}
				else
					throw new Exception();
				SModel.registerObserver((BeatObserver)this);
				SModel.registerObserver((BPMObserver)this);
				model = SAdapter;
			
				if(BModel.equals(BModel)){
				BModel.removeObserver((BeatObserver)this);
				BModel.removeObserver((BPMObserver)this);
			}else
				throw new Exception();
			if(HModel.equals(HModel)){
				HModel.removeObserver((BeatObserver)this);
				HModel.removeObserver((BPMObserver)this);
			}else
				throw new Exception();
			updateBPM();
		}
}
	