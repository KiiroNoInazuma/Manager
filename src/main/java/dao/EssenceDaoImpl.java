package dao;

import jakarta.persistence.*;

public class EssenceDaoImpl<T> implements EssenceDAO<T> {
    private final EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("mySession");
    private final EntityManager entityManager = entityFactory.createEntityManager();


    @Override
    public void add(T essence) {
        entityManager.getTransaction().begin();
        entityManager.persist(essence);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityFactory.close();
    }


    @Override
    public T getId(Class<T> essence, int id) {
        entityManager.getTransaction().begin();
        return entityManager.find(essence, id);
    }

    @Override
    public void all() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from City");
        for (Object o : query.getResultList()) {
            System.out.println(o);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityFactory.close();
    }

    @Override
    public void mod(T essence) {
        entityManager.merge(essence);
        entityManager.getTransaction().commit();

    }

    @Override
    public void remove(T essence) {
        entityManager.remove(essence);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityFactory.close();
    }
}
