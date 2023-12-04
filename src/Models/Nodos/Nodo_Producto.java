package Models.Nodos;

import java.time.LocalDateTime;

public class Nodo_Producto {

    private LocalDateTime fechaCompra;
    private int id;
    private String marca;
    private String tipo;
    private long precio;
    private String genero;
    private String talla;
    private String comprador;
    private String url_Imag;

    public Nodo_Producto() {
        fechaCompra = null;
        id = 0;
        marca = "";
        tipo = "";
        precio = 0;
        genero = "";
        talla = "";
        comprador = "";
        url_Imag = "";
    }

    public Nodo_Producto(int id, String marca, String tipo, long precio, String genero, String talla,String url_Imag) {
        this.id = id;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.genero = genero;
        this.talla = talla;
        this.url_Imag = url_Imag;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getUrl_Imag() {
        return url_Imag;
    }

    public void setUrl_Imag(String url_Imag) {
        this.url_Imag = url_Imag;
    }
    
}
