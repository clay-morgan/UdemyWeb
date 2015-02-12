package udemy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Clay on 11/02/15.
 */
@Controller
public class HomeController
{
    @RequestMapping("/")
    public String showHome()
    {
        return "home";
    }
}
