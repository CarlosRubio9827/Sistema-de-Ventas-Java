package Controlador;

import Datos.Dcategoria;
import Funciones.Fcategoria;

import java.awt.Component;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
//import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class FrmCalcular extends javax.swing.JInternalFrame {
    
    public FrmCalcular() {
        
        initComponents();
        txtPorcentaje.setText("");
        txtPrecioProducto.setText("");
        jLabelValorGanacia.hide();
        jLabelValorProducto.hide();
        
    }
    
   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelValorGanacia = new javax.swing.JLabel();
        jLabelValorProducto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(36, 33, 33));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(36, 33, 33));

        jPanel3.setBackground(new java.awt.Color(36, 33, 33));

        txtPorcentaje.setBackground(new java.awt.Color(36, 33, 33));
        txtPorcentaje.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPorcentaje.setForeground(new java.awt.Color(207, 207, 207));
        txtPorcentaje.setText(" ");
        txtPorcentaje.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtPorcentaje.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPorcentaje.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentajeActionPerformed(evt);
            }
        });
        txtPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(207, 207, 207));
        jLabel3.setText("Porcentaje:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(207, 207, 207));
        jLabel2.setText("Precio Producto:");

        txtPrecioProducto.setBackground(new java.awt.Color(36, 33, 33));
        txtPrecioProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecioProducto.setForeground(new java.awt.Color(207, 207, 207));
        txtPrecioProducto.setText(" ");
        txtPrecioProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtPrecioProducto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPrecioProducto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });
        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(207, 207, 207));
        jLabel5.setText("%");

        jPanel4.setBackground(new java.awt.Color(36, 33, 33));

        btnCalcular.setBackground(new java.awt.Color(36, 33, 33));
        btnCalcular.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(224, 224, 224));
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/StockProd.png"))); // NOI18N
        btnCalcular.setText("CALCULAR VALOR");
        btnCalcular.setToolTipText("");
        btnCalcular.setActionCommand("");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnCalcular)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCalcular)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(207, 207, 207));
        jLabel7.setText("Valor Producto:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(207, 207, 207));
        jLabel6.setText("Valor ganancia:");

        jLabelValorGanacia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelValorGanacia.setForeground(new java.awt.Color(207, 207, 207));
        jLabelValorGanacia.setText("Valor ganancia");

        jLabelValorProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelValorProducto.setForeground(new java.awt.Color(207, 207, 207));
        jLabelValorProducto.setText("Valor Producto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelValorGanacia)
                                    .addComponent(jLabelValorProducto))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecioProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPorcentaje)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelValorGanacia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelValorProducto)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(36, 33, 33));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setBackground(new java.awt.Color(245, 245, 245));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(207, 207, 207));
        jLabel4.setText("CALCULAR VALOR GANANCIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(75, 75, 75))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
       
          if (txtPrecioProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un precio");
            txtPrecioProducto.requestFocus();
            return;
        }

        if (txtPorcentaje.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un porcentaje");
            txtPorcentaje.requestFocus();
            return;
        }
        
        if (txtPorcentaje.getText().length() > 2) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un porcentaje menor a 100");
            txtPorcentaje.requestFocus();
            return;
        }
        
        try{
            
            int precioProducto = Integer.parseInt(txtPrecioProducto.getText());
            //int porcentaje = Integer.parseInt(txtPorcentaje.getText());
            String porcentaje2 = "0."+txtPorcentaje.getText();
            float ganancia = + (precioProducto * Float.parseFloat(porcentaje2));
            
            jLabelValorGanacia.show();
            jLabelValorProducto.show();
            jLabelValorGanacia.setText("$ "+ ganancia);
            jLabelValorProducto.setText("$ "+(ganancia + precioProducto));
            
        }catch(NumberFormatException e){
            
            JOptionPane.showMessageDialog(null, "Error "+ e.getMessage());
        
        }    
     
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        txtPrecioProducto.transferFocus();
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    private void txtPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentajeActionPerformed
        txtPorcentaje.transferFocus();
    }//GEN-LAST:event_txtPorcentajeActionPerformed

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
        
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtPrecioProductoKeyTyped

    private void txtPorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyTyped
        
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPorcentajeKeyTyped

    private void txtPorcentajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyPressed

       
       
    }//GEN-LAST:event_txtPorcentajeKeyPressed
    
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
            java.util.logging.Logger.getLogger(FrmCalcular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCalcular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCalcular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCalcular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCalcular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelValorGanacia;
    private javax.swing.JLabel jLabelValorProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtPrecioProducto;
    // End of variables declaration//GEN-END:variables

}
