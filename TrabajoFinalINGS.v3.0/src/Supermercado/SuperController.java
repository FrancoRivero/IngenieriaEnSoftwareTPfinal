package Supermercado;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import main.java.headfirst.combined.djview.ControllerInterface;
import main.java.headfirst.combined.djview.DJView;

	

public class SuperController implements ControllerInterface{
	SuperModelInterface model;
	SuperView view;
	DJView djView;
	private int pago;
	
	public SuperController(SuperModelInterface model) {
		this.model = model;
		view = new SuperView(this, model);
        view.createView();
        pago=0;
	}
	public SuperController(SuperModelInterface model,String miVentana){
		this.model=model;
		if(miVentana.toLowerCase() == "dj"){
	        djView = new DJView(this, new SuperAdapter(model));
	        djView.createView();
	        djView.createControls();
			djView.disableStopMenuItem();
			djView.enableStartMenuItem();
		}else if(miVentana.toLowerCase() == "multiple"){
			djView = new MultiView(this, new SuperAdapter(model));
		    djView.createView();
			djView.createControls();

		}else{
			view = new SuperView(this,model);
	        view.createView();
		}
	}
  public SuperController(SuperModelInterface model,DJView view)
  {
	  this.model = (SuperModelInterface) model;
	  djView = view;
	  pago=0;
  }
  
public void prodCarr(){
		view.productosCarrito();
	}
  
  public void cargarACarrito(String a){
	  Productos p = new Productos(a);
	  model.cargarProducto(p);
	}
  
  public void pagar(){
	  if(pago < model.CantidadDeProductos()){
		  pago++;
		  
			try {
				Clip sonido = AudioSystem.getClip();
				File a = new File("sound.wav");
				sonido.open(AudioSystem.getAudioInputStream(a));
				sonido.start();
				Thread.sleep(300);
				//sonido.close();
			}
			catch (Exception tipoerror) {
				System.out.println("" + tipoerror);
			}	
	  }
	  
	  else 
		  System.out.println("Productos pagados de mas");
  }
  
  public int pagados(){
	  return pago;
  }
  
  public void comparar(){
	  int n = model.CantidadDeProductos();
	  
	  if(n == pago)
		  view.aviso(true);
	  else
		  view.aviso(false);
  }
  

 
    

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub
		model.modificarCarrito('+');
	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		model.modificarCarrito('-');
	}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		
	}
	

}
