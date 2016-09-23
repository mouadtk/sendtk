package com.sendtk.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Campaign;
import com.sendtk.app.models.MailList;
import com.sendtk.app.models.Offer;
import com.sendtk.app.models.User;
import com.sendtk.app.models.VirtualServer;
import com.sendtk.app.models.dao.CampaignDAO;


@Service
//@Scope("request")
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignDAO MyCampaignDAO;
	
	@Override
	@Transactional
	public Integer addCampaign(Campaign p) {		
		return MyCampaignDAO.AddCampaign(p);
	}

	@Override
	public boolean UpdateCampaign(Campaign p) {
		return MyCampaignDAO.UpdateCampaign(p);
	}

	@Override
	public List<Campaign> listCampaign() {
		return MyCampaignDAO.getAllCampaign();
	}

	@Override
	public Campaign getCampaignByReference(String ref) {
		return MyCampaignDAO.getCampaignByReference(ref);
	}

	@Override
	public Campaign getCampaignByID(int id) {		
		return MyCampaignDAO.getCampaignByID(id);
	}

	@Override
	public boolean removeCampaign(int id) {
		return MyCampaignDAO.removeCampaign(id);
	}

	@Override
	public Offer getCampaignsOffer(int idCmp) {
		return MyCampaignDAO.getCampaignsOffer(idCmp);
	}

	
	@Override
	public Campaign CreateCampaign(Date dt, String Hds, String Bd, User mailer,
			Offer ofr, Set<VirtualServer> vs, Set<MailList> mlist) {
		
		Campaign camp = new Campaign();
		camp.setRef("");
		camp.setBody(Bd);
		camp.setDate(dt);
		camp.setStatus("New");
		camp.setHeaders(Hds.toString());
		camp.setOffer(ofr);
		camp.setMailer(mailer);
		camp.setServer(vs);
		return camp;
		
	}

	@Override
	public List<Campaign> getMailerCampaigns(int idMailer) {
		List<Campaign> _Camps    = MyCampaignDAO.getCampaignsMailer(idMailer);
		for (int i=0;_Camps.size()>i;i++){
			Hibernate.initialize(_Camps.get(i).getOffer());
			Hibernate.initialize(_Camps.get(i).getServer());
			Hibernate.initialize(_Camps.get(i).getSettings());
		}
		return _Camps;
	}

	
	

}
