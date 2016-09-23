package com.sendtk.app.models.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Offer;
 
@Repository
@Transactional
public class OfferDAOImpl implements OfferDAO {
	
	public static Logger LOGGER = LoggerFactory.getLogger(OfferDAOImpl.class);
	
	@Autowired
	private SessionFactory HibernateSessFactory;
	
	public void setSessionFactory(SessionFactory sf){
        this.HibernateSessFactory = sf;
    } 
	
	public OfferDAOImpl(){}
	
	public OfferDAOImpl(SessionFactory sessionFactory) {
		this.HibernateSessFactory = sessionFactory;
	}

	public Integer AddOffer(Offer newOffer) {	
		
		try {
			Session session = HibernateSessFactory.getCurrentSession();		
			Integer OfferID = (Integer)session.save(newOffer);
			return OfferID;
		} catch(Exception e) {
			System.err.println(" *************************"+e.getMessage()+"**************");
		} 				
		return -1;
	}

	@Override
	public List<Offer> getAllOffers() {

		@SuppressWarnings("unchecked")
		List<Offer> listUser = (List<Offer>) HibernateSessFactory.getCurrentSession()
				.createCriteria(Offer.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}		

	@Override
	@Transactional
	public Offer getOfferByReference(String refer){ 
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Offer.class);
		crit.add(Restrictions.eq("Reference", refer));
		crit.setMaxResults(1);	
		return  (Offer) crit.uniqueResult();
		
	}
	
	@Override
	@Transactional
	public Offer getOfferByID(int id){ 
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Offer.class);
		crit.add(Restrictions.eq("id", id));
		return  (Offer) crit.uniqueResult();		
	}
	
	@Override
	@Transactional
	public boolean removeOffer(int sid){
		
		Session session = HibernateSessFactory.getCurrentSession();
		Offer offr = new Offer();
		offr.setId(sid);
		session.delete(offr);	
		return true;
	}

	@Override
	public List<Offer> getOfferByVertical(String vert) {			
		return null;
	}

	@Override
	public boolean UpdateOffer(Offer O) {
		
		Session session = HibernateSessFactory.getCurrentSession();			
		session.update(O);	
		return true;
	}
	
	@Override
	public List<Offer> getOfferByNameAffiliate(String affiliate, String name) {
		@SuppressWarnings("unchecked")
		List<Offer> listUser = (List<Offer>) HibernateSessFactory.getCurrentSession()
				.createCriteria(Offer.class)
				.add(Restrictions.like("Name", name, MatchMode.ANYWHERE))
				.add(Restrictions.like("Affiliate", affiliate, MatchMode.ANYWHERE))
				.addOrder(Order.asc("Id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listUser;
	}
	
}