package com.sendtk.app.models.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Server;
import com.sendtk.app.models.VirtualServer;

@Repository
@Transactional
public class VirtualServerDAOImpl implements VirtualServerDAO{
	
	private static Logger LOGGER = LoggerFactory.getLogger(ServerDAOImpl.class);
	
	@Autowired
	private SessionFactory HibernateSessFactory;
	
	@Override
	public Integer AddVirtualServer(VirtualServer newVirtualServer){
		
		return null;
	}

	@Override
	public boolean UpdateVirtualServer(VirtualServer O) {
		return false;
	}

	@Override
	public List<VirtualServer> getAllVirtualServersByIDServer() {
		return null;
	}

	@Override
	public VirtualServer getVirtualServerByMainIPServer(String ip) {
		
		Session session = HibernateSessFactory.getCurrentSession();
		Criteria crit = session.createCriteria(VirtualServer.class);
		crit.add(Restrictions.eq("IP", ip));
		crit.setMaxResults(1);	
		VirtualServer res =  (VirtualServer) crit.uniqueResult();
		if(res != null)
			Hibernate.initialize(res.getServer());
		return res;
	}

	@Override
	public VirtualServer getVirtualServerByID(int id) {
		return null;
	}

	@Override
	public boolean removeVirtualServer(int id) {
		return false;
	}

	@Override
	public Server getParentServer(int id) {		
		return null;
	}

	
	
}
