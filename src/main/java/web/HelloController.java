package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleksandra_Dmytrenko on 2/23/2016.
 */
@Controller
@SessionAttributes("name")
public class HelloController {//implements Controller {

  //  @Override
//    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {

//    public ModelAndView handleRequest() {
//        ModelAndView mav = new ModelAndView("Hello");
//        mav.addObject("name", "Hello from SpringMVC");
//        System.out.println("Controller called");
//        return mav;
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView handleRequest(@ModelAttribute("helloStr") String name){//str) {
        ModelAndView mav = new ModelAndView("Hello");
        mav.addObject("name", name);
//        mav.addObject("name", str);
        System.out.println("Controller called");
        return mav;
    }
//    @ModelAttribute("hello Str")
    @ModelAttribute("name")
    @RequestMapping(value = "/Hello", method = RequestMethod.GET)
//    @RequestMapping
    public  String createString(){
        return "Hello from Spring MVC";
    }
}
