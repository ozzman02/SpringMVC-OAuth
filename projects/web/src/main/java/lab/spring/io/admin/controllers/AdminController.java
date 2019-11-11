package lab.spring.io.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @ResponseBody
    @RequestMapping(value = {"/", "/admin"})
    public String home() {
        return "Welcome Admin";
    }

    @RequestMapping("/welcome/{userId}")
    public ModelAndView welcome(@PathVariable(value = "userId") Integer id) {
        ModelAndView model = new ModelAndView("welcome");
        if (id != null && id == 1) {
            model.addObject("name", "ADMIN INAM");
        } else {
            model.addObject("name", "Anonymous");
        }
        return model;
    }



}
