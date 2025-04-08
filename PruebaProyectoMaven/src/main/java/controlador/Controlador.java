package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import modelo.Jugador;
import vista.Interfaz;

public class Controlador implements ActionListener {

	private Interfaz interfaz;

	public void setInterfaz(Interfaz interfaz) {
		this.interfaz = interfaz;
	}

	private void agregarJugador() {
		try {
			String nombre = interfaz.getTxtNombre().getText();
			int edad = Integer.parseInt(interfaz.getTxtEdad().getText());
			String posicion = (String) interfaz.getComboPosicion().getSelectedItem();
			boolean enForma = interfaz.getCheckEnForma().isSelected();

			Jugador nuevo = new Jugador(nombre, posicion, edad, enForma);
			interfaz.getJugadores().add(nuevo);
			actualizarListado();
			limpiarFormulario();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Edad no válida", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarListado() {
		StringBuilder sb = new StringBuilder("📋 Lista de Jugadores:\n");
		for (Jugador j : interfaz.getJugadores()) {
			sb.append(j).append("\n");
		}
		interfaz.getAreaJugadores().setText(sb.toString());
	}

	private void limpiarFormulario() {
		interfaz.getTxtNombre().setText("");
		interfaz.getTxtEdad().setText("");
		interfaz.getCheckEnForma().setSelected(false);
		interfaz.getComboPosicion().setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == interfaz.getBtnAgregar()) {
			agregarJugador();
		} else if(e.getSource()==interfaz.getComboPosicion()){
			
	            JComboBox<String> comboPosicion = null;
				String pos = (String) comboPosicion.getSelectedItem();
	            JComponent panelFormulario = null;
				switch (pos) {
	                case "Portero" -> panelFormulario.setBackground(Color.CYAN);
	                case "Defensa" -> panelFormulario.setBackground(Color.LIGHT_GRAY);
	                case "Centrocampista" -> panelFormulario.setBackground(Color.ORANGE);
	                case "Delantero" -> panelFormulario.setBackground(Color.PINK);
	                default -> panelFormulario.setBackground(null);
	            
				}}else {
	        	System.out.println("Jugador está en forma: " + ItemEvent.SELECTED);
	        }
			
		}

	
}
