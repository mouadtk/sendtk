package com.sendtk.app.models.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Settings;

@Repository
@Transactional
public class SettingsDAOImpl implements SettingsDAO{

public static Logger LOGGER = LoggerFactory.getLogger(OfferDAOImpl.class);
	
	@Autowired
	private SessionFactory HibernateSessFactory;
	
	public SettingsDAOImpl(){}
	
	public SettingsDAOImpl(SessionFactory sessionFactory) {
		this.HibernateSessFactory = sessionFactory;
	}
	
	@Override
	public Integer AddSettings(Settings newSettings) {
		
		try {
			Session session = HibernateSessFactory.getCurrentSession();		
			Integer SettingsID = (Integer)session.save(newSettings);
			return SettingsID;
		} catch(Exception e) {
			System.err.println(" *************************"+e.getMessage()+"**************");
		} 				
		return -1;
	}

	@Override
	public boolean UpdateSettings(Settings S) {
		Session session = HibernateSessFactory.getCurrentSession();			
		session.update(S);	
		return true;
	}

	@Override
	public Settings getSettingsByID(int id) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Settings.class);
		crit.add(Restrictions.eq("id", id));
		return  (Settings) crit.uniqueResult();
	}

	@Override
	public boolean removeSettings(int id) {
		return true;
	}
	
	
	
}
