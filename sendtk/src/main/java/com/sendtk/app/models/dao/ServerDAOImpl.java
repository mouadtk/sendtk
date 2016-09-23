package com.sendtk.app.models.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Server;

@Repository
@Transactional
public class ServerDAOImpl implements ServerDAO {

	
	public static Logger LOGGER = LoggerFactory.getLogger(ServerDAOImpl.class);
	
	@Autowired
	private SessionFactory HibernateSessFactory;
	
	@SuppressWarnings("finally")
	@Override
	public Integer AddServer(Server newServer) {
		
		try {
			
			Session session = HibernateSessFactory.getCurrentSession();
			Integer serverID = (Integer)session.save(newServer);
			return serverID;
			
		} catch(Exception e) {
			
			System.err.println(" *************************"+e.getMessage()+"**************");
			return -1;
			
		} finally{
			return -1;
		}
	}

	@Override
	public boolean UpdateServer(Server O) {
		Session session = HibernateSessFactory.getCurrentSession();			
		session.update(O);	
		return true;
	}

	@Override
	public List<Server> getAllServers(){
		
		@SuppressWarnings("unchecked")
		List<Server> listServer = (List<Server>) HibernateSessFactory.getCurrentSession()
				.createCriteria(Server.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listServer;
	}

	@Override
	public Server getServerByMainIP(String ip) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Server.class);
		crit.add(Restrictions.eq("MainIP", ip));
		crit.setMaxResults(1);
		return  (Server) crit.uniqueResult();
	}

	@Override
	public Server getServerByID(int id) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Server.class);
		crit.add(Restrictions.eq("id", id));
		return  (Server) crit.uniqueResult();

	}

	@Override
	public boolean removeServer(int id) {

		Session session = HibernateSessFactory.getCurrentSession();
		Server offr = new Server();
		offr.setId(id);
		session.delete(offr);
		return true;
	}

	
	@Override
	public List<Object[]> getALLServerIPS() {
		
		Session session =  HibernateSessFactory.getCurrentSession();
		Query query = session.createQuery("select s.MainIP from Server s");
		@SuppressWarnings("unchecked")
		List<Object[]> rows = query.list();
		return rows;
	}

}
