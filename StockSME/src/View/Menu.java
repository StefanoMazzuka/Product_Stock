package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.ConnexionSME;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class Menu extends JFrame {

	/**
	 * Create the frame.
	 */
	public Menu() {
		ConnexionSME con = new ConnexionSME();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmExportarAExcel = new JMenuItem("Exportar a Excel");
		mnArchivo.add(mntmExportarAExcel);
		
		JMenu mnProductos = new JMenu("Productos");
		menuBar.add(mnProductos);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnProductos.add(mntmNuevo);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mnProductos.add(mntmAgregar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnProductos.add(mntmConsultar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "name_27725509490894");
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "name_27737123067211");
	}

}
