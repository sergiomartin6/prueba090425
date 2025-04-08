package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import modelo.Jugador;
import controlador.Controlador;

public class Interfaz extends JFrame{

	private Controlador controlador;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JComboBox<String> comboPosicion;
	private JCheckBox checkEnForma;
	private JButton btnAgregar;
	private JTextArea areaJugadores;
	private JLabel lblEstadoNombre;
	private JPanel panelCampo;
	private List<Jugador> jugadores = new ArrayList<>();
	
	
	
	

	public Controlador getControlador() {
		return controlador;
	}





	public JTextField getTxtNombre() {
		return txtNombre;
	}





	public JTextField getTxtEdad() {
		return txtEdad;
	}





	public JComboBox<String> getComboPosicion() {
		return comboPosicion;
	}





	public JCheckBox getCheckEnForma() {
		return checkEnForma;
	}





	public JButton getBtnAgregar() {
		return btnAgregar;
	}





	public JTextArea getAreaJugadores() {
		return areaJugadores;
	}





	public JLabel getLblEstadoNombre() {
		return lblEstadoNombre;
	}





	public JPanel getPanelCampo() {
		return panelCampo;
	}





	public List<Jugador> getJugadores() {
		return jugadores;
	}





	public Interfaz(Controlador controlador) {

		this.controlador = controlador;
		
		 JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
	        panelFormulario.setBorder(BorderFactory.createTitledBorder("Nuevo Jugador"));

	        txtNombre = new JTextField();
	        txtEdad = new JTextField();
	        comboPosicion = new JComboBox<>(new String[]{"Portero", "Defensa", "Centrocampista", "Delantero"});
	        checkEnForma = new JCheckBox("Está en forma");
	        btnAgregar = new JButton("Agregar jugador");
	        lblEstadoNombre = new JLabel("Longitud nombre: 0");

	        panelFormulario.add(new JLabel("Nombre:"));
	        panelFormulario.add(txtNombre);
	        panelFormulario.add(new JLabel("Edad:"));
	        panelFormulario.add(txtEdad);
	        panelFormulario.add(new JLabel("Posición:"));
	        panelFormulario.add(comboPosicion);
	        panelFormulario.add(new JLabel(""));
	        panelFormulario.add(checkEnForma);
	        panelFormulario.add(lblEstadoNombre);
	        panelFormulario.add(btnAgregar);

	        add(panelFormulario, BorderLayout.NORTH);

	        // Área de resultados
	        areaJugadores = new JTextArea();
	        areaJugadores.setEditable(false);
	        add(new JScrollPane(areaJugadores), BorderLayout.CENTER);

	        // Panel de juego/campo con ratón
	        panelCampo = new JPanel();
	        panelCampo.setPreferredSize(new Dimension(200, 100));
	        panelCampo.setBackground(Color.GREEN);
	        panelCampo.setToolTipText("Haz clic en el campo para registrar entrada");
	        add(panelCampo, BorderLayout.SOUTH);

	        // EVENTOS

	        // Botón
	        btnAgregar.addActionListener(controlador);

	        // Campo de texto: mostrar longitud del nombre
	        txtNombre.addKeyListener(new KeyAdapter() {
	            public void keyReleased(KeyEvent e) {
	                lblEstadoNombre.setText("Longitud nombre: " + txtNombre.getText().length());
	            }
	        });

	        // Combo: cambia color según posición
	        comboPosicion.addActionListener(controlador);

	        // Check: mostrar estado en consola
	        checkEnForma.addItemListener((ItemListener) controlador);

	        // Mouse: clic en el campo
	        panelCampo.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                JOptionPane.showMessageDialog(Interfaz.this,
	                        "Entrada registrada en el campo (x=" + e.getX() + ", y=" + e.getY() + ")",
	                        "Campo deportivo", JOptionPane.INFORMATION_MESSAGE);
	            }
	        });

	        // Ventana: advertencia al cerrar
	        addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                System.out.println("Aplicación cerrándose. Jugadores guardados: " + jugadores.size());
	            }
	        });

	        setVisible(true);

	}

}
