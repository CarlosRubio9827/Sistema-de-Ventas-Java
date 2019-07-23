package Funciones;

import Datos.Dcategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fcategoria {

    private conexion mysql = new conexion(); //Instanciando la clase conexion
    private Connection cn = mysql.conectar();
    private String sSQL = ""; //Sentencia SQL
    private String sSQL2 = "";
    public Integer totalRegistros;
    public Integer totalRegistros2;// Obtener los registros

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"codigo", "Nombre", "descripcion"};

        String[] registros = new String[3];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from categoria where nombre_categoria like '%" + buscar + "%' order by cod_categoria desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_categoria");
                registros[1] = rs.getString("nombre_categoria");
                registros[2] = rs.getString("descripcion_categoria");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }

            cn.close();
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel mostrar2() {

        DefaultTableModel modelo;

        String[] titulos = {"codigo","Nombre", "Descripcion", "Inversion", "Ganacia", "Total"};

        String[] registros = new String[6];
        totalRegistros2 = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL2 = "SELECT "
                + "v.cod_categoria, "
                + "v.nombre_categoria, "
                + "v.descripcion_categoria, "
                + "sum(d.precio_compra*d.stock_producto) as inversion, "
                + "(sum(d.precio_producto*d.stock_producto - d.precio_compra*d.stock_producto)) as ganancia, "
                + "sum(d.precio_compra*d.stock_producto + d.precio_producto*d.stock_producto - d.precio_compra*d.stock_producto) as total "
                + "FROM producto d INNER JOIN categoria v ON v.cod_categoria = d.cod_categoriaFK GROUP by cod_categoriaFK ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL2);

            while (rs.next()) {
            
                registros[0] = rs.getString("cod_categoria");
                registros[1] = rs.getString("nombre_categoria");
                registros[2] = rs.getString("descripcion_categoria");
                registros[3] = rs.getString("inversion");
                registros[4] = rs.getString("ganancia");
                registros[5] = rs.getString("total");

                System.out.println();
                totalRegistros2 = totalRegistros2 + 1;
                modelo.addRow(registros);
                 System.out.println(registros);
            }

            cn.close();
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public String totalInversion(){
        try {
            sSQL = "SELECT SUM(d.precio_compra*d.stock_producto)as precio FROM producto d";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            rs.next();
            String val = rs.getString("precio");
            return val;
        } catch (SQLException ex) {
            Logger.getLogger(Fcategoria.class.getName()).log(Level.SEVERE, null, ex);
            return ("error" + ex.getMessage());
        }
    }
    
     public String totalGanancia(){
        try {
            sSQL = "SELECT (sum(d.precio_producto*d.stock_producto - d.precio_compra*d.stock_producto)) as ganancia FROM producto d";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            rs.next();
            String val = rs.getString("ganancia");
            return val;
        } catch (SQLException ex) {
            Logger.getLogger(Fcategoria.class.getName()).log(Level.SEVERE, null, ex);
            return ("error" + ex.getMessage());
        }
    }
    
     
     
       public String totalTienda(){
        try {
            sSQL = "SELECT sum(d.precio_compra*d.stock_producto + d.precio_producto*d.stock_producto - d.precio_compra*d.stock_producto) as total FROM producto d";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            rs.next();
            String val = rs.getString("total");
            return val;
        } catch (SQLException ex) {
            Logger.getLogger(Fcategoria.class.getName()).log(Level.SEVERE, null, ex);
            return ("error" + ex.getMessage());
        }
    }
    
    
    
    public boolean insertar(Dcategoria datos) {

        sSQL = "insert into categoria (nombre_categoria,descripcion_categoria) values (?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getNombre_categoria());
            pst.setString(2, datos.getDescripcion_categoria());

            int N = pst.executeUpdate();

            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }/*CIERRE FUNCION INSERTAR*/


    public boolean editar(Dcategoria datos) {

        sSQL = "update categoria set nombre_categoria = ?,descripcion_categoria = ? where cod_categoria = ? ";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getNombre_categoria());
            pst.setString(2, datos.getDescripcion_categoria());
            pst.setInt(3, datos.getCod_categoria());

            int N = pst.executeUpdate();

            if (N != 0) {

                return true;

            } else {

                return false;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }/*CIERRE FUNCION EDITAR*/


    public boolean eliminar(Dcategoria datos) {

        sSQL = "delete from categoria where cod_categoria = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getCod_categoria());

            int N = pst.executeUpdate();

            if (N != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

}
