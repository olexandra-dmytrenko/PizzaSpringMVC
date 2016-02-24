package ua.rd.deliveryservice.service;

import ua.rd.deliveryservice.domain.Pizza;

/**
 *
 * @author andrii
 */
public interface PizzaService {

    Pizza find(Integer id);
    Pizza save(Pizza pizza);
}
