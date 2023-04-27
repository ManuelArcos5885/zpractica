package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorMateria;
import controlador.ControladorNota;
import controlador.ControladorProfesor;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameOrigen extends JFrame {

	private JPanel contentPane;
	private static JComboBox comboBox_Materia;
	private static JComboBox comboBox_Profesor;
	private static JComboBox comboBox_Nota;
	private static JButton btnNewButton;
	private static PanelAlumno panelAlumno;
	private static JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameOrigen frame = new FrameOrigen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameOrigen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox_Materia = new JComboBox();
		GridBagConstraints gbc_comboBox_Materia = new GridBagConstraints();
		gbc_comboBox_Materia.gridwidth = 3;
		gbc_comboBox_Materia.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_Materia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Materia.gridx = 1;
		gbc_comboBox_Materia.gridy = 0;
		contentPane.add(comboBox_Materia, gbc_comboBox_Materia);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox_Profesor = new JComboBox();
		GridBagConstraints gbc_comboBox_Profesor = new GridBagConstraints();
		gbc_comboBox_Profesor.gridwidth = 3;
		gbc_comboBox_Profesor.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_Profesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Profesor.gridx = 1;
		gbc_comboBox_Profesor.gridy = 1;
		contentPane.add(comboBox_Profesor, gbc_comboBox_Profesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox_Nota = new JComboBox();
		GridBagConstraints gbc_comboBox_Nota = new GridBagConstraints();
		gbc_comboBox_Nota.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Nota.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Nota.gridx = 1;
		gbc_comboBox_Nota.gridy = 2;
		contentPane.add(comboBox_Nota, gbc_comboBox_Nota);
		
		btnNewButton = new JButton("Botom actualizar alumno");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		panelAlumno = new PanelAlumno();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panelAlumno, gbc_panel);
		
		btnNewButton_1 = new JButton("Guardar Notas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Materia m = (Materia) comboBox_Materia.getSelectedItem();
				Profesor p = (Profesor) comboBox_Profesor.getSelectedItem();
				float n = (float) comboBox_Nota.getSelectedItem();

				
				panelAlumno.insertarNotas(p, n, m);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 5;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		cargarMaterias();
		cargarProfe();
		cargarNotas();
	}
	
	
	
	
	public static void cargarMaterias() {
		List<Materia> ms = ControladorMateria.findAll();
		
		
		for (Materia materia : ms) {
			comboBox_Materia.addItem(materia);
		}
	}
	
	
	public static void cargarProfe() {
		List<Profesor> ms = ControladorProfesor.findAll();
		
		
		for (Profesor p : ms) {
			comboBox_Profesor.addItem(p);
		}
	}
	
	
	public static void cargarNotas() {
		List<Float> ms = new ArrayList();
		
		for (float i = 0; i < 11; i++) {
			ms.add(i);
		}
		
		for (Float i : ms) {
			comboBox_Nota.addItem(i);
		}
	}

}
