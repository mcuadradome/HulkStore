/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hulkStore;

/**
 *
 * @author Miguel
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AbstractFacade<T> {
    
    private Class<T> entityManager;
            
    public AbstractFacade(){
        
    }  
    
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity){
        getEntityManager().merge(entity);
    }
    
    public void edit(T entity){
       getEntityManager().merge(entity);
    }
    
    public void remove(T entity){
       getEntityManager().remove(entity);
    }
      
    public T find(Object id){
      return getEntityManager().find(entityManager, id);
    }
        
    public List<T> findAll(){
       javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
       cq.select(cq.from(entityManager));
       return getEntityManager().createQuery(cq).getResultList();
    }
    
    
        
      
    
}
