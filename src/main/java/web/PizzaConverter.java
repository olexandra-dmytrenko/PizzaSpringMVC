package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ua.rd.deliveryservice.domain.Pizza;
import ua.rd.deliveryservice.service.PizzaService;

/**
 * Created by Oleksandra_Dmytrenko on 2/26/2016.
 */
public class PizzaConverter implements Converter<String, Pizza> {
    @Autowired
    PizzaService pizzaService;

    @Override
    public Pizza convert(String pizzaId) {
        if (pizzaId == null || pizzaId.isEmpty()) {
            return new Pizza();
        } else if (Integer.valueOf(pizzaId) <= 0) {
            throw new IllegalArgumentException();
        } else {
            return pizzaService.find(Integer.valueOf(pizzaId));
        }
    }

}
