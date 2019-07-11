package com.siteware.ecommerce.dao.sale;

import com.siteware.ecommerce.pojo.sale.Sale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Class responsible for communicating the system
 * with the persistance context of the application.
 *
 * @author Antunes Dantas
 */
@Transactional(Transactional.TxType.MANDATORY)
public class SaleDAO {

    private static final String GET_SALE_BY_ID = new StringBuilder()
            .append("FROM Sale sale WHERE sale.id = :id").toString();

    private static final String DELETE_SALE_BY_ID = new StringBuilder()
            .append("DELETE FROM Sale sale WHERE sale.id = :id").toString();

    private static final String GET_ALL_SALES = new StringBuilder()
            .append("FROM Sale").toString();

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a single Sale with the provided Id.
     *
     * @param id Id of the requested Sale.
     *
     * @return The requested Sale.
     */
    public Sale findSaleById(Long id) {
        TypedQuery<Sale> query = getEntityManager()
                .createQuery(GET_SALE_BY_ID, Sale.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    /**
     * Retrieves all the Sales persisted.
     *
     * @return A List with all the Sales saved on the system.
     */
    public List<Sale> findAllSales() {
        TypedQuery<Sale> query = getEntityManager()
                .createQuery(GET_ALL_SALES, Sale.class);

        return query.getResultList();
    }

    /**
     * Persist a sigle Sale on the database.
     *
     * @param sale The Sale to be persisted.
     */
    public void persistSale(Sale sale) {
        getEntityManager().persist(sale);
    }

    /**
     * Updates an existing Sale on the database.
     *
     * @param sale The Sale with the new values.
     *
     * @return The updated Sale.
     */
    public Sale updateSale(Sale sale) {
        return getEntityManager().merge(sale);
    }

    /**
     * Deletes a Sale from the database.
     *
     * @param id The id of the Sale which will be removed.
     */
    public void deleteSale(Long id) {
        Query query = getEntityManager()
                .createQuery(DELETE_SALE_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
