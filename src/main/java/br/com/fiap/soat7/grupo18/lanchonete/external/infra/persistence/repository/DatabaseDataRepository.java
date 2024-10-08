package br.com.fiap.soat7.grupo18.lanchonete.external.infra.persistence.repository;

import br.com.fiap.soat7.grupo18.lanchonete.config.DatabaseConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;

public abstract class DatabaseDataRepository implements DataRepository {

    @PersistenceContext(unitName = DatabaseConfig.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected CriteriaBuilder getCriteriaBuilder(){
        return getEntityManager().getCriteriaBuilder();
    }
}
