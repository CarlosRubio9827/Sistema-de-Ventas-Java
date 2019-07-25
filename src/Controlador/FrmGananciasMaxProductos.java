package Controlador;

import Datos.Dcategoria;
import Funciones.Fcategoria;
import Funciones.Fproducto;

import java.awt.Component;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
//import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class FrmGananciasMaxProductos extends javax.swing.JInternalFrame {
    
    public FrmGananciasMaxProductos() {
        initComponents();
Fproducto f = new Fproducto();


totalInv.setText(f.totalInversion());
totalGan.setText(f.totalGanancia());
totalTienda.setText(f.totalTienda());
totalStock.setText(f.totalStock());
       

mostrar();
        
        jTabla.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                //l.setBorder(new LineBorder(Color.black, 1));
                l.setBackground(new java.awt.Color(36, 33, 33));
                
                l.setForeground(new java.awt.Color(25, 118, 210));
                l.setFont(new java.awt.Font("Arial", 1, 12));
                return l;
            }
        });
        
    }
    
    public void ocultar_columnas() {
        jTabla.getColumnModel().getColumn(0).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(0).setMinWidth(0);
        jTabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
   
    public void mostrar() {
        try {
            DefaultTableModel modelo;
            Fproducto funcion = new Fproducto();
            modelo = funcion.mostrar2();
            jTabla.setModel(modelo);
            ocultar_columnas();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalInv = new javax.swing.JLabel();
        totalGan = new javax.swing.JLabel();
        totalTienda = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalStock = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(36, 33, 33));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(36, 33, 33));

        jTabla.setBackground(new java.awt.Color(36, 33, 33));
        jTabla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabla.setForeground(new java.awt.Color(207, 207, 207));
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTabla.setOpaque(true);
        jTabla.setRowHeight(20);
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabla);

        jLabel5.setBackground(new java.awt.Color(245, 245, 245));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(207, 207, 207));
        jLabel5.setText("Total inversion:");

        jLabel6.setBackground(new java.awt.Color(245, 245, 245));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(207, 207, 207));
        jLabel6.setText("Total ganancia:");

        jLabel7.setBackground(new java.awt.Color(245, 245, 245));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(207, 207, 207));
        jLabel7.setText("Total Tienda:");

        totalInv.setBackground(new java.awt.Color(245, 245, 245));
        totalInv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalInv.setForeground(new java.awt.Color(207, 207, 207));
        totalInv.setText("0");

        totalGan.setBackground(new java.awt.Color(245, 245, 245));
        totalGan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalGan.setForeground(new java.awt.Color(207, 207, 207));
        totalGan.setText("0");

        totalTienda.setBackground(new java.awt.Color(245, 245, 245));
        totalTienda.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalTienda.setForeground(new java.awt.Color(207, 207, 207));
        totalTienda.setText("0");

        jLabel8.setBackground(new java.awt.Color(245, 245, 245));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(207, 207, 207));
        jLabel8.setText("Total stock:");

        totalStock.setBackground(new java.awt.Color(245, 245, 245));
        totalStock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalStock.setForeground(new java.awt.Color(207, 207, 207));
        totalStock.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalTienda)
                                    .addComponent(totalGan)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(totalInv)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(totalStock)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalInv)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(totalStock)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalGan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalTienda))
                .addContainerGap())
        );

        jLabel4.setBackground(new java.awt.Color(245, 245, 245));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(207, 207, 207));
        jLabel4.setText("Ganancias Maximas Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(186, 186, 186))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked
        
        
      
        
        int fila = jTabla.rowAtPoint(evt.getPoint());
      
       

    }//GEN-LAST:event_jTablaMouseClicked
    
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
            java.util.logging.Logger.getLogger(FrmGananciasMaxProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGananciasMaxProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGananciasMaxProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGananciasMaxProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FrmGananciasMaxProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JLabel totalGan;
    private javax.swing.JLabel totalInv;
    private javax.swing.JLabel totalStock;
    private javax.swing.JLabel totalTienda;
    // End of variables declaration//GEN-END:variables

}
