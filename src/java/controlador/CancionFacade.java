/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Cancion;

/**
 *
 * @author Boris
 */
@Stateless
public class CancionFacade extends AbstractFacade<Cancion> {

    @PersistenceContext(unitName = "SERVIDORJAVAWEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CancionFacade() {
        super(Cancion.class);
    }
    
}
