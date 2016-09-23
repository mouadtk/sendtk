package com.sendtk.app.controller;

 
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.mail.MessagingException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sendtk.app.buisness.CampaignFactory;
import com.sendtk.app.buisness.CampaignProcess;
import com.sendtk.app.models.Campaign;
import com.sendtk.app.models.MailList;
import com.sendtk.app.models.Offer;
import com.sendtk.app.models.User;
import com.sendtk.app.models.VirtualServer;
import com.sendtk.app.models.dao.UserDAO;
import com.sendtk.app.services.CampaignService;
import com.sendtk.app.services.OfferService;
import com.sendtk.app.services.ServerService;

@Controller
@RequestMapping("/Campaign")
public class CampaignController {
	
	private static final Logger logger = LoggerFactory.getLogger(CampaignController.class);
	
	@Autowired
	private  CampaignService Camp_Service;
	@Autowired
	private  ServerService  S_Service;
	@Autowired
	private  OfferService  Ofr_Service;
	@Autowired
	private  CampaignFactory AllCampaigns;
	@Autowired	
	UserDAO UserService;
	
	@RequestMapping(value = "/PreparCampaign", method = RequestMethod.GET)
	public ModelAndView NewCampaign( Principal  p){
		
		ModelAndView MV = new ModelAndView("campaign/New");
//		User CurrentUser = UserService.findByUserName(p.getName());
//		MV.addObject("firstname", CurrentUser.getFirstName());
//		MV.addObject("lastname", CurrentUser.getLastName());
//		MV.addObject("username", CurrentUser.getRole().getRoleName());
		return MV;
	}
	
	@RequestMapping(value = "/MailerCampaigns", method = RequestMethod.GET)
	public ModelAndView ListMailerCampaigns( Principal  p){
		ModelAndView MV = new ModelAndView("campaign/MailerCampListing");
		User CurrentUser = UserService.findByUserName(p.getName());
		int a  = CurrentUser.getId();
		List<Campaign> res = Camp_Service.getMailerCampaigns(a);
		return MV.addObject("Campaigns",res);
	}
	
	@RequestMapping(value = "/Pause", method = RequestMethod.POST, headers = "Accept=*")
	@ResponseBody
	public String PauseCampaign( @RequestBody String data, Principal  p) throws JsonProcessingException, IOException {
		/*********************
		/* Get Data          * 
		/*********************/
		String name = p.getName();
		ObjectMapper mapper   = new ObjectMapper();
		JsonNode 	 node 	  = mapper.readTree(data);
		String       IDCamp = mapper.convertValue(node.get("IDCamp"), String.class );
		logger.info("Pause Campaign with ID "+IDCamp);
		if(AllCampaigns.getCampaign(Integer.parseInt(IDCamp))!= null){
			AllCampaigns.getCampaign(Integer.parseInt(IDCamp)).Pause();
			return IDCamp;
		}else{
			return "Campaign not exist";
		}
	}
	
	@RequestMapping(value = "/Resume", method = RequestMethod.POST, headers = "Accept=*")
	@ResponseBody
	public String ResumeCampaign( @RequestBody String data) throws JsonProcessingException, IOException {
		/*********************
		/* Get Data          * 
		/*********************/
		ObjectMapper mapper   = new ObjectMapper();
		JsonNode 	 node 	  = mapper.readTree(data);
		String       IDCamp = mapper.convertValue(node.get("IDCamp"), String.class );
		logger.info("Resume Campaign with ID "+IDCamp);
		if(AllCampaigns.getCampaign(Integer.parseInt(IDCamp))!= null){
			AllCampaigns.getCampaign(Integer.parseInt(IDCamp)).Resume();
			return IDCamp;
		}else{
			return "Campaign not exist";
		}
	}
	
	@RequestMapping(value = "/SendTest", method = RequestMethod.POST, headers = "Accept=*")
	@ResponseBody
	public String SendTest( @RequestBody String data) throws JsonProcessingException, IOException, InterruptedException {
		
		String Results = null;
		CampaignProcess MayCampaign;

		/*********************
		/* Get Data          * 
		/*********************/
		ObjectMapper mapper   = new ObjectMapper();
		JsonNode 	 node 	  = mapper.readTree(data);
		String       TestMail = mapper.convertValue(node.get("Mail"), String.class );
		String  	 MsgBody  = mapper.convertValue(node.get("MsgBody"), String.class );
		HashMap<String,String> Headers = mapper.readValue(node.get("Headers"),new TypeReference< HashMap<String,String> >(){});
		List<String> IPS 	  = mapper.readValue(node.get("IPs"),new TypeReference<List<String>>(){});
		
		
		/*********************
		/* Get VirtualServers*
		/*********************/
		List<VirtualServer> VSList = S_Service.getVirtualServerList(IPS);
		
		/**
		 * Create Campaign
		 **/
		Campaign camp = Camp_Service.CreateCampaign(new Date(), Headers.toString(), MsgBody, null, null, null, null);
		
		/**
		 * get email from some file
		 * _Message : [MailTo,From,MessageBody,Subject]
		 */
		
		HashMap<String, String> _MSG    = new HashMap<String, String>(0);
		_MSG.put("MailTo"     , TestMail			  );
		_MSG.put("From"       , Headers.get("from")   );
		_MSG.put("Subject"    , Headers.get("subject"));
		_MSG.put("MessageBody", MsgBody 			  );
		
		/**
		 * Send Process
		 */
		try {
			
			MayCampaign = new CampaignProcess(VSList,camp,null,0,0,0,0,0,_MSG);
			HashMap<String, Integer> TestResult  = MayCampaign.SendCampaignTest();
			Results = mapper.writeValueAsString(TestResult);
			
		} catch (MessagingException e){
			e.printStackTrace();
		}
		
		return Results;		
	}
	
	@RequestMapping(value = "/SendCampaign", method = RequestMethod.POST, headers = "Accept=*")
	@ResponseBody
	public String SendCampaign( @RequestBody String data) throws JsonProcessingException, IOException, MessagingException{
	
		CampaignProcess MyCampaign =null;
		/***************
		/* Get Data    *
		/***************/
		ObjectMapper mapper   = new ObjectMapper();
		JsonNode 	 node 	  = mapper.readTree(data);
		String       Offerid  = mapper.convertValue(node.get("OfferID"), String.class );
		String       TestMail = mapper.convertValue(node.get("Mail"), String.class );
		String  	 MsgBody  = mapper.convertValue(node.get("MsgBody"), String.class );
		List<String> IPS 	  = mapper.readValue(node.get("IPs"),new TypeReference<List<String>>(){});
		HashMap<String,String> Headers = mapper.readValue(node.get("Headers"),new TypeReference< HashMap<String,String> >(){});
		VirtualServer Tmp;
		
		/***************
		/* Mailer      *
		/***************/
		User mailer =  new User();
		
		/***************
		/* Offer       *  
		/***************/
		Offer Offr = Ofr_Service.getOfferByID(Integer.parseInt(Offerid));
		
		/**************
		/* Get VirtualServers 
		/**************/
		List<VirtualServer> VSList = S_Service.getVirtualServerList(IPS);
		
		/**
		 * get email from some file
		 * _Message : [MailTo,From,MessageBody,Subject]
		 */
		
		HashMap<String, String> _MSG    = new HashMap<String, String>(0);
		_MSG.put("MailTo"     , TestMail			  );
		_MSG.put("From"       , Headers.get("from")   );
		_MSG.put("Subject"    , Headers.get("subject"));
		_MSG.put("MessageBody", MsgBody 			  );
		
		/*******************
		 * Create Campaign *
		 *******************/
		Campaign camp = Camp_Service.CreateCampaign(new Date(), Headers.toString(), MsgBody, null, Offr, new HashSet<VirtualServer>(VSList), new HashSet<MailList>(0));
		Camp_Service.addCampaign(camp);
		
		/*******************
		 * Send Process    *
		 *******************/
		
		try {
			MyCampaign = new CampaignProcess(VSList,camp,"E:\\mails.txt",0,0,0,0,0,_MSG);
			int id = AllCampaigns.AddCampaign(MyCampaign);
			MyCampaign.set_Id(id);
			MyCampaign.start();
		} catch (Throwable e){
			e.printStackTrace();
		}
		
		
		return "{'id':"+MyCampaign.getId()+"}";		
		//return "redirect:Campaign/PreparCampaign";
		//return "campaign/New";
	}
	
	@RequestMapping(value = "/ListingCampaigns", method = RequestMethod.GET)
	public String ListingAllCampaigns( @RequestBody String data){
		return "campaign/New";
	}
	
	@RequestMapping(value = "/onHoldCampaigns", method = RequestMethod.GET)
	public String onHoldCampaigns( @RequestBody String data){
		return "campaign/New";
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value = "/searchOffer", method = RequestMethod.GET,   headers = "Accept=*")
	@ResponseBody
	public String searchOffer(@RequestParam("affiliate") String affiliate, @RequestParam("q") String name) throws JsonProcessingException, IOException{
		
		List<Offer> OfferRes = this.Ofr_Service.getOfferByNameAffiliate(affiliate, name);
		String items = "";
		String serializedObj = "";
		for(int i=0;i < OfferRes.size();i++){
			serializedObj = new ObjectMapper().writeValueAsString(OfferRes.get(i));
			items += serializedObj+"";
			if(i!=OfferRes.size()-1)
				items +=",";
		}
		String res ="{\"total_count\": "+OfferRes.size()*10+","+
				    "\"incomplete_results\": false,"+
					"\"items\": ["+items+"] }";
		return res;
	
	}

}