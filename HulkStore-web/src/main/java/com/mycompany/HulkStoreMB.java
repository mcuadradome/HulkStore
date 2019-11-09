/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import Objects.IngresoStock;
import Objects.ItemProductoVO;
import Objects.ProductoVO;
import com.hulkStore.HulkStoreEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
/**
 *
 * @author Miguel
 */
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

@Named(value = "hulkStoreMB")
@ViewScoped
public class HulkStoreMB implements Serializable {

    @EJB
    HulkStoreEJB hulkStoreEJB;

    public HulkStoreMB() {
    }

    private List<ItemProductoVO> list;
    private String nombreProducto;
    private int precioProducto;

    private String proveedor;
    private int stock;
    private Date fechaIngreso;

    private String cliente;
    private int salidaStock;
    private Date fechaSalida;

    @PostConstruct
    public void init() {
        list = new ArrayList<>();
    }

    public List<ItemProductoVO> getProduct() {
        try {
            list = hulkStoreEJB.getProducts();
        } catch (Exception e) {
        }
        return list;
    }
    
    public void guardarProducto(){
        
        ProductoVO producto = new ProductoVO();
        producto.setNombre(nombreProducto);
        producto.setDescripcion(null);
        producto.setPrecio(precioProducto);
        hulkStoreEJB.guardarProducto(producto);
        
       FacesContext context = FacesContext.getCurrentInstance();        
       context.addMessage(null, new FacesMessage("Correcto",  "Se ha guardado el producto") );
    } 
    
    public void guardarStock(){
        Date feDate = new Date();
     
        IngresoStock producto = new IngresoStock();
        producto.setProvedor(proveedor);
        producto.setCantidad(stock);
        producto.setFecha(feDate);
        hulkStoreEJB.guardarStock(producto);
        
       FacesContext context = FacesContext.getCurrentInstance();        
       context.addMessage(null, new FacesMessage("Correcto",  "Se ha guardado el producto") );
    } 
        
    public void onCellEdit(CellEditEvent event) {    
       
        ItemProductoVO newValue = (ItemProductoVO) event.getNewValue();
        int stock=0; 
        if(newValue != null) {
            stock = hulkStoreEJB.getStock(newValue.getId());
            if(stock >= salidaStock){
             hulkStoreEJB.guardarSalidaStock(newValue);
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion", "Cambio Exitoso " + salidaStock);
             FacesContext.getCurrentInstance().addMessage(null, msg);
            }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion","Edicion no permitida");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            }
           
        }
    }

    public List<ItemProductoVO> getList() {
        return list;
    }

    public void setList(List<ItemProductoVO> list) {
        this.list = list;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getSalidaStock() {
        return salidaStock;
    }

    public void setSalidaStock(int salidaStock) {
        this.salidaStock = salidaStock;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    

}
