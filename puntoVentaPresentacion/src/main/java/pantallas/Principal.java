
package pantallas;

import javax.swing.ImageIcon;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        registrarVentaBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        gestionProductosBtn = new javax.swing.JButton();
        generarReporteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abarrotes Esmeralda");
        setIconImage(new ImageIcon(getClass().getResource("/iconos/esmeralda128.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Abarrotes Esmeralda");

        registrarVentaBtn.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        registrarVentaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/venta32.png"))); // NOI18N
        registrarVentaBtn.setText("Registrar Venta");
        registrarVentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarVentaBtnActionPerformed(evt);
            }
        });

        salirBtn.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        salirBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cruz32.png"))); // NOI18N
        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esmeralda32.png"))); // NOI18N

        gestionProductosBtn.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gestionProductosBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/producto.png"))); // NOI18N
        gestionProductosBtn.setText("Productos");
        gestionProductosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionProductosBtnActionPerformed(evt);
            }
        });

        generarReporteBtn.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        generarReporteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/documento32.png"))); // NOI18N
        generarReporteBtn.setText("Generar Reporte");
        generarReporteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(salirBtn))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(registrarVentaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gestionProductosBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generarReporteBtn)))))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(registrarVentaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gestionProductosBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generarReporteBtn)
                .addGap(18, 18, 18)
                .addComponent(salirBtn)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registrarVentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarVentaBtnActionPerformed
        new RegistrarVenta().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registrarVentaBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirBtnActionPerformed

    private void gestionProductosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionProductosBtnActionPerformed
        // TODO add your handling code here:
        new ProductosForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gestionProductosBtnActionPerformed

    private void generarReporteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteBtnActionPerformed
        // TODO add your handling code here:
        new ReporteVenta().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_generarReporteBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generarReporteBtn;
    private javax.swing.JButton gestionProductosBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton registrarVentaBtn;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
}
