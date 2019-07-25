package Funciones;

import Datos.Dproducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fproducto {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalRegistros;
     public Integer totalRegistros2;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Descripcion", 
                    "Precio Venta", "Stock",
                    "Precio Compra", 
                    "Categoria"};

        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cod_producto , nombre_producto , descripcion_producto ,  Replace(Format(precio_producto, 0), ',', '.') as precio_producto , stock_producto , Replace(Format(precio_compra, 0), ',', '.') as precio_compra ,(select nombre_categoria from categoria where  cod_categoria =cod_categoriaFK) as nombre_categoria from producto where nombre_producto like '%" + buscar + "%' order by nombre_producto desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_producto");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("descripcion_producto");
                registros[3] = rs.getString("precio_producto");
                registros[4] = rs.getString("stock_producto");
                registros[5] = rs.getString("precio_compra");
                registros[6] = rs.getString("nombre_categoria");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
    
     public DefaultTableModel mostrar2() {

        DefaultTableModel modelo;

        String[] titulos = {"codigo","Nombre", "Descripcion", "Inversion", "Stock Actual" ,"Ganacia","Total"};

        String[] registros = new String[7];
        totalRegistros2 = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL2 = "SELECT "
                + "d.cod_producto, "
                + "d.nombre_producto, "
                + "d.descripcion_producto, "
                + "sum(d.precio_compra*d.stock_producto) as inversion, "
                + "sum(d.stock_producto) as stockActual,"
                + "(sum(d.precio_producto*d.stock_producto - d.precio_compra*d.stock_producto)) as ganancia, "
                + "sum(d.precio_compra*d.stock_producto + d.precio_producto*d.stock_producto - d.precio_compra*d.stock_producto) as total "
                + "FROM producto d GROUP by d.nombre_producto";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL2);

            while (rs.next()) {
            
                registros[0] = rs.getString("cod_producto");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("descripcion_producto");
                registros[3] = rs.getString("inversion");
                registros[4] = rs.getString("stockActual");
                registros[5] = rs.getString("ganancia");
                registros[6] = rs.getString("total");

                System.out.println();
                totalRegistros2 = totalRegistros2 + 1;
                modelo.addRow(registros);
            }

            cn.close();
            return modelo;
        } catch (SQLException e) {
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
    
     
     public String totalStock(){
        try {
            sSQL = "SELECT (sum(d.stock_producto)) as stock FROM producto d";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            rs.next();
            String val = rs.getString("stock");
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
    
    

    public boolean insertar(Dproducto datos,String nombre) {

        sSQL = "insert into producto (cod_producto , nombre_producto,descripcion_producto"
                + ", precio_producto,stock_producto,precio_compra,cod_categoriaFK)"
                + " values (?,?,?,?,?,?,"
                + "(select cod_categoria from categoria where nombre_categoria like '%" + nombre + "%'))";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setLong(1, datos.getCod_producto());
            pst.setString(2, datos.getNombre_producto());
            pst.setString(3, datos.getDescripcion_producto());
            pst.setLong(4, datos.getPrecio_producto());
            pst.setInt(5, datos.getStock_producto());
            pst.setLong(6, datos.getPrecio_compra());
            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {

                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }//cierre funcion

    public boolean editar(Dproducto datos, String nombre) {

        sSQL = "update producto set nombre_producto = ? , descripcion_producto = ?  , precio_producto = ? , stock_producto = ? ,precio_compra= ? , cod_categoriaFK =(select cod_categoria from categoria where nombre_categoria like '%" + nombre + "%' limit 1)   where cod_producto =? ";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getNombre_producto());
            pst.setString(2, datos.getDescripcion_producto());
            pst.setLong(3, datos.getPrecio_producto());
            pst.setInt(4, datos.getStock_producto());
            pst.setLong(5, datos.getPrecio_compra());


            pst.setLong(6, datos.getCod_producto());

            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }//cierre funcion

    public boolean eliminar(Dproducto datos) {
        sSQL = "delete from producto where cod_producto = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setLong(1, datos.getCod_producto());
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

    }//cierre funcion

    /**
     * ***** FUNCION STOCK ****
     */
    public boolean ModificarStockProductos(Dproducto datos) {

        sSQL = "update producto set stock_producto = ? where cod_producto = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getStock_producto());

            pst.setLong(2, datos.getCod_producto());

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

    public DefaultTableModel mostrarPorCodigo(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Descripcion",
                    "Precio Venta", "Stock", "Precio Compra"};

        String[] registros = new String[6];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from producto where cod_producto =" + buscar + " order by cod_producto desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_producto");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("descripcion_producto");
                registros[3] = rs.getString("precio_producto");
                registros[4] = rs.getString("stock_producto");
                registros[5] = rs.getString("precio_compra");


                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public long productoIgual(long codigo) {

        sSQL = "SELECT cod_producto from producto where cod_producto = " + codigo;

        try {
            long cod = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cod = rs.getLong("cod_producto");
            }

            return cod;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }

    public DefaultTableModel mostrarExportar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Codigo", "Nombre ",
                    "Descripcion", 
                    "Precio Venta", "Stock", "Precio Compra"};

        String[] registros = new String[6];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select cod_producto , nombre_producto , descripcion_producto ,  precio_producto , stock_producto ,  precio_compra  from producto where nombre_producto like '%" + buscar + "%' order by cod_producto desc";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("cod_producto");
                registros[1] = rs.getString("nombre_producto");
                registros[2] = rs.getString("descripcion_producto");
                registros[3] = rs.getString("precio_producto");
                registros[4] = rs.getString("stock_producto");
                registros[5] = rs.getString("precio_compra");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public ArrayList<String> llenar_combo() {
        ArrayList<String> lista = new ArrayList<String>();
        sSQL = "select nombre_categoria from categoria";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("nombre_categoria"));
              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

}
