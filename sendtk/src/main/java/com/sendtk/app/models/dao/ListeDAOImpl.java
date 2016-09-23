package com.sendtk.app.models.dao;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Liste;
import com.sendtk.app.models.User;

@Repository
@Transactional
public class ListeDAOImpl implements ListeDAO{

	public static Logger LOGGER = LoggerFactory.getLogger(OfferDAOImpl.class);
	
	@Autowired
	private SessionFactory HibernateSessFactory;
	
	public void setSessionFactory(SessionFactory sf){
        this.HibernateSessFactory = sf;
    }

	@Override
	public Integer AddListe(Liste newList) {
		try {
			Session session = HibernateSessFactory.getCurrentSession();		
			Integer ID = (Integer)session.save(newList);
			return ID;
		} catch(Exception e) {
			System.err.println(" *************************"+e.getMessage()+"**************");
		} 				
		return -1;
	}

	@Override
	public boolean UpdateListe(Liste newList) {
		Session session = HibernateSessFactory.getCurrentSession();			
		session.update(newList);	
		return true;
	}

	@Override
	public List<Liste> getAllListes() {
		@SuppressWarnings("unchecked")
		List<Liste> listListe = (List<Liste>) HibernateSessFactory.getCurrentSession()
				.createCriteria(Liste.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listListe;
	}

	
	@Override	
	public String generateReference() {
		while(true){
			String _Reference = RandomStringUtils.random(8, true, true).toUpperCase();
			Session session = HibernateSessFactory.getCurrentSession();
			Criteria crit = session.createCriteria(Liste.class);
			crit.add(Restrictions.eq("Reference", _Reference));
			crit.list();
			if(crit.list().size()==0)
			return _Reference;
		}
	}

	@Override
	public String generateName(String ISP, String Type) {
			String name = ISP.substring(0, 3).toUpperCase()+"-"+Type.toUpperCase()+"-";
			Session session = HibernateSessFactory.getCurrentSession();
			Criteria crit = session.createCriteria(Liste.class);
			crit.add(Restrictions.like("Name", name, MatchMode.START));
			return name+String.format("%04d", crit.list().size());
		
	}

	@Override
	public boolean disable(String ref) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Query query = session.createQuery("update Liste set Active = :status "+
										  " where Reference = :ref");
		query.setParameter("status", 0);
		query.setParameter("ref", ref);
		int result = query.executeUpdate();
		
		return true;
	}

	@Override
	public boolean enable(String ref) {
		Session session = HibernateSessFactory.getCurrentSession();
		Query query = session.createQuery("update Liste set Active = :status "+
										  " where Reference = :ref");
		query.setParameter("status", 1);
		query.setParameter("ref", ref);
		int result = query.executeUpdate();
		
		return true;
	}
}
