package udemy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import udemy.web.data.Offer;
import udemy.web.service.OfferService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OffersController
{
    private OfferService offerService;

    @Autowired
    public void setOfferService( OfferService offerService )
    {
        this.offerService = offerService;
    }

    @RequestMapping("/offers")
    public String showOffers( Model model )
    {
        List<Offer> offers = offerService.getCurrentList();
        model.addAttribute( "offers", offers );

        return "offers";
    }

    @RequestMapping("/createOffer")
    public String showCreateOffer( Model model )
    {
        model.addAttribute( "offer", new Offer() );     // corresponds to the "commandName" attribute (from spring tags form taglib)
        return "createOffer";
    }

    @RequestMapping( method = RequestMethod.POST, value = "/doCreate" )
    public String doCreate( Model model, @Valid Offer offer, BindingResult bindingResult )
    {
        if( bindingResult.hasErrors() )
        {
            return "createOffer";
        }
        return "offerCreated";
    }

    @RequestMapping( method = RequestMethod.GET, value = "/testUrlParameter" )
    public String showTest( Model model, @RequestParam( "id" ) String idFromParameter )
    {
        System.out.println( "Id came in as " + idFromParameter );

        return "home";
    }

    // this will run every time the RequestMapping is used so
    // consider calling a service here that accesses a cached value of something
    @ModelAttribute( "getOfferName" )
    public String getOfferName()
    {
        return "<b>Leonardo</b>";
    }

}
