package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ingresoproductos")
public class IngresoProductos implements Serializable{
    private static final Long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ingreso")
    private int codIngreso;
    
    @Column(name = "proveedor")
    private String proveedor;
     
    @Column(name = "producto_fk")
    private int productoFK;   

    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)  
    private Date fecha;

    public int getCodIngreso() {
        return codIngreso;
    }

    public void setCodIngreso(int codIngreso) {
        this.codIngreso = codIngreso;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }


    public int getProductoFK() {
        return productoFK;
    }

    public void setProductoFK(int productoFK) {
        this.productoFK = productoFK;
    }

  
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}