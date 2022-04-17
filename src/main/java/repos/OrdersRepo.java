package repos;

import entities.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersRepo {

    private final EntityManagerFactory emf;

    public OrdersRepo() {
        Map<String, Object> props = new HashMap<>();
        props.put("javax.persistence.jdbc.url" , "jdbc:mariadb://localhost:3306/poseidon");
        props.put("javax.persistence.jdbc.user" , "root");
        props.put("javax.persistence.jdbc.password" , "");
        props.put("javax.persistence.jdbc.driver" , "org.mariadb.jdbc.Driver");
        // create an instance of entity manager factory
        this.emf = Persistence.createEntityManagerFactory("jbd-pu", props);
    }


//    public List<Order> getOrders() {
//        EntityManager entityManager = emf.createEntityManager();
//        Query query = entityManager
//                .createQuery("SELECT c FROM Customer c"
//                        + " WHERE c.phone =:phone");
//        query.setParameter("phone", phone);
//    }


}
