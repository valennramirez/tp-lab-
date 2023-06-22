package ModelsFactura;

import ModelsProducto.Producto;
import ModelsProducto.ProductoInformatico;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Factura implements Comparable, Serializable {
    private String fecha;
    private ArrayList<Producto> producto; //recibe producto-marca-modelo concatenado en un string
    private String marca;
    private String modelo;
    private double precio;
    private String apellido;
    private String nombre;
    private String email;
    private String tipoDePago;



    public Factura(ArrayList<Producto> producto,String apellido,String nombre, String email, String tipoDePago){
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.fecha= dtf.format(LocalDateTime.now());
        for (Producto p : producto)
        {
            Producto aux = null;
            aux.setTipoProducto(p.getTipoProducto());
            aux.setMarca(p.getMarca());
            aux.setModelo(p.getModelo());
            aux.setPrecio(p.getPrecio());
            this.producto.add(aux);
        }
        this.apellido= apellido;
        this.nombre= nombre;
        this.email= email;
        this.tipoDePago= tipoDePago;
    }

    @Override
    public boolean equals(Object o)
    {
        boolean rta= false;
        if (o != null){
            if(o instanceof Factura){
                Factura aux = (Factura) o;
                if(aux.getFecha().equals(String.valueOf(fecha))){
                    rta= true;
                }
            }
        }
        return rta;
    }




    @Override
    public int hashCode() {
            return 1;
        }

    @Override
    public String toString() {
        return "Factura{" +
                "Fecha='" + fecha + '\'' +
                ", Producto='" + producto + "-" + marca +"-"+ modelo + '\'' +
                ", Precio=$" + precio +
                ", Cliente='" + apellido +"-"+ nombre + "(" + email + ")" + '\'' +
                ", Tipo De Pago='" + tipoDePago + '\'' +
                '}'+ "\n" ;
    }




    public String getFecha() {
            return fecha;
        }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public double getPrecio() {
            return precio;
        }
    public void setPrecio(double precio) {
            this.precio = precio;
        }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoDePago() {
        return tipoDePago;
    }
    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public String getEmail() {
            return email;
        }
    public void setEmail(String email) {
            this.email = email;
        }


    @Override
    public int compareTo(Object o) {
        int rta=0;
        if (o != null){
            if(o instanceof Factura){
                Factura aux= (Factura) o;
                rta= fecha.compareTo(aux.getFecha());
            }
        }
        return rta;
    }




}

