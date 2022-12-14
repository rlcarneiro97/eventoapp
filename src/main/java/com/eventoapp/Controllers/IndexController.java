package com.eventoapp.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String index(){
        return "redirect:/eventos";
    }

    @RequestMapping(value = "/login")
        public String login() {
            return "login";
        }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

}
