package project.entity;

import javax.persistence.*;

@Entity
@Table(name = "entities")
public class Entity {
    public Entity() {
    }

    public Entity(String stringProperty, int intProperty) {
	this.stringProperty = stringProperty;
	this.intProperty = intProperty;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String stringProperty;

    @Column(nullable = false)
    private int intProperty;

    @Column(nullable = false)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(nullable = false)
    public String getStringProperty() {
        return stringProperty;
    }

    public void setStringProperty(String stringProperty) {
        this.stringProperty = stringProperty;
    }
	
    @Column(nullable = false)
    public int getIntProperty() {
        return intProperty;
    }

    public void setIntProperty(int intProperty) {
        this.intProperty = intProperty;
    }
}
