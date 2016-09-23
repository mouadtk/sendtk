package com.sendtk.app.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.sendtk.app.models.Campaign;
import com.sendtk.app.models.MailList;
import com.sendtk.app.models.Offer;
import com.sendtk.app.models.User;
import com.sendtk.app.models.VirtualServer;

public interface CampaignService {
	
	public Integer addCampaign(Campaign p);
	public boolean UpdateCampaign(Campaign p);
    public List<Campaign> listCampaign();
    public Campaign getCampaignByReference(String ref);
    public Campaign getCampaignByID(int id);
    public boolean removeCampaign(int id);
    public Offer getCampaignsOffer(int idCmp);
    public List<Campaign> getMailerCampaigns(int idMailer);
    
    /**
     * Factory 
     **/
    public Campaign CreateCampaign(Date dt,String Hds,String Bd,User mailer, Offer ofr, Set<VirtualServer> vs, Set<MailList> mlist);
    
}
