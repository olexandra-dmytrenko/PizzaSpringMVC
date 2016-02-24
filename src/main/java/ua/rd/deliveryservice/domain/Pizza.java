package ua.rd.deliveryservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andrii
 */
@Entity
@Table(name = "pizzas")
public class Pizza {

    public enum PizzaType {

        VEGETARIAN, SEA, MEAT;

    }

    @Id
    @GeneratedValue(strategy = 
            GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Integer id;
    @Column(name = "pizza_name")
    private String name;
    
    @Enumerated(EnumType.STRING)
    private PizzaType pizzaType;

    public Pizza() {
    }

    public Pizza(Integer id, String name, PizzaType pizzaType) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + ", pizzaType=" + pizzaType + '}';
    }   
    
}
