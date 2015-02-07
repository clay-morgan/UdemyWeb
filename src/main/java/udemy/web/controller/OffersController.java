package udemy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController
{

    @RequestMapping( "/" )
    public String showHome( Model model )
    {
        return getString( model );
    }

    public String getString( Model model )
    {
        model.addAttribute( "name", "<b>Raphael</b>" );
        model.asMap().get( "getOfferName" );

        return "home";
    }

    // this will run every time the RequestMapping is used so
    // consider calling a service here that accesses a cached value of something
    @ModelAttribute( "getOfferName" )
    public String getOfferName()
    {
        return "<b>Leonardo</b>";
    }

//    @RequestMapping( "/" )
//    public ModelAndView showHome()
//    {
//        ModelAndView mv = new ModelAndView( "home" );
//        Map<String, Object> model = mv.getModel();
//        model.put( "name", "Raphael" );
//
//        return mv;
//    }

}
