package hanoi;

public class Menu extends javax.swing.JFrame {

    public Menu() {

        setLookAndFeel();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hanoiSolutionerButton = new javax.swing.JButton();
        hanoiInteractiveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hanoiSolutionerButton.setText("Automático");
        hanoiSolutionerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hanoiSolutionerButtonActionPerformed(evt);
            }
        });

        hanoiInteractiveButton.setText("Interactivo");
        hanoiInteractiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hanoiInteractiveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hanoiSolutionerButton)
                    .addComponent(hanoiInteractiveButton))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(hanoiSolutionerButton)
                .addGap(53, 53, 53)
                .addComponent(hanoiInteractiveButton)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void hanoiSolutionerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hanoiSolutionerButtonActionPerformed

    dispose();
    new MainFrame().setVisible(true);
}//GEN-LAST:event_hanoiSolutionerButtonActionPerformed

private void hanoiInteractiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hanoiInteractiveButtonActionPerformed

    // dispose();
    // new MainFrame().setVisible(true);
}//GEN-LAST:event_hanoiInteractiveButtonActionPerformed

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
    // End of variables declaration//GEN-END:variables
}
