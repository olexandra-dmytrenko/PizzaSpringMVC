package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.rd.deliveryservice.domain.Pizza;
import ua.rd.deliveryservice.service.PizzaService;

import java.util.List;

/**
 * Created by Oleksandra_Dmytrenko on 2/24/2016.
 */
@Controller
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute("pizzas", pizzaService.findAll());
        return "pizzas";
    }

    @RequestMapping(value = "/pizza", method = RequestMethod.GET)
    @ResponseBody
    public String viewByID(@RequestParam("id") Integer pizzaId) {
        Pizza pizza = pizzaService.find(pizzaId);
        return pizza.toString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "newpizza";
    }

    @RequestMapping(value = "addNew", method = RequestMethod.POST)
    // searches for the object with Pizza type and if doesn't find - creates it.
    public String add(@ModelAttribute Pizza pizza) {
        pizzaService.save(pizza);
        return "redirect:pizzas";
    }
}