
package pantallas;

import control.ventasControl;
import entidades.Producto;
import entidades.VentaProducto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RegistrarVenta extends javax.swing.JFrame {
    
    private List<VentaProducto> listaProductos = new ArrayList<>();
    private List<Integer> cantidadProductos = new ArrayList<>();
    private float total;
    
    private ventasControl con = new ventasControl();
    
    public RegistrarVenta() {
        initComponents();
    }
    
    private void actualizarPantalla(){
        DefaultTableModel modeloTabla = (DefaultTableModel)this.tablaProductos.getModel();
        modeloTabla.setRowCount(0);
        total = 0;
        
        for (VentaProducto producto : listaProductos) {
            Object[] fila = new Object[4];
            fila[0] = producto.getProducto().getNombre();
            fila[1] = producto.getCantidad();
            fila[2] = producto.getProducto().getPrecio();
            fila[3] = producto.getMonto();
            modeloTabla.addRow(fila);
            total += producto.getMonto();
        }
        lblTotal.setText("TOTAL = $" + String.valueOf(total));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        panelPrincipal = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        scrollPanel = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnVaciar = new javax.swing.JButton();
        txtCambio = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        volverBtn = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumProducto1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Venta");
        setIconImage(new ImageIcon(getClass().getResource("/iconos/esmeralda128.png")).getImage());

        panelPrincipal.setBackground(new java.awt.Color(102, 153, 255));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanel.setViewportView(tablaProductos);

        btnVaciar.setBackground(new java.awt.Color(255, 51, 51));
        btnVaciar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnVaciar.setForeground(new java.awt.Color(255, 255, 255));
        btnVaciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cruz32.png"))); // NOI18N
        btnVaciar.setText("VACIAR");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });

        txtCambio.setEditable(false);
        txtCambio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCambio.setText(" CAMBIO $0.0");

        totalLabel.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        totalLabel.setText("VENTA");

        txtPago.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Pago:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setText("$");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("No. Producto");

        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/lupa32.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTotal.setText("TOTAL $0.0");

        volverBtn.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        volverBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/inicio32.png"))); // NOI18N
        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCantidad.setText("1");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad");

        btnPagar.setBackground(new java.awt.Color(153, 255, 153));
        btnPagar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/palomita32.png"))); // NOI18N
        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        txtNombreProducto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Nombre del producto");

        txtNumProducto1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNumProducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumProducto1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(scrollPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVaciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalLabel)
                            .addComponent(volverBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombreProducto)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(volverBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 22, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTotal)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        // TODO add your handling code here:
        listaProductos.clear();
        actualizarPantalla();
    }//GEN-LAST:event_btnVaciarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Valida que se añada una cantidad de producto
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad.");
        } else {
            try {
                int cantidad = Integer.parseInt(txtCantidad.getText());

                // Valida que la cantidad sea un número positivo
                if (cantidad <= 0) {
                    txtCantidad.setText("");
                    JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad positiva.");
                    return;
                }

                Producto productoNuevo = null;

                if (!txtNombreProducto.getText().trim().isEmpty()) {
                    productoNuevo = con.buscarProductoPorNombre(txtNombreProducto.getText());

                    if (productoNuevo == null) {
                        JOptionPane.showMessageDialog(this, "El producto " + txtNombreProducto.getText() + " no existe.");
                        return;
                    }
                } else if (!txtNumProducto1.getText().trim().isEmpty()) {
                    productoNuevo = con.buscarProductoPorNumero(txtNumProducto1.getText());

                    if (productoNuevo == null) {
                        JOptionPane.showMessageDialog(this, "El producto con número " + txtNumProducto1.getText() + " no existe.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese el nombre o número del producto.");
                    return;
                }

                if (productoNuevo.getPrecio() <= 0) {
                    JOptionPane.showMessageDialog(this, "El producto " + productoNuevo.getNombre() + " no tiene un precio válido.");
                    return;
                }

                if (cantidad > productoNuevo.getExistencia()) {
                    JOptionPane.showMessageDialog(this, "La cantidad solicitada supera el stock disponible para el producto " + productoNuevo.getNombre() + ". Stock disponible: " + (int)productoNuevo.getExistencia());
                    return;
                }

                listaProductos = con.agregarProductoVenta(productoNuevo.getCodigo(), cantidad);
                actualizarPantalla();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida (número entero).");
            }
        }
            
        actualizarPantalla();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // Valida que el valor sea un dígito
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        //valida que el valor no sea nulo o ""
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        // TODO add your handling code here:
        new Principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // Verifica que haya productos en la lista antes de intentar realizar la venta
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay productos en la lista. Agregue productos antes de realizar la venta.");
            return;
        }

        // Verifica que se haya ingresado un monto de pago
        if (txtPago.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto de pago.");
            return;
        }

        try {
            float montoPago = Float.parseFloat(txtPago.getText());

            // Verifica que el monto de pago sea mayor o igual al total de la venta
            if (montoPago < total) {
                JOptionPane.showMessageDialog(this, "El monto de pago debe ser igual o mayor al total de la venta.");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Deseas realizar la venta?");

            if (confirmacion == JOptionPane.OK_OPTION) {
                boolean ventaRealizada = false;
                try {
                    ventaRealizada = con.realizarVenta(montoPago);
                } catch(PersistenceException e) {
                    JOptionPane.showMessageDialog(this, "Error con la base de datos.");
                }
                
                if(ventaRealizada) {
                    JOptionPane.showMessageDialog(this, "Venta realizada exitosamente");
                    listaProductos.clear();
                    txtPago.setText("");
                    txtCambio.setText(" CAMBIO $0.0");
                    actualizarPantalla();
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha podido realizar la venta.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "La venta fue cancelada");
                listaProductos.clear();
                txtPago.setText("");
                txtCambio.setText(" CAMBIO $0.0");
                actualizarPantalla();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto de pago válido.");
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        // TODO add your handling code here:
        float pago;
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
            pago = Float.parseFloat(txtPago.getText());
        } else {
            pago = Float.parseFloat(txtPago.getText() + evt.getKeyChar());
        }
            float cambio = pago - con.getTotal();
            if (cambio > 0){
                txtCambio.setText(" CAMBIO $" + cambio);
            } else {
                txtCambio.setText(" CAMBIO $0.0");
        }
    }//GEN-LAST:event_txtPagoKeyTyped

    private void txtNumProducto1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumProducto1KeyTyped
       if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
       }
    }//GEN-LAST:event_txtNumProducto1KeyTyped

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNumProducto1;
    private javax.swing.JTextField txtPago;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

}
