package repos;

import entities.Customer;
import entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersRepo {
    private final EntityManagerFactory emf;
    public UsersRepo() {
        Map<String, Object> props = new HashMap<>();
        props.put("javax.persistence.jdbc.url" , "jdbc:mariadb://localhost:3306/poseidon");
        props.put("javax.persistence.jdbc.user" , "root");
        props.put("javax.persistence.jdbc.password" , "");
        props.put("javax.persistence.jdbc.driver" , "org.mariadb.jdbc.Driver");
        // create an instance of entity manager factory
        this.emf = Persistence.createEntityManagerFactory("jbd-pu", props);
    }

    public Customer findByPhone(String phone) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager
                .createQuery("SELECT c FROM Customer c"
                        + " WHERE c.phone =:phone");
        query.setParameter("phone", phone);

        return (Customer) query.getSingleResult();
    }
    public List<Customer> findAll(){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager
                .createQuery("SELECT c FROM Customer c");

        return  query.getResultList();


    }

}