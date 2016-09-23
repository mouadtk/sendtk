package com.sendtk.app.models.dao;

import java.util.List;
import com.sendtk.app.models.Offer;

public interface OfferDAO {
	
	public Integer AddOffer(Offer newOffer);
	public boolean UpdateOffer(Offer O);
	public List<Offer> getAllOffers();
	public Offer getOfferByReference(String refer);
	public Offer getOfferByID(int id);
	public boolean removeOffer(int id);
	public List<Offer> getOfferByVertical(String vert);
	public List<Offer> getOfferByNameAffiliate(String affiliate,String name);
	
	
}