/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema_Papeleria;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aaaaa
 */
public class Principal extends javax.swing.JFrame {
    String usuario;
    DefaultTableModel model;
    DefaultTableModel venta;
    DefaultTableModel ventas;
    DefaultTableModel compra;
    DefaultTableModel compras;
    DefaultTableModel tablaInventario;
    DefaultTableModel proveedores;
    Conexion c = new Conexion();
    Connection cn =  c.conectar();
    TextAutoCompleter ac;
    TextAutoCompleter ac2;
    TextAutoCompleter ac3;
    private float totalCompra;
    private float totalVenta;
    
    /**
     * Creates new form Principal
     */
    public Principal(){
        
    }
    
    public Principal(String idvendedor) {
        initComponents();
        this.usuario = idvendedor;
        validarUsuario();
        mostrarUsuario();
        jPanel2.setBackground(Color.decode("#669966"));
        jPanel9.setBackground(Color.decode("#669966"));
        jPanel10.setBackground(Color.decode("#669966"));
        jPanel8.setBackground(Color.decode("#669966"));
        jPanel6.setBackground(Color.decode("#669966"));
        jPanel4.setBackground(Color.decode("#669966"));
        jPanel3.setBackground(Color.decode("#669966"));
        jPanel5.setBackground(Color.decode("#669966"));
        jPanel1.setBackground(Color.decode("#669966"));
        jPanel11.setBackground(Color.decode("#669966"));
        jPanel12.setBackground(Color.decode("#669966"));
        jPanel13.setBackground(Color.decode("#669966"));
        this.lblFecha.setText(fechaActual());
        model=new DefaultTableModel();
        model.addColumn("ID Producto");
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
        model.addColumn("Categoria");
        model.addColumn("Stock");
        model.addColumn("Precio de Venta");
        this.tblProductos.setModel(model);
        venta = new DefaultTableModel();
        venta.addColumn("ID Venta");
        venta.addColumn("ID Producto");
        venta.addColumn("Cantidad");
        venta.addColumn("Total Venta");
        venta.addColumn("Precio Venta");
        this.tblDetalleXVenta.setModel(venta);
        ventas = new DefaultTableModel();
        ventas.addColumn("ID Venta");
        ventas.addColumn("ID Vendedor");
        ventas.addColumn("Fecha");
        this.tblVentas.setModel(ventas);
        compra = new DefaultTableModel();
        compra.addColumn("ID Compra");
        compra.addColumn("ID Producto");
        compra.addColumn("Cantidad");
        compra.addColumn("Precio Compra");
        compra.addColumn("Subtotal");
        this.tblDetalleXCompra.setModel(compra);
        compras = new DefaultTableModel();
        compras.addColumn("ID Compra");
        compras.addColumn("ID Proveedor");
        compras.addColumn("Fecha");
        this.tblCompras.setModel(compras);
        tablaInventario=new DefaultTableModel();
        tablaInventario.addColumn("ID Producto");
        tablaInventario.addColumn("Nombre");
        tablaInventario.addColumn("Descripcion");
        tablaInventario.addColumn("Categoria");
        tablaInventario.addColumn("Stock");
        tablaInventario.addColumn("Precio de Venta");
        this.tblInventario.setModel(tablaInventario);
        proveedores = new DefaultTableModel();
        proveedores.addColumn("ID Proveedor");
        proveedores.addColumn("Nombre");
        this.tblProveedores.setModel(proveedores);
        insertarIDVenta();
        insertarIDCompra();
        ac = new TextAutoCompleter(this.txtNombreProductoVenta);
        ac2 = new TextAutoCompleter(this.txtProductoCompra);
        actualizarAutoCompleterProductos();
        ac3 = new TextAutoCompleter(this.txtProveedor);
        actualizarAutoCompleterProveedores();
        this.totalCompra = 0;
        this.totalVenta = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        txtDescripcionProducto = new javax.swing.JTextField();
        txtCategoriaProducto = new javax.swing.JTextField();
        txtStockProducto = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        btnAltaProducto = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtIDVenta = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtNombreProductoVenta = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCantidadVenta = new javax.swing.JTextField();
        btnRegistrarVenta = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDetalleXVenta = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnBuscarVenta = new javax.swing.JButton();
        btnEliminarVenta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        dateVenta = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtIDCompra = new javax.swing.JTextField();
        btnAgregarProductoCompra = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtProductoCompra = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtCantidadCompra = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        btnRegistrarCompra = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDetalleXCompra = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnBuscarCompra = new javax.swing.JButton();
        btnEliminarCompra = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        dateCompra = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        btnInventario = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnProductoMasVendido = new javax.swing.JButton();
        btnMejorVendedor = new javax.swing.JButton();
        btnMejorProveedor = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIDProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();
        btnRegistrarProveedor = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        imgApagar = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.black);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setForeground(new java.awt.Color(51, 255, 153));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel5.setText("ID Producto:");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel7.setText("Descripción:");

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel8.setText("Categoría:");

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel9.setText("Stock:");

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel10.setText("Precio de Venta");

        txtIDProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDProductoKeyTyped(evt);
            }
        });

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        txtCategoriaProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCategoriaProductoKeyTyped(evt);
            }
        });

        txtStockProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockProductoKeyTyped(evt);
            }
        });

        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        btnAltaProducto.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnAltaProducto.setText("Dar de alta");
        btnAltaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaProductoActionPerformed(evt);
            }
        });

        btnBuscarProducto.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnActualizarProducto.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnActualizarProducto.setText("Actualizar");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Descripción", "Stock", "Categoria", "Precio"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAltaProducto)
                                    .addComponent(btnActualizarProducto))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBuscarProducto)
                                .addGap(48, 48, 48))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnAltaProducto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnActualizarProducto)))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnBuscarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("PRODUCTOS", jPanel2);

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel20.setText("ID Venta:");

        txtIDVenta.setEnabled(false);
        txtIDVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDVentaKeyTyped(evt);
            }
        });

        btnAgregarProducto.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel21.setText("Producto:");

        txtNombreProductoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoVentaKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel22.setText("Cantidad:");

        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });

        btnRegistrarVenta.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnRegistrarVenta.setText("Registrar venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        tblDetalleXVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "ID Producto", "Cantidad", "Total Venta", "Precio Venta"
            }
        ));
        tblDetalleXVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleXVentaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDetalleXVenta);

        jLabel23.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel23.setText("Total Venta:");

        txtTotalVenta.setEnabled(false);
        txtTotalVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalVentaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtNombreProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel22))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregarProducto)))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtIDVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txtNombreProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregarProducto)
                        .addGap(28, 28, 28)
                        .addComponent(btnRegistrarVenta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        jTabbedPane1.addTab("VENTA", jPanel1);

        btnBuscarVenta.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnBuscarVenta.setText("Buscar Venta");
        btnBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaActionPerformed(evt);
            }
        });

        btnEliminarVenta.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnEliminarVenta.setText("Eliminar venta");
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Venta", "ID Vendedor", "Fecha"
            }
        ));
        jScrollPane3.setViewportView(tblVentas);

        jLabel25.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel25.setText("Fecha:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarVenta)
                    .addComponent(btnEliminarVenta))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(dateVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VENTAS", jPanel5);

        jLabel26.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel26.setText("ID Compra:");

        txtIDCompra.setEnabled(false);
        txtIDCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDCompraKeyTyped(evt);
            }
        });

        btnAgregarProductoCompra.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnAgregarProductoCompra.setText("Agregar producto");
        btnAgregarProductoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoCompraActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel27.setText("Producto:");

        txtProductoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoCompraKeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel28.setText("Cantidad:");

        txtCantidadCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadCompraKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel29.setText("Precio compra:");

        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel30.setText("Total compra:");

        txtTotalCompra.setEnabled(false);
        txtTotalCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalCompraKeyTyped(evt);
            }
        });

        btnRegistrarCompra.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnRegistrarCompra.setText("Registrar compra");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });

        tblDetalleXCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Compra", "ID Producto", "Cantidad", "Precio Compra", "Subtotal"
            }
        ));
        tblDetalleXCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleXCompraMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDetalleXCompra);

        jLabel32.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel32.setText("Proveedor:");

        txtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProveedorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProductoCompra)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel30))
                                        .addGap(9, 9, 9))
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(205, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                    .addContainerGap(517, Short.MAX_VALUE)
                    .addComponent(btnRegistrarCompra)
                    .addGap(19, 19, 19)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtIDCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarProductoCompra)))
                .addGap(1, 1, 1)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(btnRegistrarCompra)
                    .addContainerGap(350, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("COMPRA", jPanel7);

        btnBuscarCompra.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnBuscarCompra.setText("Buscar Compra");
        btnBuscarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCompraActionPerformed(evt);
            }
        });

        btnEliminarCompra.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnEliminarCompra.setText("Eliminar compra");
        btnEliminarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCompraActionPerformed(evt);
            }
        });

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Compra", "ID Proveedor", "Fecha"
            }
        ));
        jScrollPane6.setViewportView(tblCompras);

        jLabel31.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel31.setText("Fecha:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(btnEliminarCompra)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCompra)
                    .addComponent(btnEliminarCompra))
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(dateCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("COMPRAS", jPanel3);

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Categoría", "Stock", "Precio de Venta"
            }
        ));
        jScrollPane2.setViewportView(tblInventario);

        btnInventario.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnInventario.setText("Mostrar Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInventario)
                .addGap(238, 238, 238))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInventario)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("INVENTARIO", jPanel4);

        btnProductoMasVendido.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnProductoMasVendido.setText("Producto más vendido");
        btnProductoMasVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoMasVendidoActionPerformed(evt);
            }
        });

        btnMejorVendedor.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnMejorVendedor.setText("Mejor vendedor");
        btnMejorVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMejorVendedorActionPerformed(evt);
            }
        });

        btnMejorProveedor.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnMejorProveedor.setText("Mejor proveedor");
        btnMejorProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMejorProveedorActionPerformed(evt);
            }
        });

        btnVentas.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnCompras.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnCompras.setText("Compras");
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProyecto/Reportes.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(161, 161, 161))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnProductoMasVendido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCompras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMejorVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMejorProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(btnVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(101, 101, 101)))
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnProductoMasVendido)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnMejorVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnMejorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVentas)
                        .addGap(39, 39, 39)))
                .addComponent(btnCompras)
                .addGap(87, 87, 87)
                .addComponent(jLabel17)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REPORTES", jPanel6);

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel11.setText("ID Proveedor");

        jLabel12.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel12.setText("Nombre:");

        txtIDProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDProveedorKeyTyped(evt);
            }
        });

        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });

        btnBuscarProveedor.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        btnActualizarProveedor.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnActualizarProveedor.setText("Actualizar");
        btnActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveedorActionPerformed(evt);
            }
        });

        btnRegistrarProveedor.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnRegistrarProveedor.setText("Registrar");
        btnRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProveedorActionPerformed(evt);
            }
        });

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Proveedor", "Nombre"
            }
        ));
        jScrollPane7.setViewportView(tblProveedores);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDProveedor)
                                    .addComponent(txtNombreProveedor)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(btnRegistrarProveedor)
                                .addGap(170, 170, 170)
                                .addComponent(btnActualizarProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarProveedor))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarProveedor)
                    .addComponent(btnActualizarProveedor)
                    .addComponent(btnBuscarProveedor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PROVEEDORES", jPanel13);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("PAPELERIA \"ESTRADA\"");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(39, 39, 39))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblFecha.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        lblFecha.setText("Fecha");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFecha)
                .addGap(120, 120, 120))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUsuario.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        lblUsuario.setText("Usuario: ");

        imgApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProyecto/Apagado.png"))); // NOI18N
        imgApagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgApagarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgApagar)
                .addGap(44, 44, 44))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblUsuario)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProyecto/icono (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar()!='.'){
            evt.consume();
        }
        if(evt.getKeyChar()=='.' && txtPrecioVenta.getText().contains(".")){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtStockProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockProductoKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtStockProductoKeyTyped

    private void txtCategoriaProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaProductoKeyTyped
        // TODO add your handling code here:
        if(!Character.isLetter(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtCategoriaProductoKeyTyped

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        // TODO add your handling code here:
        if(!Character.isLetter(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void txtIDProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDProductoKeyTyped
        // TODO add your handling code here:
        if(!Character.isLetter(evt.getKeyChar()) && !Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtIDProductoKeyTyped

    private void imgApagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgApagarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_imgApagarMouseClicked

    private void txtIDVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDVentaKeyTyped

    private void txtNombreProductoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoVentaKeyTyped
        // TODO add your handling code here:
         if(!Character.isLetter(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())){
            evt.consume();
        }
         
    }//GEN-LAST:event_txtNombreProductoVentaKeyTyped

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void txtIDCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDCompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCompraKeyTyped

    private void txtProductoCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoCompraKeyTyped
        // TODO add your handling code here:
         if(!Character.isLetter(evt.getKeyChar()) && !Character.isSpaceChar(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtProductoCompraKeyTyped

    private void txtCantidadCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCompraKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadCompraKeyTyped

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar()!='.'){
            evt.consume();
        }
        if(evt.getKeyChar()=='.' && txtPrecioCompra.getText().contains(".")){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void txtTotalCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalCompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCompraKeyTyped

    private void btnAgregarProductoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoCompraActionPerformed
        // TODO add your handling code here:
         agregarDetalleCompra(this.txtProductoCompra.getText());
        this.txtProductoCompra.setText("");
        this.txtCantidadCompra.setText("");
        this.txtPrecioCompra.setText("");
        calcularTotalCompra();
        this.txtTotalCompra.setText(this.totalCompra+"");
    }//GEN-LAST:event_btnAgregarProductoCompraActionPerformed

    private void btnBuscarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCompraActionPerformed
        // TODO add your handling code here:
        buscarCompra();
    }//GEN-LAST:event_btnBuscarCompraActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void txtIDProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDProveedorKeyTyped

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void btnAltaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaProductoActionPerformed
        // TODO add your handling code here:
        if(this.txtIDProducto.getText().equals("") || this.txtNombreProducto.getText().equals("") || this.txtDescripcionProducto.getText().equals("")
                || this.txtCategoriaProducto.getText().equals("") || this.txtStockProducto.getText().equals("") || this.txtPrecioVenta.getText().equals("")){
            
        }else{
            registrarProducto();
        this.agregarDatosTablaProductos();
        this.txtIDProducto.setText("");
        this.txtNombreProducto.setText("");
        this.txtDescripcionProducto.setText("");
        this.txtCategoriaProducto.setText("");
        this.txtStockProducto.setText("");
        this.txtPrecioVenta.setText("");
        actualizarAutoCompleterProductos();
        }
    }//GEN-LAST:event_btnAltaProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        agregarDetalleVenta(this.txtNombreProductoVenta.getText());
        this.txtNombreProductoVenta.setText("");
        this.txtCantidadVenta.setText("");
        this.calcularTotalVenta();
        this.txtTotalVenta.setText(this.totalVenta+"");
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        // TODO add your handling code here:
        if(this.tblDetalleXVenta.getRowCount()>0){
        agregarDatosTablaVenta();
        insertarIDVenta();
        
        for(int i = venta.getRowCount()-1; i>=0; i--){
            venta.removeRow(i);
        }
        this.totalVenta = 0;
        }
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaActionPerformed
        // TODO add your handling code here:
        buscarVenta();
    }//GEN-LAST:event_btnBuscarVentaActionPerformed

    private void tblDetalleXVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleXVentaMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==MouseEvent.BUTTON3){
            int fila = this.tblDetalleXVenta.getSelectedRow();
            if(fila>=0){
              this.totalVenta -= Float.parseFloat(this.tblDetalleXVenta.getValueAt(fila, 4).toString());
              this.txtTotalVenta.setText(this.totalVenta+"");
             venta.removeRow(fila);   
            }
        }
    }//GEN-LAST:event_tblDetalleXVentaMouseClicked

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        // TODO add your handling code here:
        if(this.tblVentas.getSelectedRow()>=0){
        eliminarVenta();
        }
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        // TODO add your handling code here:
        if(this.tblDetalleXCompra.getRowCount()>0){
        agregarDatosTablaCompra(this.txtProveedor.getText());
        insertarIDCompra();
        
        for(int i = compra.getRowCount()-1; i>=0; i--){
            compra.removeRow(i);
        }
        this.txtProveedor.setText("");
        }
        this.totalCompra = 0;
        this.txtTotalCompra.setText(this.totalCompra+"");
        this.txtProveedor.setEnabled(true);
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void txtProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProveedorKeyTyped

    private void btnEliminarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCompraActionPerformed
        // TODO add your handling code here:
        if(this.tblCompras.getSelectedRow()>=0){
        eliminarCompra();
        }
    }//GEN-LAST:event_btnEliminarCompraActionPerformed

    private void btnRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProveedorActionPerformed
        // TODO add your handling code here:
        registrarProveedor();
        this.txtIDProveedor.setText("");
        this.txtNombreProveedor.setText("");
    }//GEN-LAST:event_btnRegistrarProveedorActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        // TODO add your handling code here:
        if(this.txtNombreProveedor.getText().equals("")){   
        }else{
            buscarProveedor();  
        }
       
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void btnActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveedorActionPerformed
        // TODO add your handling code here:
        actualizarProveedor();
    }//GEN-LAST:event_btnActualizarProveedorActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        // TODO add your handling code here:
        modificarProducto();
        actualizarAutoCompleterProductos();
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
        if(this.txtNombreProducto.getText().equals("")){
            
        }else{
        for(int i = model.getRowCount()-1; i>=0; i--){
            model.removeRow(i);
        }
        this.buscarProducto();
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
        this.mostrarInventario();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        // TODO add your handling code here:
        this.seleccionarPrducto(tblProductos, txtIDProducto, this.txtNombreProducto, txtDescripcionProducto, this.txtCategoriaProducto, this.txtStockProducto, txtPrecioVenta);
    }//GEN-LAST:event_tblProductosMouseClicked

    private void tblDetalleXCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleXCompraMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==MouseEvent.BUTTON3){
            int fila = this.tblDetalleXCompra.getSelectedRow();
            if(fila>=0){
             this.totalCompra -= Float.parseFloat(this.tblDetalleXCompra.getValueAt(fila, 4).toString());
             this.txtTotalCompra.setText(this.totalCompra+"");
             compra.removeRow(fila);   
             if(this.tblDetalleXCompra.getRowCount()==0){
                 this.txtProveedor.setEnabled(true);
             }
            }
        }
        
    }//GEN-LAST:event_tblDetalleXCompraMouseClicked

    private void txtTotalVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalVentaKeyTyped

    private void btnProductoMasVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoMasVendidoActionPerformed
        // TODO add your handling code here:
       try{
           String dir = "src/sistema_papeleria/ProductoMasVendido.jrxml";
           JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
           JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper,null,c.conectar());
           JasperViewer.viewReport(mostrarReporte);
       }catch(JRException ex){
           Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
       }
    }//GEN-LAST:event_btnProductoMasVendidoActionPerformed

    private void btnMejorVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMejorVendedorActionPerformed
        // TODO add your handling code here:
        try{
           String dir = "src/sistema_papeleria/MejorVendedor.jrxml";
           JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
           JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper,null,c.conectar());
           JasperViewer.viewReport(mostrarReporte);
        }catch(JRException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btnMejorVendedorActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        try{
           String dir = "src/sistema_papeleria/reporteVentas.jrxml ";
           JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
           JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper,null,c.conectar());
           JasperViewer.viewReport(mostrarReporte);
        }catch(JRException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        // TODO add your handling code here:
        try{
           String dir = "src/sistema_papeleria/reporteCompras.jrxml";
           JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
           JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper,null,c.conectar());
           JasperViewer.viewReport(mostrarReporte);
        }catch(JRException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnMejorProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMejorProveedorActionPerformed
        // TODO add your handling code here:
         try{
           String dir = "src/sistema_papeleria/MejorProveedor.jrxml ";
           JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
           JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper,null,c.conectar());
           JasperViewer.viewReport(mostrarReporte);
        }catch(JRException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_btnMejorProveedorActionPerformed

    //Métodos Y Funciones personalizadas
    private String fechaActual(){
         Calendar c = Calendar.getInstance();
        return c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR);
    }
    
    private void registrarProducto(){
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO Productos VALUES(?,?,?,?,?,?)");
            pps.setString(1, this.txtIDProducto.getText());
            pps.setString(2, this.txtNombreProducto.getText());
            pps.setString(3, this.txtDescripcionProducto.getText());
            pps.setString(4, this.txtCategoriaProducto.getText());
            pps.setInt(5, Integer.parseInt(this.txtStockProducto.getText()));
            pps.setFloat(6, Float.parseFloat(this.txtPrecioVenta.getText()));
            pps.execute();
        } catch (Exception e) {
            
        }
    }
    
    private void agregarDatosTablaProductos (){
        String []info= new String[6];
        info[0]= this.txtIDProducto.getText();
        info[1]=this.txtNombreProducto.getText();
        info[2]=this.txtDescripcionProducto.getText();
        info[3]=this.txtCategoriaProducto.getText();
        info[4]=this.txtStockProducto.getText();
        info[5]=this.txtPrecioVenta.getText();
        model.addRow(info);
       
    }
    
    private void buscarProducto(){
        String nombre = this.txtNombreProducto.getText();
        try{
            PreparedStatement pps = cn.prepareStatement("SELECT * FROM Productos WHERE nombre LIKE '"+nombre+"%'" );
            ResultSet rs = pps.executeQuery();
           
           while(rs.next()){
               String [] info = new String [6];
               info[0]=rs.getString(1);
               info[1]=rs.getString(2);
               info[2]=rs.getString(3);
               info[3]=rs.getString(4);
               info[4]=rs.getString(5);
               info[5]=rs.getString(6);
               model.addRow(info);
           }
           
        }catch (Exception e){
            System.out.println("Error");
        }
    }
    
    private void mostrarInventario(){
        try{
            PreparedStatement pps = cn.prepareStatement("SELECT * FROM Productos");
            ResultSet rs = pps.executeQuery();
            while(rs.next()){
               String [] info = new String [6];
               info[0]=rs.getString(1);
               info[1]=rs.getString(2);
               info[2]=rs.getString(3);
               info[3]=rs.getString(4);
               info[4]=rs.getString(5);
               info[5]=rs.getString(6);
               tablaInventario.addRow(info);
           }
           
        }catch (Exception e){
            System.out.println("Error");
        }
        
    }
    
    
 
    private void modificarProducto(){
        try{
            int fila = this.tblProductos.getSelectedRow();
            String idProducto = this.tblProductos.getValueAt(fila, 0).toString();
            String nombre = this.tblProductos.getValueAt(fila, 1).toString();
            String descripcion = this.tblProductos.getValueAt(fila, 2).toString();
            String categoria = this.tblProductos.getValueAt(fila, 3).toString();
            int stock = Integer.parseInt(this.tblProductos.getValueAt(fila, 4).toString());
            float precio = Float.parseFloat((String) this.tblProductos.getValueAt(fila, 5));
            
            String sql = "UPDATE Productos SET nombre='"+nombre+"',descripcion='"+descripcion+"',categoria='"+categoria+"',stock="+stock+",precio_venta="+precio+" where id_producto='"+idProducto+"';";
            PreparedStatement pps = cn.prepareStatement(sql);
            pps.execute();
            
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM PRODUCTOS WHERE id_producto = '"+idProducto+"'");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
            if(fila>=0){
                model.removeRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "Seleccionar fila");
            }
            
           while(rs.next()){
               String [] info = new String [6];
               info[0]=rs.getString(1);
               info[1]=rs.getString(2);
               info[2]=rs.getString(3);
               info[3]=rs.getString(4);
               info[4]=rs.getString(5);
               info[5]=rs.getString(6);
               model.addRow(info);
           }
           
        }catch (Exception e){
            System.out.println("Errorp");
        }
    }  
    
    public void seleccionarPrducto(JTable paramtblProductos, JTextField paramid_producto, JTextField paramnombre, JTextField paramdescripcion, JTextField paramcategoria, 
            JTextField paramstock, JTextField paramprecio_venta ){
        
        try{
            int fila =paramtblProductos.getSelectedRow();
            
            if(fila>=0){
                paramid_producto.setText(paramtblProductos.getValueAt(fila, 0).toString());
                paramnombre.setText(paramtblProductos.getValueAt(fila, 1).toString());
                paramdescripcion.setText(paramtblProductos.getValueAt(fila, 2).toString());
                paramcategoria.setText(paramtblProductos.getValueAt(fila, 3).toString());
                paramstock.setText(paramtblProductos.getValueAt(fila, 4).toString());
                paramprecio_venta.setText(paramtblProductos.getValueAt(fila, 5).toString());
            }
            else{
                JOptionPane.showMessageDialog(null, "No has seleccionado una fila");
            }
            
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    
    private String calcularPrecio(String cantidad, String precio){
        return (Integer.parseInt(cantidad)*Float.parseFloat(precio))+"";
    }
    
    private void agregarDetalleVenta(String nombre){
        try{
            PreparedStatement pps = cn.prepareStatement("SELECT * FROM buscarProductoXNombre('"+nombre+"')");
            pps.execute();
            ResultSet rs = pps.getResultSet();
            if(rs.next()){
            String []info = new String[5];
                info[0] = this.txtIDVenta.getText();
                info[1] = rs.getString("id_producto");
                info[2] = this.txtCantidadVenta.getText();
                info[3] = calcularPrecio(this.txtCantidadVenta.getText(),rs.getString("precio_venta"));
                info[4] = rs.getString("precio_venta");
                venta.addRow(info);
            }else{
                System.out.println("El producto no existe");
            }
            
        }catch(Exception e){
            System.out.println("error");
        }
    }
    
    private void insertarIDVenta(){
        String resultado = "";
        try{
            PreparedStatement pps = cn.prepareStatement("SELECT ultimaVenta()");
            pps.execute();
            ResultSet rs = pps.getResultSet();
            if(rs.next()){
            resultado = (Integer.parseInt(rs.getString("ultimaventa"))+1)+"";
        }else{
                resultado = "1";
            }
        }catch(Exception e){
            this.txtIDVenta.setText("1");
        }
        this.txtIDVenta.setText(resultado);
    }
    
    private void agregarDatosTablaVenta(){
        try{
        PreparedStatement pps = cn.prepareStatement("CALL agregarVenta(?)");
        pps.setString(1, this.usuario);
        pps.execute();
       
        if(this.tblDetalleXVenta.getRowCount()>0){
            for (int i = 0; i <this.tblDetalleXVenta.getRowCount(); i++) {
                    PreparedStatement ps = cn.prepareStatement("CALL agregarDetalleVenta(?,?,?)");
                    ps.setInt(1, Integer.parseInt(this.tblDetalleXVenta.getValueAt(i, 0).toString()));
                    ps.setString(2, this.tblDetalleXVenta.getValueAt(i, 1).toString());
                    ps.setInt(3, Integer.parseInt((String) this.tblDetalleXVenta.getValueAt(i, 2)));
                    ps.execute();
            }
        }
        
        }catch(Exception e){
            System.out.println("error");
        }
        
    }
    
    public void buscarVenta(){
        try {
        for(int i = ventas.getRowCount()-1; i>=0; i--){
            ventas.removeRow(i);
        }
               
        String formato = this.dateVenta.getDateFormatString();
        Date date = this.dateVenta.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        PreparedStatement pps = cn.prepareStatement("SELECT * FROM buscarVenta('"+String.valueOf(sdf.format(date))+"')");
        pps.execute();
        ResultSet rs = pps.getResultSet();
        while(rs.next()){
                String []info = new String[3];
                info[0] = rs.getString("id_venta");
                info[1] = rs.getString("id_vendedor");
                info[2] = rs.getString("fecha");
                ventas.addRow(info);
        }

} catch (Exception e){
            System.out.println("error");
}
    }
    
    public void eliminarVenta(){
        int fila = this.tblVentas.getSelectedRow();
        String valor = this.tblVentas.getValueAt(fila, 0).toString();
        try{    
            PreparedStatement ps = cn.prepareStatement("DELETE FROM Ventas WHERE id_venta = '"+valor+"'");
            ps.execute();
            
            ventas.removeRow(fila);
        }catch(Exception e){
            System.out.println("error");
        }
    }
    
    private void insertarIDCompra(){
     String resultado = "";
        try{
            PreparedStatement pps = cn.prepareStatement("SELECT ultimaCompra()");
            pps.execute();
            ResultSet rs = pps.getResultSet();
            if(rs.next()){
            resultado = (Integer.parseInt(rs.getString("ultimacompra"))+1)+"";
        }else{
                resultado = "1";
            }
        }catch(Exception e){
            this.txtIDCompra.setText("1");
        }
        this.txtIDCompra.setText(resultado);   
    }
    
    public void agregarDetalleCompra(String nombre){
          try{
            PreparedStatement pps = cn.prepareStatement("SELECT * FROM buscarProductoXNombre('"+nombre+"')");
            pps.execute();
            ResultSet rs = pps.getResultSet();
            if(rs.next()){
            String []info = new String[5];
                info[0] = this.txtIDCompra.getText();
                info[1] = rs.getString("id_producto");
                info[2] = this.txtCantidadCompra.getText();
                info[3] = this.txtPrecioCompra.getText();
                info[4] = calcularPrecio(this.txtCantidadCompra.getText(),this.txtPrecioCompra.getText());
                compra.addRow(info);
                this.txtProveedor.setEnabled(false);
            }else{
                System.out.println("El producto no existe");
            }
            
        }catch(Exception e){
            System.out.println("error");
        }
    }
    
     private void agregarDatosTablaCompra(String proveedor){
        try{
        PreparedStatement pps = cn.prepareStatement("CALL agregarCompra('"+obtenerIDProveedor(proveedor)+"')");
        pps.execute();

        if(this.tblDetalleXCompra.getRowCount()>0){
            for (int i = 0; i <this.tblDetalleXCompra.getRowCount(); i++) {
                int idCompra = Integer.parseInt((String) this.tblDetalleXCompra.getValueAt(i, 0));
                String idProducto = (String) this.tblDetalleXCompra.getValueAt(i, 1);
                int cantidad = Integer.parseInt((String) this.tblDetalleXCompra.getValueAt(i, 2));
                float precioCompra = Float.parseFloat((String) this.tblDetalleXCompra.getValueAt(i, 3));
                
                    PreparedStatement ps = cn.prepareStatement("CALL agregarDetalleCompra('"+idCompra+"','"+idProducto+"','"+cantidad+"','"+precioCompra+"')");
                    ps.execute();
            }
        }
        
        }catch(Exception e){
            System.out.println("error");
        }
        
    }
    
     public String obtenerIDProveedor(String nombre){
         try{
             PreparedStatement pps = cn.prepareStatement("SELECT obtenerIDProveedor('"+nombre+"')");
             pps.execute();
             ResultSet rs = pps.getResultSet();
             if(rs.next()){
                return rs.getString("obteneridproveedor");
             }
             
         }catch(Exception e){
             System.out.println("error");
         }
         return "";
     }
     
     public void buscarCompra(){
        try {
        for(int i = compras.getRowCount()-1; i>=0; i--){
            compras.removeRow(i);
        }
               
        String formato = this.dateCompra.getDateFormatString();
        Date date = this.dateCompra.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        PreparedStatement pps = cn.prepareStatement("SELECT * FROM buscarCompra('"+String.valueOf(sdf.format(date))+"')");
        pps.execute();
        ResultSet rs = pps.getResultSet();
        while(rs.next()){
                String []info = new String[3];
                info[0] = rs.getString("id_compra");
                info[1] = rs.getString("id_proveedor");
                info[2] = rs.getString("fecha");
                compras.addRow(info);
        }

} catch (Exception e){
            System.out.println("error");
}
    }
    
     public void eliminarCompra(){
        int fila = this.tblCompras.getSelectedRow();
        String valor = this.tblCompras.getValueAt(fila, 0).toString();
        try{    
            PreparedStatement ps = cn.prepareStatement("DELETE FROM Compras WHERE id_compra = '"+valor+"'");
            ps.execute();
            
            compras.removeRow(fila);
        }catch(Exception e){
            System.out.println("error");
        }
    }
     
     public void registrarProveedor(){
         try{
         PreparedStatement pps = cn.prepareStatement("INSERT INTO Proveedores VALUES(?,?)");
         pps.setString(1, this.txtIDProveedor.getText());
         pps.setString(2, this.txtNombreProveedor.getText());
         pps.execute();
         }catch(Exception e){
             System.out.println("Error");
         }
     }
     
    
     public void buscarProveedor(){
         try{
        for(int i = proveedores.getRowCount()-1; i>=0; i--){
            proveedores.removeRow(i);
        }
             
         PreparedStatement pps = cn.prepareStatement("SELECT * FROM buscarProveedor('"+this.txtNombreProveedor.getText()+"')");
         pps.execute();
         ResultSet rs = pps.getResultSet();
         while(rs.next()){
             String []info = new String[2];    
             info[0] = rs.getString("id_proveedor");
             info[1] = rs.getString("nombre");
             proveedores.addRow(info);
         }
         }catch(Exception e){
             System.out.println("Error");
         }
     }
     
     public void actualizarProveedor(){
         try{
         PreparedStatement pps = cn.prepareStatement("CALL actualizarProveedor(?,?)");
         pps.setString(1, (String) this.tblProveedores.getValueAt(this.tblProveedores.getSelectedRow(), 0));
         pps.setString(2, (String) this.tblProveedores.getValueAt(this.tblProveedores.getSelectedRow(), 1));
         pps.execute();
         }catch(Exception e){
             System.out.println("error");
         }
     }
     
     private void validarUsuario(){
         // 1=Venta,2=Ventas,3=Compra,4=Compras,5=Inventario,6=Reportes, 7=Proveedores
         if(!this.usuario.equals("PRUEBA123")){
             this.jTabbedPane1.setEnabledAt(2, false);
             this.jTabbedPane1.setEnabledAt(4, false);
             this.jTabbedPane1.setEnabledAt(6, false);
             this.jTabbedPane1.setEnabledAt(7, false);
         }
             
     }
     
     private void mostrarUsuario(){
         try{
             PreparedStatement ps = cn.prepareStatement("SELECT nombre, apellido_paterno, apellido_materno FROM Vendedores WHERE id_vendedor = '"+this.usuario+"'");
             ps.execute();
             ResultSet rs = ps.getResultSet();
             rs.next();
             this.lblUsuario.setText("Usuario: "+rs.getString("nombre")+" "+rs.getString("apellido_paterno")+" "+rs.getString("apellido_materno"));
         } catch(Exception e){
             System.out.println("Error");
         }
     }
     
     private void actualizarAutoCompleterProductos(){
         try{
             ac.removeAllItems();
             ac2.removeAllItems();
         PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM Productos");
         ps.execute();
         ResultSet rs = ps.getResultSet();
         while(rs.next()){
             ac.addItem(rs.getString("nombre"));
             ac2.addItem(rs.getString("nombre"));
         }
         }catch(Exception e){
             System.out.println("error");
         }
     }
     
     private void actualizarAutoCompleterProveedores(){
         try{
             ac3.removeAllItems();
             PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM Proveedores");
             ps.execute();
             ResultSet rs = ps.getResultSet();
             while(rs.next()){
              ac3.addItem(rs.getString("nombre"));
             }
         }catch(Exception e){
             
         }
     }
     
     private void calcularTotalCompra(){
         int fila = this.tblDetalleXCompra.getRowCount()-1;
         String valor = this.tblDetalleXCompra.getValueAt(fila, 4).toString();
         float compra = Float.parseFloat(valor);
         this.totalCompra += compra;
         
     }
     
      private void calcularTotalVenta(){
         int fila = this.tblDetalleXVenta.getRowCount()-1;
         String valor = this.tblDetalleXVenta.getValueAt(fila, 3).toString();
         float venta = Float.parseFloat(valor);
         this.totalVenta += venta;
         
     }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnActualizarProveedor;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAgregarProductoCompra;
    private javax.swing.JButton btnAltaProducto;
    private javax.swing.JButton btnBuscarCompra;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnBuscarVenta;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnEliminarCompra;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMejorProveedor;
    private javax.swing.JButton btnMejorVendedor;
    private javax.swing.JButton btnProductoMasVendido;
    private javax.swing.JButton btnRegistrarCompra;
    private javax.swing.JButton btnRegistrarProveedor;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnVentas;
    private com.toedter.calendar.JDateChooser dateCompra;
    private com.toedter.calendar.JDateChooser dateVenta;
    private javax.swing.JLabel imgApagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTable tblDetalleXCompra;
    private javax.swing.JTable tblDetalleXVenta;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtCantidadCompra;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCategoriaProducto;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtIDCompra;
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtIDProveedor;
    private javax.swing.JTextField txtIDVenta;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProductoVenta;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtProductoCompra;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtStockProducto;
    private javax.swing.JTextField txtTotalCompra;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
