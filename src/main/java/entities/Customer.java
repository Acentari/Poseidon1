package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name="customer_phone")
    private String phone;

    @Column(name="customer_name")
    private String name;

    @Column(name="customer_lname")
    private String lname;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="customer")
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLname() {
        return lname;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
