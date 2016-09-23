package com.sendtk.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Offer;
import com.sendtk.app.models.dao.OfferDAO;

@Service
//@Scope("request")
public class OfferServiceImpl implements OfferService{

	@Autowired
	private OfferDAO MyOfferDAO;
	
	@Override
	@Transactional
	public Integer addOffer(Offer tmpOffer) {	
		return MyOfferDAO.AddOffer(tmpOffer);
	}
	
	@Override
	public List<Offer> listOffers() { 
		return MyOfferDAO.getAllOffers();
	}

	@Override
	@Transactional
	public Offer getOfferByReference(String ref) {
		return MyOfferDAO.getOfferByReference(ref);		
	}
	
	@Override
	@Transactional
	public Offer getOfferByID(int ref) {
		Offer tmp =  MyOfferDAO.getOfferByID(ref);
		return tmp;
		 
	}

	@Override
	public boolean removeOffer(int id) {
		if(this.getOfferByID(id) != null)
			return this.MyOfferDAO.removeOffer(id);
		return false;
	}

	@Override
	public boolean UpdateOffer(Offer p) {
		return this.MyOfferDAO.UpdateOffer(p);		
	}

	@Override
	public List<Offer> getOfferByNameAffiliate(String aff, String name) {
		if (aff!= null && name!=null)
		return this.MyOfferDAO.getOfferByNameAffiliate(aff, name);
		else return null;
	}

}
