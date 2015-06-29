package Supermercado;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.*;

import  sun.audio.*; 

import  java.io.*;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.headfirst.combined.djview.BPMObserver;
import main.java.headfirst.combined.djview.BeatBar;
import main.java.headfirst.combined.djview.BeatModelInterface;
import main.java.headfirst.combined.djview.BeatObserver;
import main.java.headfirst.combined.djview.ControllerInterface;

public class SuperView implements ActionListener,  BeatObserver, BPMObserver{
	
	
	private SuperModelInterface modelo;
	private SuperController controlador;

	JFrame ventana;
	
	JButton azucar;
	JButton aceite; 
	JButton yerba;
	JButton jugo;
	JButton arroz;
	JButton sal;
	JButton leche;
	JButton chinchulin;
	JButton chimi;
	JButton mayonesa;
	JButton carrito;
	JButton salida;
	JButton caja;
	JButton incrementar;
	JButton decrementar;
	
	JLabel prodencarrito;
	JLabel prodpagados;
	JLabel barras;
	JLabel maxcarr;
	
	JProgressBar barracaja;
	JProgressBar tamanocarr;
	
	
	public SuperView(SuperController controller, SuperModelInterface model){
		controlador = controller;
		modelo = model;
		modelo.registerObserver((BPMObserver)this);
		
	}
	
	
	
public void createView(){
		
		ventana = new JFrame("Supermercados BuenasTardes");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.getContentPane().setLayout(null);
		
		azucar = new JButton("Azucar");
		azucar.addActionListener(this);
		azucar.setBounds(390, 30, 95, 40);
		
		aceite = new JButton("Aceite");
		aceite.addActionListener(this);
		aceite.setBounds(490, 30, 95, 40);
		
		yerba = new JButton("Yerba");
		yerba.addActionListener(this);
		yerba.setBounds(390, 80, 95, 40);
		
		jugo = new JButton("Jugo");
		jugo.addActionListener(this);
		jugo.setBounds(490, 80, 95, 40);
		
		arroz = new JButton("Arroz");
		arroz.addActionListener(this);
		arroz.setBounds(390, 130, 95, 40);
		
		sal = new JButton("Sal");
		sal.addActionListener(this);
		sal.setBounds(490, 130, 95, 40);
		
		leche = new JButton("Leche");
		leche.addActionListener(this);
		leche.setBounds(390, 180, 95, 40);
		
		chinchulin = new JButton("Chinchulin");
		chinchulin.addActionListener(this);
		chinchulin.setBounds(490, 180, 95, 40);
		
		chimi = new JButton("Chimi");
		chimi.addActionListener(this);
		chimi.setBounds(390, 230, 95, 40);
		
		mayonesa = new JButton("Mayonesa");
		mayonesa.addActionListener(this);
		mayonesa.setBounds(490, 230, 95, 40);
		
		incrementar = new JButton(">>");
		incrementar.addActionListener(this);
		incrementar.setBounds(460, 310, 50, 18);
		
		decrementar = new JButton("<<");
		decrementar.addActionListener(this);
		decrementar.setBounds(400, 310, 50, 18);
		
		carrito = new JButton(new ImageIcon("carrito.png"));
		carrito.addActionListener(this);
		carrito.setBounds(290, 240, 55, 55);
		carrito.setBorderPainted(false);
		carrito.setContentAreaFilled(false);
		carrito.setRolloverIcon(new ImageIcon("carrito2.png"));
		carrito.repaint();
		
		salida = new JButton(new ImageIcon("salida.png"));
		salida.addActionListener(this);
		salida.setBounds(10, 270, 70, 40);
		salida.setBorderPainted(false);
		salida.setContentAreaFilled(false);
		salida.setRolloverIcon(new ImageIcon("salida2.png"));
		
		caja = new JButton(new ImageIcon("caja.png"));
		caja.addActionListener(this);
		caja.setBounds(210, 30, 90, 90);
		caja.setBorderPainted(false);
		caja.setContentAreaFilled(false);
		caja.setRolloverIcon(new ImageIcon("caja2.png"));
	
		
		prodencarrito = new JLabel("Productos en carrito: " +  modelo.CantidadDeProductos(), SwingConstants.RIGHT);
		prodencarrito.setBounds(215, 285, 167, 30);
		prodencarrito.repaint();
		
		prodpagados = new JLabel("Productos pagados: " + controlador.pagados(), SwingConstants.RIGHT);
		prodpagados.setBounds(150, 110, 167, 30);
		prodencarrito.repaint();
		
		maxcarr = new JLabel("Capacidad de carrito: " +  modelo.getMax(), SwingConstants.RIGHT);
		maxcarr.setBounds(215, 305, 167, 30);
		maxcarr.repaint();
		
		barracaja = new JProgressBar();
		barracaja.setOrientation(SwingConstants.VERTICAL);
		barracaja.setBounds(320, 38, 12, 76);
		barracaja.setMaximum(100);
		
		
		tamanocarr = new JProgressBar();
		tamanocarr.setOrientation(SwingConstants.HORIZONTAL);
		tamanocarr.setBounds(400, 290, 110, 12);
		tamanocarr.setValue(modelo.getMax());
		tamanocarr.setMaximum(40);
		
		barras = new JLabel(new ImageIcon("barras.png")); 
		barras.setBounds(25, 65, 100, 200);
		
		ventana.getContentPane().add(azucar);
		ventana.getContentPane().add(aceite);
		ventana.getContentPane().add(yerba);
		ventana.getContentPane().add(jugo);
		ventana.getContentPane().add(arroz);
		ventana.getContentPane().add(sal);
		ventana.getContentPane().add(leche);
		ventana.getContentPane().add(chinchulin);
		ventana.getContentPane().add(chimi);
		ventana.getContentPane().add(mayonesa);
		ventana.getContentPane().add(carrito);
		ventana.getContentPane().add(salida);
		ventana.getContentPane().add(caja);
		ventana.getContentPane().add(prodencarrito);
		ventana.getContentPane().add(prodpagados);
		//ventana.getContentPane().add(barracaja);
		ventana.getContentPane().add(incrementar);
		ventana.getContentPane().add(decrementar);
		ventana.getContentPane().add(tamanocarr);
		ventana.getContentPane().add(maxcarr);
		ventana.add(barras);
		
		ventana.setSize(new Dimension(630,380));
}

public void aviso(boolean a) {
	
	if(a == false){
	JFrame ventana = new JFrame("Sensor anti robo");
	ventana.setVisible(true);
	ventana.setSize(new Dimension(500,150));
	ventana.getContentPane().setLayout(new FlowLayout());
	
	JLabel productos = new JLabel("POR FAVOR, REDIRIGIRSE A CAJA. DE LO CONTRARIO SE LLAMARA A SEGURIDAD");
	ventana.getContentPane().add(productos);
	
	}
	else{
		JFrame ventana = new JFrame("Compra exitosa");
		ventana.setVisible(true);
		ventana.setSize(new Dimension(450,150));
		ventana.getContentPane().setLayout(new FlowLayout());
		
		JLabel productos = new JLabel("Gracias por su compra, lo esperamos pronto..");
		ventana.getContentPane().add(productos);
	}
}

	
public void productosCarrito() {
	
	JFrame ventana = new JFrame("Productos en el carrito");
	ventana.setVisible(true);
	ventana.setSize(new Dimension(630,360));
	ventana.getContentPane().setLayout(new FlowLayout());
	
	JLabel productos = new JLabel(modelo.toString());
	ventana.getContentPane().add(productos);
}


public void actionPerformed(ActionEvent event) {
	
	if (event.getSource() == azucar){
		this.controlador.cargarACarrito("Azucar");
		updateBPM();
	}
	else if (event.getSource() == aceite){
		this.controlador.cargarACarrito("Aceite");
		updateBPM();
	}
	else if (event.getSource() == yerba){
		this.controlador.cargarACarrito("Yerba");
		updateBPM();
	}
	else if (event.getSource() == jugo){
		this.controlador.cargarACarrito("Jugo");
		updateBPM();
	}
	else if (event.getSource() == arroz){
		this.controlador.cargarACarrito("Arroz");
		updateBPM();
	}
	else if (event.getSource() == sal){
		this.controlador.cargarACarrito("Sal");
		updateBPM();
	}
	else if (event.getSource() == leche){
		this.controlador.cargarACarrito("Leche");
		updateBPM();
	}
	else if (event.getSource() == chinchulin){
		this.controlador.cargarACarrito("Chinchulin");
		updateBPM();
	}
	else if (event.getSource() == chimi){
		this.controlador.cargarACarrito("Chimi");
		updateBPM();
	}
	else if (event.getSource() == mayonesa){
		this.controlador.cargarACarrito("Mayonesa");
		updateBPM();
	}
	
	else if (event.getSource() == carrito){
		this.controlador.prodCarr();
	}
	
	else if (event.getSource() == caja) {
		
		this.controlador.pagar();
		updateBPM();
		barracaja.setValue(0);
	}
	
	else if (event.getSource() == salida) {
		this.controlador.comparar();
	}
	
	
	else if (event.getSource() == incrementar){
		controlador.increaseBPM();
		updateBPM();
	}
	else if (event.getSource() == decrementar){
		controlador.decreaseBPM();
		updateBPM();
	}
}


	@Override
	public void updateBPM() {
		// TODO Auto-generated method stub
		prodencarrito.setText("Productos en carrito: " +  modelo.CantidadDeProductos());
		prodpagados.setText("Productos pagados: " + controlador.pagados());
		maxcarr.setText("Capacidad de carrito: " +  modelo.getMax());
		tamanocarr.setValue(modelo.getMax());
	}


	@Override
	public void updateBeat() {
		// TODO Auto-generated method stub
		
	}
}
