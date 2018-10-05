package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Exportador;
import Controller.Producto;
import Controller.QueryTableModel;
import Model.ConnexionSME;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private ConnexionSME conn = new ConnexionSME();

	private static final long serialVersionUID = 1L;
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
	private JTable table;
	private JTextField textFieldBuscar;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevoProducto = new JMenuItem("Nuevo producto");
		mnArchivo.add(mntmNuevoProducto);

		JMenuItem mntmConsultarProductos = new JMenuItem("Consultar productos");
		mnArchivo.add(mntmConsultarProductos);

		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mnArchivo.add(mntmExportar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panelProductos = new JPanel();
		contentPane.add(panelProductos, "panelProductos");
		panelProductos.setLayout(new BorderLayout(0, 0));

		JPanel panelNorteProductos = new JPanel();
		panelProductos.add(panelNorteProductos, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorteProductos = new GridBagLayout();
		gbl_panelNorteProductos.columnWidths = new int[]{217, 0, 201, 0};
		gbl_panelNorteProductos.rowHeights = new int[]{23, 0};
		gbl_panelNorteProductos.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelNorteProductos.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelNorteProductos.setLayout(gbl_panelNorteProductos);

		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		panelNorteProductos.add(toolBar, gbc_toolBar);
		toolBar.setFloatable(false);

		JButton btnEditar = new JButton("Editar");
		toolBar.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar");
		toolBar.add(btnEliminar);

		JButton btnAgregar = new JButton("Agregar");
		toolBar.add(btnAgregar);

		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblProductos = new GridBagConstraints();
		gbc_lblProductos.insets = new Insets(0, 0, 0, 5);
		gbc_lblProductos.gridx = 1;
		gbc_lblProductos.gridy = 0;
		panelNorteProductos.add(lblProductos, gbc_lblProductos);

		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		GridBagConstraints gbc_toolBar_1 = new GridBagConstraints();
		gbc_toolBar_1.anchor = GridBagConstraints.EAST;
		gbc_toolBar_1.gridx = 2;
		gbc_toolBar_1.gridy = 0;
		panelNorteProductos.add(toolBar_1, gbc_toolBar_1);

		JButton btnGanancia = new JButton("Ganancia");
		toolBar_1.add(btnGanancia);

		JButton btnPvp = new JButton("PVP");
		toolBar_1.add(btnPvp);

		JPanel panelCentroProductos = new JPanel();
		panelProductos.add(panelCentroProductos, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentroProductos = new GridBagLayout();
		gbl_panelCentroProductos.columnWidths = new int[]{1184, 0};
		gbl_panelCentroProductos.rowHeights = new int[]{1, 1, 0};
		gbl_panelCentroProductos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCentroProductos.rowWeights = new double[]{1.0, 4.0, Double.MIN_VALUE};
		panelCentroProductos.setLayout(gbl_panelCentroProductos);

		JPanel panelBuscador = new JPanel();
		GridBagConstraints gbc_panelBuscador = new GridBagConstraints();
		gbc_panelBuscador.fill = GridBagConstraints.BOTH;
		gbc_panelBuscador.insets = new Insets(0, 0, 5, 0);
		gbc_panelBuscador.gridx = 0;
		gbc_panelBuscador.gridy = 0;
		panelCentroProductos.add(panelBuscador, gbc_panelBuscador);
		GridBagLayout gbl_panelBuscador = new GridBagLayout();
		gbl_panelBuscador.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelBuscador.rowHeights = new int[] {0, 0};
		gbl_panelBuscador.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBuscador.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelBuscador.setLayout(gbl_panelBuscador);

		String[] datosComboBox = {"CODIGO DE BARRAS", "MARCA", "PROVEEDOR"};
		JComboBox comboBox = new JComboBox(datosComboBox);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.EAST;
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panelBuscador.add(comboBox, gbc_comboBox);

		textFieldBuscar = new JTextField();
		GridBagConstraints gbc_textFieldBuscar = new GridBagConstraints();
		gbc_textFieldBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBuscar.gridx = 1;
		gbc_textFieldBuscar.gridy = 0;
		panelBuscador.add(textFieldBuscar, gbc_textFieldBuscar);
		textFieldBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		panelBuscador.add(btnBuscar, gbc_btnBuscar);

		Object[] head = new String[] {"PRODUCTO", "MARCA", "PROVEEDOR", "CODIGO PROVEEDOR", "PRESENTACION", 
				"BASE COSTE UNIDAD", "BASE VENTA", "TIPO IVA", "CODIGO DE BARRAS", "CANTIDAD"};
		Object[][] body = new Object[][] {};

		QueryTableModel queryTableModel = new QueryTableModel(body, head);	
		table = new JTable();
		table.setModel(queryTableModel);
		productos = conn.selectAll();
		updateTable(queryTableModel);

		JScrollPane scrollPaneTabla = new JScrollPane(table);
		GridBagConstraints gbc_scrollPaneTabla = new GridBagConstraints();
		gbc_scrollPaneTabla.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTabla.gridx = 0;
		gbc_scrollPaneTabla.gridy = 1;
		panelCentroProductos.add(scrollPaneTabla, gbc_scrollPaneTabla);

		JPanel panelNuevoProducto = new JPanel();
		contentPane.add(panelNuevoProducto, "panelNuevoProducto");
		GridBagLayout gbl_panelNuevoProducto = new GridBagLayout();
		gbl_panelNuevoProducto.columnWidths = new int[] {1, 1, 1, 0};
		gbl_panelNuevoProducto.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelNuevoProducto.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_panelNuevoProducto.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelNuevoProducto.setLayout(gbl_panelNuevoProducto);

		JLabel lblNuevoProducto = new JLabel("NUEVO PRODUCTO");
		lblNuevoProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		gbc_textFieldProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProducto.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldProducto.gridx = 1;
		gbc_textFieldProducto.gridy = 1;
		panelNuevoProducto.add(textFieldProducto, gbc_textFieldProducto);
		textFieldProducto.setColumns(10);

		JLabel lblImportant1 = new JLabel("*                    ");
		lblImportant1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImportant1.setForeground(Color.RED);
		GridBagConstraints gbc_lblImportant1 = new GridBagConstraints();
		gbc_lblImportant1.anchor = GridBagConstraints.WEST;
		gbc_lblImportant1.insets = new Insets(0, 0, 5, 5);
		gbc_lblImportant1.gridx = 2;
		gbc_lblImportant1.gridy = 1;
		panelNuevoProducto.add(lblImportant1, gbc_lblImportant1);

		JLabel lblMarca = new JLabel("MARCA:");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 2;
		panelNuevoProducto.add(lblMarca, gbc_lblMarca);

		textFieldMarca = new JTextField();
		GridBagConstraints gbc_textFieldMarca = new GridBagConstraints();
		gbc_textFieldMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMarca.insets = new Insets(0, 0, 5, 5);
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
		gbc_textFieldProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProveedor.insets = new Insets(0, 0, 5, 5);
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
		gbc_textFieldCodigoProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigoProveedor.insets = new Insets(0, 0, 5, 5);
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
		gbc_textFieldPresentacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPresentacion.insets = new Insets(0, 0, 5, 5);
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
		gbc_textFieldBaseCosteUnidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBaseCosteUnidad.insets = new Insets(0, 0, 5, 5);
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
		gbc_textFieldBaseVenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBaseVenta.insets = new Insets(0, 0, 5, 5);
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
		gbc_textFieldTipoIVA.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTipoIVA.insets = new Insets(0, 0, 5, 5);
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
		gbc_textFieldCodigoDeBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodigoDeBarras.gridx = 1;
		gbc_textFieldCodigoDeBarras.gridy = 9;
		panelNuevoProducto.add(textFieldCodigoDeBarras, gbc_textFieldCodigoDeBarras);
		textFieldCodigoDeBarras.setColumns(10);

		JLabel lblImportant2 = new JLabel("*");
		lblImportant2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImportant2.setForeground(Color.RED);
		GridBagConstraints gbc_lblImportant2 = new GridBagConstraints();
		gbc_lblImportant2.anchor = GridBagConstraints.WEST;
		gbc_lblImportant2.insets = new Insets(0, 0, 5, 5);
		gbc_lblImportant2.gridx = 2;
		gbc_lblImportant2.gridy = 9;
		panelNuevoProducto.add(lblImportant2, gbc_lblImportant2);

		JLabel lblCantidad = new JLabel("CANTIDAD:");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 0;
		gbc_lblCantidad.gridy = 10;
		panelNuevoProducto.add(lblCantidad, gbc_lblCantidad);

		textFieldCantidad = new JTextField();
		GridBagConstraints gbc_textFieldCantidad = new GridBagConstraints();
		gbc_textFieldCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCantidad.gridx = 1;
		gbc_textFieldCantidad.gridy = 10;
		panelNuevoProducto.add(textFieldCantidad, gbc_textFieldCantidad);
		textFieldCantidad.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 11;
		panelNuevoProducto.add(btnGuardar, gbc_btnGuardar);

		/*
		 * Card Layouts
		 */

		mntmNuevoProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "panelNuevoProducto");

				btnGuardar.setName("guardar");

				textFieldProducto.setText("");
				textFieldMarca.setText("");
				textFieldProveedor.setText("");
				textFieldCodigoProveedor.setText("");
				textFieldPresentacion.setText("");
				textFieldBaseCosteUnidad.setText("");
				textFieldBaseVenta.setText("");
				textFieldTipoIVA.setText("");
				textFieldCodigoDeBarras.setText("");
				textFieldCantidad.setText("");
			}
		});

		mntmConsultarProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "panelProductos");
			}
		});

		/*
		 * Botones
		 */

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldProducto.getText().equals("") || textFieldCodigoDeBarras.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Introducir todos los valores obligatorios *");
				}

				else {
					boolean error = false;

					Producto producto = new Producto();
					producto.setProducto(textFieldProducto.getText());
					producto.setMarca(textFieldMarca.getText());
					producto.setProveedor(textFieldProveedor.getText());
					producto.setCodigoProveedor(textFieldCodigoProveedor.getText());
					producto.setPresentacion(textFieldPresentacion.getText());

					try {
						if (textFieldBaseCosteUnidad.getText().equals("")) producto.setBaseCosteUnidad((float) 0);
						else producto.setBaseCosteUnidad(Float.valueOf(textFieldBaseCosteUnidad.getText()));
						if (textFieldBaseVenta.getText().equals("")) producto.setBaseVenta((float) 0);
						else producto.setBaseVenta(Float.valueOf(textFieldBaseVenta.getText()));
						if (textFieldTipoIVA.getText().equals("")) producto.setTipoIVA((float) 0);
						else producto.setTipoIVA(Float.valueOf(textFieldTipoIVA.getText()));
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Los valores de BASE COSTE UNIDAD, " + '\n' + "BASE VENTA y TIPO IVA "
								+ "deben ser " + '\n' + "números decimales: 1.2", "Error",JOptionPane.ERROR_MESSAGE);
						error = true;
					}

					try {
						if (textFieldCodigoDeBarras.getText().equals("")) producto.setCodigoDeBarras(0);
						else producto.setCodigoDeBarras(Long.valueOf(textFieldCodigoDeBarras.getText()));
						if (textFieldCantidad.getText().equals("")) producto.setCantidad(0);
						else producto.setCantidad(Integer.valueOf(textFieldCantidad.getText()));
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Los valores de CANTIDAD y CODIGO DE BARRAS " + '\n' 
								+ "deben ser números enteros", "Error",JOptionPane.ERROR_MESSAGE);
						error = true;
					}

					if (!error) {

						if (btnGuardar.getName() == "guardar")	conn.insertProducto(producto);					
						else {
							producto.setID(Integer.valueOf(btnGuardar.getName()));
							conn.updateProducto(producto);
						}
					}
				}
			}
		});

		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!table.getSelectionModel().isSelectionEmpty()) {
					Producto producto = productos.get(table.getSelectedRow());
					btnGuardar.setName(String.valueOf(producto.getID()));

					textFieldProducto.setText(producto.getProducto());
					textFieldMarca.setText(producto.getMarca());
					textFieldProveedor.setText(producto.getProveedor());
					textFieldCodigoProveedor.setText(producto.getCodigoProveedor());
					textFieldPresentacion.setText(producto.getPresentacion());
					textFieldBaseCosteUnidad.setText(String.valueOf(producto.getBaseCosteUnidad()));
					textFieldBaseVenta.setText(String.valueOf(producto.getBaseVenta()));
					textFieldTipoIVA.setText(String.valueOf(producto.getTipoIVA()));
					textFieldCodigoDeBarras.setText(String.valueOf(producto.getCodigoDeBarras()));
					textFieldCantidad.setText(String.valueOf(producto.getCantidad()));

					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelNuevoProducto");
				}

				else
					JOptionPane.showMessageDialog(null, "Seleccione un modelo.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(!table.getSelectionModel().isSelectionEmpty()) {
					Producto producto = productos.get(table.getSelectedRow());

					int option = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto?", 
							"ATENCIÓN", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						conn.deleteProducto(producto.getID());
						productos.remove(producto);
						updateTable(queryTableModel);
					}
				}

				else
					JOptionPane.showMessageDialog(null, "Seleccione un prodcuto", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(!table.getSelectionModel().isSelectionEmpty()) {
					Producto producto = productos.get(table.getSelectedRow());
					
					String cantidad = JOptionPane.showInputDialog(null, "Cantidad: ", producto.getProducto(), JOptionPane.DEFAULT_OPTION);
					
					try {
						int cantidadReal = Integer.valueOf(cantidad);
						conn.addProducto(producto, cantidadReal);
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "La cantidad deben ser un número entero", "Error",JOptionPane.ERROR_MESSAGE);
					}
				}

				else
					JOptionPane.showMessageDialog(null, "Seleccione un prodcuto", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldBuscar.getText().equals("")) {
					productos = conn.selectAll();
					updateTable(queryTableModel);
				}

				else if (comboBox.getSelectedItem().equals("CODIGO DE BARRAS")) {
					try {
						productos = conn.selectProductoCodigoDeBarras(Long.valueOf(textFieldBuscar.getText()));
						updateTable(queryTableModel);

					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "El CODIGO DE BARRAS " + '\n' 
								+ "deben ser un número entero", "Error",JOptionPane.ERROR_MESSAGE);
					}
				}

				else if (comboBox.getSelectedItem().equals("MARCA")) {
					productos = conn.selectProductoMarca(textFieldBuscar.getText());
					updateTable(queryTableModel);
				}

				else if (comboBox.getSelectedItem().equals("PROVEEDOR")) {
					productos = conn.selectProductoProveedor(textFieldBuscar.getText());
					updateTable(queryTableModel);
				}
			}
		});

		btnGanancia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!table.getSelectionModel().isSelectionEmpty()) {
					Producto producto = productos.get(table.getSelectedRow());

					JLabel[] labels = new JLabel[4];
					labels[0] = new JLabel(producto.getProducto() + ": ");
					labels[0].setFont(new Font("Arial", Font.BOLD, 12));
					labels[1] = new JLabel((producto.getBaseVenta() - producto.getBaseCosteUnidad()) + "€");
					labels[1].setFont(new Font("Arial", Font.ITALIC, 12));
					
					JOptionPane.showMessageDialog(null, labels, "Ganancia", JOptionPane.INFORMATION_MESSAGE);
				}

				else
					JOptionPane.showMessageDialog(null, "Seleccione un prodcuto", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnPvp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!table.getSelectionModel().isSelectionEmpty()) {
					Producto producto = productos.get(table.getSelectedRow());

					JLabel[] labels = new JLabel[4];
					labels[0] = new JLabel(producto.getProducto() + ": ");
					labels[0].setFont(new Font("Arial", Font.BOLD, 12));
					labels[1] = new JLabel((producto.getBaseVenta() * producto.getTipoIVA()) + producto.getBaseVenta() + "€");
					labels[1].setFont(new Font("Arial", Font.ITALIC, 12));
					
					JOptionPane.showMessageDialog(null, labels, "PVP", JOptionPane.INFORMATION_MESSAGE);
				}

				else
					JOptionPane.showMessageDialog(null, "Seleccione un prodcuto", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		mntmExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Producto> todoLosProductos = conn.selectAll();
				exportarTabla(todoLosProductos);
			}
		});
	}

	private void updateTable(QueryTableModel queryTableModel) {
		Object[][] body = new Object[productos.size()][10];

		int rowCount = queryTableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			queryTableModel.removeRow(i);
		}

		for (int i = 0; i < productos.size(); i++) {
			body[i][0] = productos.get(i).getProducto();
			body[i][1] = productos.get(i).getMarca();
			body[i][2] = productos.get(i).getProveedor();
			body[i][3] = productos.get(i).getCodigoProveedor();
			body[i][4] = productos.get(i).getPresentacion();
			body[i][5] = productos.get(i).getBaseCosteUnidad();
			body[i][6] = productos.get(i).getBaseVenta();
			body[i][7] = productos.get(i).getTipoIVA();
			body[i][8] = productos.get(i).getCodigoDeBarras();
			body[i][9] = productos.get(i).getCantidad();

			queryTableModel.addRow(body[i]);
		}
	}
	
	private void exportarTabla(ArrayList<Producto> todosLosProductos) {
		JFileChooser fc = new JFileChooser();
		int result = fc.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			Exportador excelExporter = new Exportador();	
			try {
				excelExporter.exportar(todosLosProductos, new File(file.getPath() + ".csv"));
				JOptionPane.showMessageDialog(null, "Fichero generado con éxito.", 
						"Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
