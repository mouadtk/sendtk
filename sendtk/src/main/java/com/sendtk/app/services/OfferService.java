package com.sendtk.app.services;

import java.util.List;

import com.sendtk.app.models.*;

public interface OfferService {
		
		public Integer addOffer(Offer p);
		public boolean UpdateOffer(Offer p);
	    public List<Offer> listOffers();
	    public Offer getOfferByReference(String ref);
	    public Offer getOfferByID(int id);
	    public boolean removeOffer(int id);
	    public List<Offer> getOfferByNameAffiliate(String aff, String name);
	    
}