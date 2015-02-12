package udemy.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.web.data.Offer;
import udemy.web.data.OfferDAO;

import java.util.List;

@Service( "offerService" )
public class OfferService
{
    private OfferDAO offerDAO;

    @Autowired
    public void setOfferDAO( OfferDAO offerDAO )
    {
        this.offerDAO = offerDAO;
    }

    public List<Offer> getCurrentList()
    {
        return offerDAO.getOffers();
    }
}
