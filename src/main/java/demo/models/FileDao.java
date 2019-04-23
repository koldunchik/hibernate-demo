package demo.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and
 * configure the DAO wihtout any XML configuration and also provide the Spring
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class FileDao {

    public void create(File file) {
        entityManager.persist(file);
        return;
    }

    /**
     * Delete from the database.
     */
    public void delete(File file) {
        if (entityManager.contains(file))
            entityManager.remove(file);
        else
            entityManager.remove(entityManager.merge(file));
        return;
    }

    /**
     * Return all the files stored in the database.
     */
    @SuppressWarnings("unchecked")
    public List<File> getAll() {
        return entityManager.createQuery("from File").getResultList();
    }

    @PersistenceContext
    private EntityManager entityManager;

}