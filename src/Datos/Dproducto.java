package Datos;


public class Dproducto {

    private long cod_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private long precio_producto;
    private int stock_producto;
    private long precio_compra;

   

    public Dproducto() {
    }

    public Dproducto(long cod_producto, String nombre_producto, String descripcion_producto,  long precio_producto, int stock_producto, long precio_compra) {
        this.cod_producto = cod_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.stock_producto = stock_producto;
        this.precio_compra = precio_compra;
        
    }

  

 

    public long getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(long cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }


    public long getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(long precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }

    public long getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(long precio_compra) {
        this.precio_compra = precio_compra;
    }


   
  

}
