package view;

import javax.swing.JPanel;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controlador.ControladorEstudiante;
import controlador.ControladorNota;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAlumno extends JPanel {
	private static JList<Estudiante> listaEstSelec;
	private static JList<Estudiante> listaEstNoSelec;
	private static DefaultListModel<Estudiante> modeloListaEstSelec;
	private static DefaultListModel<Estudiante> modeloListaEstNoSelec;
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelAlumno() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 95, 133, 147, 0};
		gridBagLayout.rowHeights = new int[]{14, 281, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Alumno seleccionado");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alumno no no seleccionado");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		
		listaEstSelec = new JList(getDefaultListModelSelec());
		listaEstSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		
		
		
		JScrollPane scrollPane = new JScrollPane(listaEstSelec);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		//		gbl_panel_1.columnWidths = new int[]{0, 0};
		//		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		//		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		//		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				
				JButton btnNewButton = new JButton("<<");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						imprimirTodosSelec();
					}
				});
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton.gridx = 0;
				gbc_btnNewButton.gridy = 0;
				panel_1.add(btnNewButton, gbc_btnNewButton);
				
				JButton btnNewButton_1 = new JButton(">");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						List<Estudiante> l = listaEstSelec.getSelectedValuesList();
						modeloListaEstNoSelec.addAll(l);
						
						for (int i = listaEstSelec.getSelectedIndices().length -1; i >= 0; i--) {
							modeloListaEstSelec.removeElementAt(listaEstSelec.getSelectedIndices()[i]);
							
						}
					}
				});
				GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
				gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton_1.gridx = 0;
				gbc_btnNewButton_1.gridy = 1;
				panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("<");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						List<Estudiante> l = listaEstNoSelec.getSelectedValuesList();
						modeloListaEstSelec.addAll(l);
						
						for (int i = listaEstNoSelec.getSelectedIndices().length -1; i >= 0; i--) {
							modeloListaEstNoSelec.removeElementAt(listaEstNoSelec.getSelectedIndices()[i]);
						}
						
					}
				});
				GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
				gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton_2.gridx = 0;
				gbc_btnNewButton_2.gridy = 2;
				panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton(">>");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						imprimirTodosNoSelec();
					}
				});
				GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
				gbc_btnNewButton_3.gridx = 0;
				gbc_btnNewButton_3.gridy = 3;
				panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
				
		listaEstNoSelec = new JList(getDefaultListModelNoSelec());		
		listaEstNoSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		
		JScrollPane scrollPane_1 = new JScrollPane(listaEstNoSelec);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.weightx = 1.0;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 1;
		add(scrollPane_1, gbc_scrollPane_1);
		
		imprimirTodosSelec();

	}
	
	
	private DefaultListModel getDefaultListModelSelec () {
		modeloListaEstSelec = new DefaultListModel<Estudiante>();
		return this.modeloListaEstSelec;
	}
	
	
	private DefaultListModel getDefaultListModelNoSelec () {
		modeloListaEstNoSelec = new DefaultListModel<Estudiante>();
		return this.modeloListaEstNoSelec;
	}
	/**
	 * 
	 * 
	 * 
	 */
	
	private void imprimirTodosSelec() {
		List<Estudiante> es = ControladorEstudiante.findAll();
		
		for (Estudiante estudiante : es) {
			modeloListaEstSelec.addElement(estudiante);
		}
		
		modeloListaEstNoSelec.removeAllElements();
	}
	
	
	/**
	 * 
	 * 
	 * 
	 */
	
	private void imprimirTodosNoSelec() {
		List<Estudiante> es = ControladorEstudiante.findAll();
		
		for (Estudiante estudiante : es) {
			modeloListaEstNoSelec.addElement(estudiante);
		}
		modeloListaEstSelec.removeAllElements();
	}
	
	
	/**
	 * 
	 * 
	 */
	
	public static void insertarNotas(Profesor p,float n, Materia m) {
		System.out.println("au");
		for (int i = 0; i < modeloListaEstSelec.size(); i++) {
			Estudiante e = modeloListaEstSelec.getElementAt(i);
			System.out.println(e.toString() + ", " + p.toString() + ", " + m.toString() + ", " + n);
			Valoracionmateria v = new Valoracionmateria(0,n,e,m,p);
			
			ControladorNota.save(v);
		}
	}
	

}
