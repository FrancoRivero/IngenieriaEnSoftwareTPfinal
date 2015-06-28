package Supermercado;


public class TestDriveMultiView {


	public static void main(String[] args) {
	     SuperModelInterface SModel = new SuperModel();
		 new SuperController( SModel,"multiple");
	}



}
