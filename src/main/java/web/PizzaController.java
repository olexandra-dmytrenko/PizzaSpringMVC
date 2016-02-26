package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.rd.deliveryservice.domain.Pizza;
import ua.rd.deliveryservice.service.PizzaService;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
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
    public String viewById(@RequestParam("id") Integer pizzaId) {
        Pizza pizza = pizzaService.find(pizzaId);
        return pizza.toString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "newpizza";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        return "newpizza";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    // searches for the object with Pizza type and if doesn't find - creates it.
    public String add(@ModelAttribute Pizza pizza) {
        System.out.println(pizza);
        pizzaService.save(pizza);
        return "redirect:pizzas";
    }

    // @ModelAttribute("pizza")
    // public Pizza findPizza(@RequestParam(value = "pizzaId", required = false) Integer pizzaId) {
    // if (pizzaId == null) {
    // return new Pizza();
    // } else
    // return pizzaService.find(pizzaId);
    // }
    // will use binder to get pizza by id
    @ModelAttribute("pizza")
    public Pizza findPizza(@RequestParam(value = "pizzaId", required = false) Pizza pizza) {
        if (pizza == null) {
            return new Pizza();
        } else
            return pizza;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // here we write which type we'll get and second parameter - how we'll get it
        binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String pizzaId) throws IllegalArgumentException {
                Pizza pizza = (pizzaId == null || pizzaId.isEmpty()) ? new Pizza() : pizzaService.find(Integer.valueOf(pizzaId));
                setValue(pizza);
            }
        });

    }
}