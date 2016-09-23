 package com.sendtk.app.buisness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class CampaignFactory implements InitializingBean, DisposableBean{
	
	private static final Logger logger = LoggerFactory.getLogger(CampaignFactory.class);

	static HashMap<String, CampaignProcess> CurrentCampaigns = new HashMap<String, CampaignProcess>(0);
	
	private List<CampaignProcess> CurrentCampaign = new ArrayList<CampaignProcess>();
	
	/*************************************************    List    **************************************************************/
	public int AddCampaign(CampaignProcess NewCamp){
		
		CurrentCampaign.add(NewCamp);
		return CurrentCampaign.size();
		
	}
	
	public CampaignProcess getCampaign(int index) {
		return (index < CurrentCampaign.size()) ? CurrentCampaign.get(index) :  null;
		
	}
	
	public boolean PauseCampaign(int index){
		return CurrentCampaign.get(index).Pause();
	}
	/***************************************************************************************************************************/
	
	/*************************************************    Map     **************************************************************/
	public void AddCampaign(CampaignProcess NewCamp, String key){
		CurrentCampaigns.put(key, NewCamp);
	}
	
	public CampaignProcess getCampaign(String key){
		return CurrentCampaigns.get(key);
	}
	
	public boolean RemoveCampaign(String key){
		if(CurrentCampaigns.remove(key) != null)return true;
		return false;
	}
	 
	public boolean PauseCampaign(String key){
		return CurrentCampaigns.get(key).Pause();
	}
	
	public boolean ResumeCampaign(String key){
		return CurrentCampaigns.get(key).Resume();
	}
	/**************************************************************************************************************************/
	
	
	@Override
	public void destroy() throws Exception {
		logger.info("Destroing CampaignFactory...");
		logger.info("Deleting "+CurrentCampaign.size()+" elements.");
		logger.info("Bye Bye..");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("initializing CampaignFactory...");
		CurrentCampaign = new ArrayList<CampaignProcess>(0);

	}

	
	
	
}