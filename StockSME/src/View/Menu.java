package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldProducto;
	private JTextField textFieldMarca;
	private JTextField textFieldProveedor;
	private JTextField textFieldCodigoProveedor;
	private JTextField textFieldPresentacion;
	private JTextField textFieldBaseCosteUnidad;
	private JTextField textFieldBaseVenta;
	private JTextField textFieldTipoIVA;
	private JTextField textFieldCodigoDeBarras;
	private JTextField textFieldCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 396);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevoProducto = new JMenuItem("Nuevo producto");
		mnArchivo.add(mntmNuevoProducto);
		
		mntmNuevoProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "panelNuevoProducto");
			}
		});
		
		JMenuItem mntmConsultarProductos = new JMenuItem("Consultar productos");
		mnArchivo.add(mntmConsultarProductos);
		
		mntmConsultarProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "panelProductos");
			}
		});
		
		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mnArchivo.add(mntmExportar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelProductos = new JPanel();
		contentPane.add(panelProductos, "panelProductos");
		
		JPanel panelNuevoProducto = new JPanel();
		contentPane.add(panelNuevoProducto, "panelNuevoProducto");
		GridBagLayout gbl_panelNuevoProducto = new GridBagLayout();
		gbl_panelNuevoProducto.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelNuevoProducto.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelNuevoProducto.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelNuevoProducto.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNuevoProducto.setLayout(gbl_panelNuevoProducto);
		
		JLabel lblNuevoProducto = new JLabel("NUEVO PRODUCTO");
		GridBagConstraints gbc_lblNuevoProducto = new GridBagConstraints();
		gbc_lblNuevoProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoProducto.gridx = 1;
		gbc_lblNuevoProducto.gridy = 0;
		panelNuevoProducto.add(lblNuevoProducto, gbc_lblNuevoProducto);
		
		JLabel lblProducto = new JLabel("PRODUCTO:");
		GridBagConstraints gbc_lblProducto = new GridBagConstraints();
		gbc_lblProducto.anchor = GridBagConstraints.EAST;
		gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProducto.gridx = 0;
		gbc_lblProducto.gridy = 1;
		panelNuevoProducto.add(lblProducto, gbc_lblProducto);
		
		textFieldProducto = new JTextField();
		GridBagConstraints gbc_textFieldProducto = new GridBagConstraints();
		gbc_textFieldProducto.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProducto.gridx = 1;
		gbc_textFieldProducto.gridy = 1;
		panelNuevoProducto.add(textFieldProducto, gbc_textFieldProducto);
		textFieldProducto.setColumns(10);
		
		JLabel lblMarca = new JLabel("MARCA:");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 2;
		panelNuevoProducto.add(lblMarca, gbc_lblMarca);
		
		textFieldMarca = new JTextField();
		GridBagConstraints gbc_textFieldMarca = new GridBagConstraints();
		gbc_textFieldMarca.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMarca.gridx = 1;
		gbc_textFieldMarca.gridy = 2;
		panelNuevoProducto.add(textFieldMarca, gbc_textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel lblProveedor = new JLabel("PROVEEDOR:");
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.anchor = GridBagConstraints.EAST;
		gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor.gridx = 0;
		gbc_lblProveedor.gridy = 3;
		panelNuevoProducto.add(lblProveedor, gbc_lblProveedor);
		
		textFieldProveedor = new JTextField();
		GridBagConstraints gbc_textFieldProveedor = new GridBagConstraints();
		gbc_textFieldProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProveedor.gridx = 1;
		gbc_textFieldProveedor.gridy = 3;
		panelNuevoProducto.add(textFieldProveedor, gbc_textFieldProveedor);
		textFieldProveedor.setColumns(10);
		
		JLabel lblCodigoProveedor = new JLabel("CODIGO PROVEEDOR:");
		GridBagConstraints gbc_lblCodigoProveedor = new GridBagConstraints();
		gbc_lblCodigoProveedor.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoProveedor.gridx = 0;
		gbc_lblCodigoProveedor.gridy = 4;
		panelNuevoProducto.add(lblCodigoProveedor, gbc_lblCodigoProveedor);
		
		textFieldCodigoProveedor = new JTextField();
		GridBagConstraints gbc_textFieldCodigoProveedor = new GridBagConstraints();
		gbc_textFieldCodigoProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigoProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigoProveedor.gridx = 1;
		gbc_textFieldCodigoProveedor.gridy = 4;
		panelNuevoProducto.add(textFieldCodigoProveedor, gbc_textFieldCodigoProveedor);
		textFieldCodigoProveedor.setColumns(10);
		
		JLabel lblPresentacion = new JLabel("PRESENTACION:");
		GridBagConstraints gbc_lblPresentacion = new GridBagConstraints();
		gbc_lblPresentacion.anchor = GridBagConstraints.EAST;
		gbc_lblPresentacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPresentacion.gridx = 0;
		gbc_lblPresentacion.gridy = 5;
		panelNuevoProducto.add(lblPresentacion, gbc_lblPresentacion);
		
		textFieldPresentacion = new JTextField();
		GridBagConstraints gbc_textFieldPresentacion = new GridBagConstraints();
		gbc_textFieldPresentacion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPresentacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPresentacion.gridx = 1;
		gbc_textFieldPresentacion.gridy = 5;
		panelNuevoProducto.add(textFieldPresentacion, gbc_textFieldPresentacion);
		textFieldPresentacion.setColumns(10);
		
		JLabel lblBaseCosteUnidad = new JLabel("BASE COSTE UNIDAD:");
		GridBagConstraints gbc_lblBaseCosteUnidad = new GridBagConstraints();
		gbc_lblBaseCosteUnidad.anchor = GridBagConstraints.EAST;
		gbc_lblBaseCosteUnidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaseCosteUnidad.gridx = 0;
		gbc_lblBaseCosteUnidad.gridy = 6;
		panelNuevoProducto.add(lblBaseCosteUnidad, gbc_lblBaseCosteUnidad);
		
		textFieldBaseCosteUnidad = new JTextField();
		GridBagConstraints gbc_textFieldBaseCosteUnidad = new GridBagConstraints();
		gbc_textFieldBaseCosteUnidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBaseCosteUnidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBaseCosteUnidad.gridx = 1;
		gbc_textFieldBaseCosteUnidad.gridy = 6;
		panelNuevoProducto.add(textFieldBaseCosteUnidad, gbc_textFieldBaseCosteUnidad);
		textFieldBaseCosteUnidad.setColumns(10);
		
		JLabel lblBaseVenta = new JLabel("BASE VENTA:");
		GridBagConstraints gbc_lblBaseVenta = new GridBagConstraints();
		gbc_lblBaseVenta.anchor = GridBagConstraints.EAST;
		gbc_lblBaseVenta.insets = new Insets(0, 0, 5, 5);
		gbc_lblBaseVenta.gridx = 0;
		gbc_lblBaseVenta.gridy = 7;
		panelNuevoProducto.add(lblBaseVenta, gbc_lblBaseVenta);
		
		textFieldBaseVenta = new JTextField();
		GridBagConstraints gbc_textFieldBaseVenta = new GridBagConstraints();
		gbc_textFieldBaseVenta.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBaseVenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBaseVenta.gridx = 1;
		gbc_textFieldBaseVenta.gridy = 7;
		panelNuevoProducto.add(textFieldBaseVenta, gbc_textFieldBaseVenta);
		textFieldBaseVenta.setColumns(10);
		
		JLabel lblTipoIva = new JLabel("TIPO IVA:");
		GridBagConstraints gbc_lblTipoIva = new GridBagConstraints();
		gbc_lblTipoIva.anchor = GridBagConstraints.EAST;
		gbc_lblTipoIva.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoIva.gridx = 0;
		gbc_lblTipoIva.gridy = 8;
		panelNuevoProducto.add(lblTipoIva, gbc_lblTipoIva);
		
		textFieldTipoIVA = new JTextField();
		GridBagConstraints gbc_textFieldTipoIVA = new GridBagConstraints();
		gbc_textFieldTipoIVA.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTipoIVA.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTipoIVA.gridx = 1;
		gbc_textFieldTipoIVA.gridy = 8;
		panelNuevoProducto.add(textFieldTipoIVA, gbc_textFieldTipoIVA);
		textFieldTipoIVA.setColumns(10);
		
		JLabel lblCodigoDeBarras = new JLabel("CODIGO DE BARRAS:");
		GridBagConstraints gbc_lblCodigoDeBarras = new GridBagConstraints();
		gbc_lblCodigoDeBarras.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoDeBarras.gridx = 0;
		gbc_lblCodigoDeBarras.gridy = 9;
		panelNuevoProducto.add(lblCodigoDeBarras, gbc_lblCodigoDeBarras);
		
		textFieldCodigoDeBarras = new JTextField();
		GridBagConstraints gbc_textFieldCodigoDeBarras = new GridBagConstraints();
		gbc_textFieldCodigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigoDeBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigoDeBarras.gridx = 1;
		gbc_textFieldCodigoDeBarras.gridy = 9;
		panelNuevoProducto.add(textFieldCodigoDeBarras, gbc_textFieldCodigoDeBarras);
		textFieldCodigoDeBarras.setColumns(10);
		
		JLabel lblCantidad = new JLabel("CANTIDAD:");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 0;
		gbc_lblCantidad.gridy = 10;
		panelNuevoProducto.add(lblCantidad, gbc_lblCantidad);
		
		textFieldCantidad = new JTextField();
		GridBagConstraints gbc_textFieldCantidad = new GridBagConstraints();
		gbc_textFieldCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCantidad.gridx = 1;
		gbc_textFieldCantidad.gridy = 10;
		panelNuevoProducto.add(textFieldCantidad, gbc_textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 11;
		panelNuevoProducto.add(btnGuardar, gbc_btnGuardar);
	}

}
