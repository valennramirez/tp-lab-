package ModelsProducto;

import ModelsEnum.TipoProducto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public abstract class Producto implements Serializable
{
    private TipoProducto tipoProducto;
    private String modelo;
    private String marca;
    private double precio;
    private int stock;
    private ArrayList<Comentario> comentariosProducto;
    private String descripcion;
    private int vendidos;
    private int id;
    public static int ultimoId; //aca almaceno el ultimo id de todos los productos. y asi poder acceder a ella al momento de cargar nuevos

    public Producto() {
        this.tipoProducto = null;
        this.modelo = "";
        this.marca = "";
        this.precio = 0;
        this.stock = 0;
        this.comentariosProducto = new ArrayList<>();
        this.descripcion = "";
        this.vendidos = 0;
        this.id = 0;
    }

    public Producto(TipoProducto tipoProducto, String modelo, String marca, double precio, int stock, String descripcion, int vendidos, int id) {
        this.tipoProducto = tipoProducto;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.comentariosProducto = new ArrayList<>();
        this.descripcion = descripcion;
        this.vendidos = vendidos;
        this.id = id;
    }

    public Producto (TipoProducto tipoProducto, String marca, String modelo, double precio)
    {

    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    //se le suma al sotck existente el nuevo stock
    public void setStock(int stock) {
        this.stock += stock;
    }

    public ArrayList<Comentario> getComentariosProducto() {
        return comentariosProducto;
    }

    public void setComentariosProducto(Comentario comentario) {
        this.comentariosProducto.add(comentario);
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVendidos() {
        return vendidos;
    }

    //incrementa la cantidad de vendidos y disminuye el stock
    public void setVendidos(int vendidos) {

        this.vendidos += vendidos;
        stock = stock-vendidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void incrementrarStock()
    {
        stock++;
    }

    public void disminuirStock()
    {
        stock--;
    }


    @Override
    public boolean equals(Object obj)
    {
        boolean rta = false;
        if(obj != null)
        {
            if(obj instanceof Producto)
            {
                Producto aux = (Producto) obj;
                if(modelo.equals(aux.getModelo()) && id == aux.getId())
                {
                    rta = true;
                }
            }
        }
        return rta;
    }

    /**
     * Metodo que recibe 2 string y corrobora si son iguales al producto
     * que se esta analizando
     * @param modelo
     * @param marca
     * @return boolean
     */
    public boolean buscaProducto(String modelo, String marca)
    {
        boolean rta = false;
        if(this.modelo.equalsIgnoreCase(modelo) && this.marca.equalsIgnoreCase(marca))
        {
            rta = true;
        }
        return rta;
    }


    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString()
    {
        return "\nMarca: " + marca +
                "\nModelo " + modelo +
                "\nPrecio: " + precio +
                //"\nCantidad disponible: " + stock +
                "\nDescripcion: "+ descripcion ;
                //"\nID: " + id;

               /* ", comentariosProducto=" + comentariosProducto +
                 */
    }


    public String toStringCatalogo() {
        return "\nMarca: " + marca +
                "\nModelo " + modelo +
                "\nPrecio: " + precio;
    }

}
