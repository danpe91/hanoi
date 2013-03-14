package hanoi;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Puntuaciones extends javax.swing.JFrame {

    public Puntuaciones() {

        setLookAndFeel();
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        topMovimientosPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movimientosTable = new javax.swing.JTable();
        numeroDiscosComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        topTiempoPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tiemposTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        numeroDiscosTiempoComboBox = new javax.swing.JComboBox();
        acceptTiempoButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        movimientosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Posición", "Nombre", "Movimientos", "Tiempo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(movimientosTable);

        numeroDiscosComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6" }));

        jLabel1.setText("Número de discos");

        acceptButton.setMnemonic('a');
        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        jButton2.setMnemonic('s');
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topMovimientosPanelLayout = new javax.swing.GroupLayout(topMovimientosPanel);
        topMovimientosPanel.setLayout(topMovimientosPanelLayout);
        topMovimientosPanelLayout.setHorizontalGroup(
            topMovimientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topMovimientosPanelLayout.createSequentialGroup()
                .addGroup(topMovimientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topMovimientosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(topMovimientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(numeroDiscosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acceptButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topMovimientosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topMovimientosPanelLayout.setVerticalGroup(
            topMovimientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topMovimientosPanelLayout.createSequentialGroup()
                .addGroup(topMovimientosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topMovimientosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topMovimientosPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroDiscosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(acceptButton)
                        .addGap(91, 91, 91)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Mejores movimientos", topMovimientosPanel);

        tiemposTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Posición", "Usuario", "Movimientos", "Tiempo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tiemposTable);

        jLabel2.setText("Número de discos");

        numeroDiscosTiempoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6" }));

        acceptTiempoButton.setMnemonic('a');
        acceptTiempoButton.setText("Aceptar");
        acceptTiempoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptTiempoButtonActionPerformed(evt);
            }
        });

        jButton1.setMnemonic('s');
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topTiempoPanelLayout = new javax.swing.GroupLayout(topTiempoPanel);
        topTiempoPanel.setLayout(topTiempoPanelLayout);
        topTiempoPanelLayout.setHorizontalGroup(
            topTiempoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topTiempoPanelLayout.createSequentialGroup()
                .addGroup(topTiempoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topTiempoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(topTiempoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(topTiempoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(numeroDiscosTiempoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(acceptTiempoButton)))
                    .addGroup(topTiempoPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topTiempoPanelLayout.setVerticalGroup(
            topTiempoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topTiempoPanelLayout.createSequentialGroup()
                .addGroup(topTiempoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topTiempoPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroDiscosTiempoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(acceptTiempoButton)
                        .addGap(85, 85, 85)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topTiempoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Mejores tiempos", topTiempoPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed

    int numerDeDiscosDeseado = Integer.parseInt(numeroDiscosComboBox.getSelectedItem().toString());
    java.util.List<Puntaje> lista;
    lista = ScoresIO.leer(numerDeDiscosDeseado, true);
    
    llenarTabla(lista, movimientosTable);
}//GEN-LAST:event_acceptButtonActionPerformed

private void acceptTiempoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptTiempoButtonActionPerformed

    int numerDeDiscosDeseado = Integer.parseInt(numeroDiscosTiempoComboBox.getSelectedItem().toString());
    java.util.List<Puntaje> lista;
    lista = ScoresIO.leer(numerDeDiscosDeseado, false);
    
    llenarTabla(lista, tiemposTable);
}//GEN-LAST:event_acceptTiempoButtonActionPerformed

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    new Menu().setVisible(true);
}//GEN-LAST:event_formWindowClosed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    dispose();
}//GEN-LAST:event_jButton1ActionPerformed

    private void llenarTabla(java.util.List<Puntaje> products, javax.swing.JTable table) {


        DefaultTableModel currentModel =
                (DefaultTableModel) table.getModel();

        currentModel.getDataVector().removeAllElements();

        int posicion = 0;
        for (Puntaje product : products) {
            Object[] row = {
                ++posicion,
                product.getNombre(),
                product.getMovimientos(),
                product.getTiempo()
            };

            currentModel.addRow(row);

        }

        for (int i = 0; i < table.getColumnCount(); i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            table.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }

        if (products.isEmpty()) {
            Object[] row = {null, null, null, null};
            currentModel.addRow(row);
            currentModel.removeRow(0);
        }

    }

    private void setLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton acceptTiempoButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JTable movimientosTable;
    private javax.swing.JComboBox numeroDiscosComboBox;
    private javax.swing.JComboBox numeroDiscosTiempoComboBox;
    private javax.swing.JTable tiemposTable;
    private javax.swing.JPanel topMovimientosPanel;
    private javax.swing.JPanel topTiempoPanel;
    // End of variables declaration//GEN-END:variables
}
