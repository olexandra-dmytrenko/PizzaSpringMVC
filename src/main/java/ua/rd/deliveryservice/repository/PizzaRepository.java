package ua.rd.deliveryservice.repository;

import ua.rd.deliveryservice.domain.Pizza;

import java.util.List;

/**
 *
 * @author andrii
 */
public interface PizzaRepository {

    Pizza find(Integer id);

    Pizza save(Pizza pizza);

    List<Pizza> findAll();
}
