package edu.miu.swe.eregistrar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eregistrar/home")
public class HomeController {


    @GetMapping
    public String getHome(){
        return "index";
    }


}
