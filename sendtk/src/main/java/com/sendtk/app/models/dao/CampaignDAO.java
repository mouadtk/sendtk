package com.sendtk.app.models.dao;

import java.util.List;
import java.util.Set;

import com.sendtk.app.models.Campaign;
import com.sendtk.app.models.Offer;

public interface CampaignDAO {
	
	public Integer AddCampaign(Campaign MyCampaign);		  /* OK*/
	public boolean UpdateCampaign(Campaign O);				  /* OK*/
	public List<Campaign> getAllCampaign();					  /* OK*/
	public Campaign getCampaignByReference(String refer);     /* OK*/
	public Campaign getCampaignByID(int id);				  /* OK*/
	public boolean removeCampaign(int id);					  /* OK*/
	public Offer getCampaignsOffer(int id);
	public List<Campaign> getCampaignsMailer(int id);
}
