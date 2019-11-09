/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkStore;

import Objects.IngresoStock;
import Objects.ItemProductoVO;
import Objects.ProductoVO;
import Objects.SalioStock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class HulkStoreEJB  extends AbstractFacade{
    
    @PersistenceContext(unitName = "SopDS_jndi")
    private EntityManager em;
    @Override
    
    protected EntityManager getEntityManager() {
      return em;
    }
    
    public List<ItemProductoVO> getProducts(){
        List<ItemProductoVO> list = new ArrayList<>();
        try {
            String sql="SELECT pr.codProducto, pr.nombre, pr.precio, SUM(ingr.cantidad) as stock, "
                    + "SUM(sld.cantidad) as venta from producto pr "
                    + "inner join salidaproductos sld on pr.codProducto=sld.productoFK"
                    + " inner join ingresoproductos ingr on ingr.producto_fk=pr.codProducto";
         
            Query query= em.createNativeQuery(sql);
            List<Object[]> resultados=query.getResultList();
            if(resultados.size() >0){
                for(Object[] res : resultados){
                    ItemProductoVO item = new ItemProductoVO();
                    item.setId(Integer.parseInt(res[0].toString()));
                    item.setNombre(res[1].toString());
                    item.setPrecio(Integer.parseInt(res[2].toString()));
                    item.setStock(Integer.parseInt(res[3].toString()));
                    item.setVenta(Integer.parseInt(res[4].toString()));
                    list.add(item);                   
                }
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Error al consultar itemProductos " + e.getMessage());
        }
        return list;
    }
    
    public int getStock(int idProducto){
       int res=0;
        try {
            String sql="select SUM(cantidad) from ingresoproductos where codProducto = :cod";
            Query query = em.createNativeQuery(sql);
            query.setParameter("cod", idProducto);
            
            res=Integer.parseInt(query.getSingleResult().toString());
            
        } catch (NumberFormatException e) {
            System.out.println("Error al consultar stock " + e.getMessage());
        }
        return res;
    }
    
    public void guardarProducto(ProductoVO producto){
        em.merge(producto);
    }
    
    public void guardarStock(IngresoStock ingresoStock){
        em.merge(ingresoStock);
    }
        
     public void guardarSalidaStock(ItemProductoVO salioStock){
         SalioStock neValues = new SalioStock();
         Date date = new Date();
         
         neValues.setCodProd(salioStock.getId());
         neValues.setFecha(date);
         neValues.setCantidad(salioStock.getVenta());
         
        em.merge(neValues);
    }
    
}
