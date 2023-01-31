package ClusteringHumano;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class Interfaz {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textDeportes;
	private JTextField textEspec;
	private JTextField textMusica;
	private JTextField textCiencia;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}
	
	// Para verificar que la entrada sea un numero
	public boolean esNumero (String numero){
		return numero.matches("[0-9]*");
	}
	
	// Para verificar que los valores esten entre 1 y 5
	public boolean valoresCorrectos(int deportes, int musica, int espectaculo, int ciencia){
		if (deportes < 1 || deportes >5 ||
			musica < 1 || musica > 5 ||
			espectaculo < 1 || espectaculo > 5 ||
			ciencia < 1 || ciencia > 5) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// Para verificar si hay vacios
	private boolean algunoVacio() {
		if (textNombre.getText().equals("") ||
			textDeportes.getText().equals("") ||
			textMusica.getText().equals("") ||
			textEspec.getText().equals("") ||
			textCiencia.getText().equals("")) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	// Para volver todo a vacios
	private void setearText() {
		textNombre.setText("");
		textDeportes.setText("");
		textMusica.setText("");
		textEspec.setText("");
		textCiencia.setText("");
	}
	
	private boolean masDeUnaPersona () {
		if (listaPersonas.size() <= 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creacion de los Label
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 50, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblDeportes = new JLabel("Deportes");
		lblDeportes.setBounds(28, 80, 57, 14);
		frame.getContentPane().add(lblDeportes);
		
		JLabel lblEspectaculos = new JLabel("Musica");
		lblEspectaculos.setBounds(28, 110, 46, 14);
		frame.getContentPane().add(lblEspectaculos);
		
		JLabel lblEspectaculos_1 = new JLabel("Espectaculos");
		lblEspectaculos_1.setBounds(28, 140, 81, 14);
		frame.getContentPane().add(lblEspectaculos_1);
		
		JLabel lblCiencia = new JLabel("Ciencia");
		lblCiencia.setBounds(28, 170, 46, 14);
		frame.getContentPane().add(lblCiencia);
		
		//Creacion de los JText
		textNombre = new JTextField();
		textNombre.setBounds(119, 47, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDeportes = new JTextField();
		textDeportes.setBounds(119, 77, 46, 20);
		frame.getContentPane().add(textDeportes);
		textDeportes.setColumns(10);
		
		textEspec = new JTextField();
		textEspec.setBounds(119, 137, 46, 20);
		frame.getContentPane().add(textEspec);
		textEspec.setColumns(10);
		
		textMusica = new JTextField();
		textMusica.setBounds(119, 107, 46, 20);
		frame.getContentPane().add(textMusica);
		textMusica.setColumns(10);
		
		textCiencia = new JTextField();
		textCiencia.setBounds(119, 167, 46, 20);
		frame.getContentPane().add(textCiencia);
		textCiencia.setColumns(10);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 243, 535, 242);
		frame.getContentPane().add(scrollPane);
		scrollPane.setBackground(Color.RED);
		
		table = new JTable();
		model.addColumn("Nombre");
		model.addColumn("Deportes");
		model.addColumn("Musica");
		model.addColumn("Espectaculo");
		model.addColumn("Ciencia");
		table.setModel(model);
		
		JTableHeader titulos = table.getTableHeader();
		titulos.setBackground(Color.GREEN);
		scrollPane.setViewportView(table);
		
		
		JButton btnAgrePersona = new JButton("Agregar Persona");
		btnAgrePersona.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Me fijo si hsy datos vacios
				if (algunoVacio()){
					JOptionPane.showMessageDialog(null, "�No se admiten lugares vacios!");
					return;
				}
				// Me fijo que se hayan pasado n�meros
				if (!esNumero(textDeportes.getText()) ||	
					!esNumero(textMusica.getText()) ||
					!esNumero(textEspec.getText()) ||
					!esNumero(textCiencia.getText())) {		
					JOptionPane.showMessageDialog(null, "�Solo puede ingresar numeros!");
					return;
				}
				
				// Asignamos los valores para la persona
				int deportes = Integer.parseInt(textDeportes.getText());
				int musica = Integer.parseInt(textMusica.getText());
				int espectaculos = Integer.parseInt(textEspec.getText());
				int ciencia = Integer.parseInt(textCiencia.getText());
				
				// Comprobamos que los valores sean validos
				if (!valoresCorrectos(deportes, musica, espectaculos, ciencia)) {
					JOptionPane.showMessageDialog(null, "�Los valores deben estar entre 0 y 5!");
					return;
				}
				
				// Se agrega la persona
				String nombre = textNombre.getText();
				Persona nuevo = new Persona(nombre,deportes,musica,espectaculos,ciencia);	
				listaPersonas.add(nuevo);
				AgregarPersona();
				setearText();
			}
			
			//agrego las personas a la tabla
			private void AgregarPersona() {
				model.setRowCount(0);
				for (int i = 0; i < listaPersonas.size(); i++) {
					Object[] fila = {
						 listaPersonas.get(i).getNombre(),
						 String.valueOf(listaPersonas.get(i).getDeportes()),
						 String.valueOf(listaPersonas.get(i).getMusica()),
						 String.valueOf(listaPersonas.get(i).getEspectaculo()),
						 String.valueOf(listaPersonas.get(i).getCiencia()),
					};
					model.addRow(fila);
				}
			}
		});
		
		btnAgrePersona.setBounds(337, 100, 146, 43);
		frame.getContentPane().add(btnAgrePersona);
		
		JLabel lblNewLabel = new JLabel("Clustering Humano");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(280, 22, 285, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnArbolMinimo = new JButton("Generar Componentes");
		btnArbolMinimo.setBackground(Color.BLACK);
		btnArbolMinimo.setForeground(Color.GREEN);
		btnArbolMinimo.addActionListener(new ActionListener() {
			@Override
			// Para abrir el segundo frame
			public void actionPerformed(ActionEvent e) {
				
				//Comprobamos que la lista de personas no este vacia
				if (listaPersonas.isEmpty()) {
					JOptionPane.showMessageDialog(null, "�La lista de personas esta vacia!");
					return;
				}
				
				//Comprobamos que se hayan ingresado mas de una persona
				if (!masDeUnaPersona()) {
					JOptionPane.showMessageDialog(null, "�Debe haber mas de 1 persona en la lista!");
					return;
				}
				
				//Creamos el Grafo
				Grafo grafo = new Grafo(listaPersonas.size());
				for (int i = 0; i < listaPersonas.size() ; i++) {
					for (int j = 0; j < listaPersonas.size(); j++) {
						if ( i != j ) {
							grafo.agregarArista(i, j, listaPersonas.get(i).similaridad(listaPersonas.get(j)));
						}	
					}
				}
				
				// Transformamos el grafo con PRIM
				grafo = Prim.algoritmoPrim(grafo);
				
				// Elimino la arista de mayor peso y nos devuelve la posiciones para hacer BFS
				int[] aristaMayor = grafo.aristaMayor();
				
				// Hago BFS  para conseguir las componentes
				Set<Integer> lista1 = new HashSet<Integer>();
				Set<Integer> lista2 = new HashSet<Integer>();
				lista1 = BFS.alcanzables(grafo, aristaMayor[0]);
				lista2 = BFS.alcanzables(grafo, aristaMayor[1]);
				
				// Las Mostramos en otro Frame
				InterfazDeComponentes componentes = new InterfazDeComponentes();
				componentes.agregarPersonasComp1(listaPersonas, lista1);
				componentes.agregarPersonasComp2(listaPersonas, lista2);
				componentes.setVisible(true);
			}
		});
		
		btnArbolMinimo.setBounds(500, 500, 165, 55);
		frame.getContentPane().add(btnArbolMinimo);
		
	}
}
