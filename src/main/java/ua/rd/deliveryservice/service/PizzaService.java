package ua.rd.deliveryservice.service;

import ua.rd.deliveryservice.domain.Pizza;

import java.util.List;

/**
 *
 * @author andrii
 */
public interface PizzaService {

    Pizza find(Integer id);
    Pizza save(Pizza pizza);

    List<Pizza> findAll();
}
