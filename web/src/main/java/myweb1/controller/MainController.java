package myweb1.controller;

import myapp.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String authGet(Model model){
        User user=new User();
        model.addAttribute("user", user);
        System.out.println(user.getName()+" from get");
        return "login";
    }

    @RequestMapping(value="/auth",method = RequestMethod.POST)
    public String authPost(@ModelAttribute("user") User user, Model model){
        System.out.println(user.getName()+" from post");
        return "welcome";
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(){
        return "index";
    }
}
