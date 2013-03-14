package hanoi;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        
        super("Menu");
        
        setLookAndFeel();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hanoiSolutionerButton = new javax.swing.JButton();
        hanoiInteractiveButton = new javax.swing.JButton();
        puntajeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hanoiSolutionerButton.setMnemonic('a');
        hanoiSolutionerButton.setText("Automático");
        hanoiSolutionerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hanoiSolutionerButtonActionPerformed(evt);
            }
        });

        hanoiInteractiveButton.setMnemonic('i');
        hanoiInteractiveButton.setText("Interactivo");
        hanoiInteractiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hanoiInteractiveButtonActionPerformed(evt);
            }
        });

        puntajeButton.setMnemonic('p');
        puntajeButton.setText("Puntuaciones");
        puntajeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntajeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hanoiInteractiveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(puntajeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hanoiSolutionerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(hanoiSolutionerButton)
                .addGap(18, 18, 18)
                .addComponent(hanoiInteractiveButton)
                .addGap(18, 18, 18)
                .addComponent(puntajeButton)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void hanoiSolutionerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hanoiSolutionerButtonActionPerformed

    dispose();
    new MainFrame(MainFrame.SOLUTIONER_MODE).setVisible(true);
}//GEN-LAST:event_hanoiSolutionerButtonActionPerformed

private void hanoiInteractiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hanoiInteractiveButtonActionPerformed

    dispose();
    new MainFrame(MainFrame.INTERACTIVE_MODE).setVisible(true);
}//GEN-LAST:event_hanoiInteractiveButtonActionPerformed

private void puntajeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntajeButtonActionPerformed

    dispose();
    new Puntuaciones().setVisible(true);
}//GEN-LAST:event_puntajeButtonActionPerformed

    private void setLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hanoiInteractiveButton;
    private javax.swing.JButton hanoiSolutionerButton;
    private javax.swing.JButton puntajeButton;
    // End of variables declaration//GEN-END:variables
}
