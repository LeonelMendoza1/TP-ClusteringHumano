package ClusteringHumano;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class InterfazDeComponentes {

	private JFrame frame;
	private JTable table_1;
	private JTable table_2;
	private DefaultTableModel model_1 = new DefaultTableModel();
	private DefaultTableModel model_2 = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDeComponentes window = new InterfazDeComponentes();
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
	public InterfazDeComponentes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 108, 210, 198);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		model_1.addColumn("Componente 1");
		table_1.setModel(model_1);
		scrollPane.setViewportView(table_1);
		JTableHeader titulos_1 = table_1.getTableHeader();
		titulos_1.setBackground(Color.BLACK);
		titulos_1.setForeground(Color.GREEN);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(374, 105, 210, 201);
		frame.getContentPane().add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		model_2.addColumn("Componente 2");
		table_2.setModel(model_2);
		JTableHeader titulos_2 = table_2.getTableHeader();
		titulos_2.setBackground(Color.GREEN);
		titulos_2.setForeground(Color.BLACK);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnCerrar.setBounds(277, 375, 110, 37);
		frame.getContentPane().add(btnCerrar);
		
	}
	
	// Seteamos la visibilidad
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	// Agregamos personas a la componente conexa 1
	public void agregarPersonasComp1(ArrayList<Persona> lista, Set<Integer> lista1) {
		model_1.setRowCount(0);

		for (Integer i : lista1) {
			
			Object[] fila = {
					 lista.get(i).getNombre() ,
				};
			model_1.addRow(fila);;
		}
	}
	
	// Agregamos personas a la componente conexa 2
	public void agregarPersonasComp2(ArrayList<Persona> lista, Set<Integer> lista2) {
		model_2.setRowCount(0);

		for (Integer i : lista2) {
			
			Object[] fila = {
					 lista.get(i).getNombre() ,
				};
			model_2.addRow(fila);;
		}
	}

}
