package main;

import vista.Interfaz;
import controlador.Controlador;

public class Aplicacion {

	public static void main(String[] args) {
		Controlador controlador= new Controlador();
		Interfaz interfaz= new Interfaz(controlador);
		controlador.setInterfaz(interfaz);
		System.Out.Println("Hola desde Github");

	}

}
