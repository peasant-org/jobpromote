/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobimprove.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jobimprove.model.exceptions.NonexistentEntityException;

/**
 *
 * @author Administrator
 */
public class StationInfoJpaController implements Serializable {

    public StationInfoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StationInfo stationInfo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(stationInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StationInfo stationInfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            stationInfo = em.merge(stationInfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stationInfo.getStationInfoId();
                if (findStationInfo(id) == null) {
                    throw new NonexistentEntityException("The stationInfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StationInfo stationInfo;
            try {
                stationInfo = em.getReference(StationInfo.class, id);
                stationInfo.getStationInfoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stationInfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(stationInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StationInfo> findStationInfoEntities() {
        return findStationInfoEntities(true, -1, -1);
    }

    public List<StationInfo> findStationInfoEntities(int maxResults, int firstResult) {
        return findStationInfoEntities(false, maxResults, firstResult);
    }

    private List<StationInfo> findStationInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StationInfo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public StationInfo findStationInfo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StationInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getStationInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StationInfo> rt = cq.from(StationInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
