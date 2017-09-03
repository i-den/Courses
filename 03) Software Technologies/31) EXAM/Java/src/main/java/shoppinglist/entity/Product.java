package shoppinglist.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    public Product() {
    }

    public Product(int priority, String name, int quantity, String status) {
        this.priority = priority;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
