package web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Created by Oleksandra_Dmytrenko on 2/23/2016.
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("Hello");
        mav.addObject("name", "Hello from SspringMVC");
        System.out.println("Controller called");
        return mav;
    }
}
