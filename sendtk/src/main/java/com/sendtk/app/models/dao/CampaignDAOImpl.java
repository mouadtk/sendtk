package com.sendtk.app.models.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Campaign;
import com.sendtk.app.models.Offer;
import com.sendtk.app.models.User;


@Repository
@Transactional
public class CampaignDAOImpl implements CampaignDAO {

	static Logger LOGGER = LoggerFactory.getLogger(CampaignDAOImpl.class);
	
	@Autowired
	private SessionFactory HibernateSessFactory;
	
	public void setSessionFactory(SessionFactory sf){
        this.HibernateSessFactory = sf;
    } 
	
	public CampaignDAOImpl(){}
	
	public CampaignDAOImpl(SessionFactory sessionFactory) {
		this.HibernateSessFactory = sessionFactory;
	}
	
	@Override
	public Integer AddCampaign(Campaign Campaign) {
		try {
			Session session = HibernateSessFactory.getCurrentSession();		
			Integer CampaignID = (Integer)session.save(Campaign);
			return CampaignID;
		} catch(Exception e) {
			System.err.println(" *************************"+e.getMessage()+"**************");
		} 				
		return -1;
		
	}

	@Override
	public boolean UpdateCampaign(Campaign x) {
		
		Session session = HibernateSessFactory.getCurrentSession();			
		session.update(x);	
		return true;
	}

	@Override
	public List<Campaign> getAllCampaign() {
		
		@SuppressWarnings("unchecked")
		List<Campaign> listCampaign = (List<Campaign>) HibernateSessFactory.getCurrentSession()
				.createCriteria(Campaign.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();	
		return listCampaign;
	}

	@Override
	public Campaign getCampaignByReference(String refer) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Campaign.class);
		crit.add(Restrictions.eq("Ref", refer));
		return  (Campaign) crit.uniqueResult();
		
	}

	@Override
	public Campaign getCampaignByID(int id) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Campaign.class);
		crit.add(Restrictions.eq("Id", id));
		return  (Campaign) crit.uniqueResult();
	}

	@Override
	public boolean removeCampaign(int id){
		
		Session session = HibernateSessFactory.getCurrentSession();
		Campaign x = new Campaign();
		x.setId(id);
		session.delete(x);
		return true;
	}

	@Override
	public Offer getCampaignsOffer(int idCamp) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Campaign x = (Campaign) session.createCriteria(Campaign.class)
					 .add(Restrictions.idEq(idCamp)).uniqueResult();  
		Hibernate.initialize(x.getOffer());
		
	 	return x.getOffer();
	}
	
	@Override
	public List<Campaign> getCampaignsMailer(int idMailer) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Query query = session.createQuery("from Campaign where Mailer_Id = :id ");
		query.setParameter("id", idMailer);
		List<Campaign> _Camps = query.list();
		for (int i=0;_Camps.size()>i;i++){
			Hibernate.initialize(_Camps.get(i).getOffer());
			Hibernate.initialize(_Camps.get(i).getServer());
			Hibernate.initialize(_Camps.get(i).getSettings());
		}
		
		return _Camps;
		
		
//		User x = (User) session.createCriteria(User.class)
//					 .add(Restrictions.idEq(idMailer)).uniqueResult();  
//		Hibernate.initialize(x.getCmps());
//		
//		return  x.getCmps();
	}
}
