package com.sendtk.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sendtk.app.models.Campaign;
import com.sendtk.app.models.Offer;
import com.sendtk.app.services.CampaignService;
import com.sendtk.app.services.OfferService;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;



@Controller
@RequestMapping("/Offer")
public class OfferController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Autowired
	private CampaignService Campign;
	@Autowired
	private OfferService Offers;
	
	@RequestMapping("/newOffer")
	public String NewOffer(){

		Offer someOffer = new Offer();
		someOffer.setName("SomaeName"+new Random().toString());
		someOffer.setDescription("bla bla bla"+new Random().toString());
		someOffer.setReference( new Random().toString());
		someOffer.setRestrictions("no restrictions");
		someOffer.setGeoRestriction("USA,UK,AUS");
		someOffer.setSuppLsitLink("www"+new Random().hashCode()+"zz.com");
		someOffer.setUnsubListLink("www"+new Random().toString()+"zz.com");
		someOffer.setPayout(new Random().nextFloat());
		someOffer.setPayoutFormat("CPC");
		
		/*Froms */
		Map<Integer, String> froms = new HashMap<Integer, String>();
		froms.put(1, "from 1");
		froms.put(2, "from 2");
		froms.put(3, "from 3");
		someOffer.setFroms(froms);
		
		/*subjects*/
		Map<Integer, String> subjects = new HashMap<Integer, String>();
		subjects.put(1, "from 1");
		subjects.put(2, "from 2");
		subjects.put(3, "from 3");
		someOffer.setSubjects(subjects);
		
		Map<String, String> creatives = new HashMap<String, String>();
		creatives.put("12", "llalala");
		someOffer.setCreatives(creatives);

		Offers.addOffer(someOffer);
		
		/***************************************************/
		
		Campaign p = new Campaign();
 
		p.setDate(new Date());
		p.setRef("Cmp100");
		p.setStatus("active");
		p.setOffer(someOffer);
		this.Campign.addCampaign(p);
		/***************************************************/
		return "offer/New";
	}

	/**
	 * @param id
	 * @return return ModelView object, showing details of an Offer
	 * @throws Exception
	 */
	@RequestMapping(value = "/OfferDetails/{id}", method = RequestMethod.GET)
	public ModelAndView OfferDetails(@PathVariable int id) throws Exception {

		Offer x = Offers.getOfferByID(id);
		ModelAndView modelAndView = new ModelAndView("offer/OfferDetails");		
		modelAndView.addObject("Offer", x);
		
		return modelAndView;
	}

	@RequestMapping(value = "/OfferUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean OfferUpdate(@RequestBody Offer UpdatedOffer) throws Exception {					
		return Offers.UpdateOffer(UpdatedOffer);		
	}

	/**
	 * 
	 * @return JSON Offer object by ID or null  
	 * @throws Exception
	 */						  
	@RequestMapping(value = "/getAjaxOffer/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )	
	@ResponseBody
	public Offer OfferByIdDetail(@PathVariable int id) throws Exception {
		return Offers.getOfferByID(id);
	}

	/***
	 * 
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/ShowOffers", method = RequestMethod.GET)
	public ModelAndView ShowOffers() throws Exception {
		
		/***************************************************
		
		Campaign p = Campign.getCampaignByID(2);
		Offer of = Campign.getCampaignsOffer(2);
		logger.error(of.getReference());
		
		/***************************************************/
		
		
 		List<Offer> OffrList = Offers.listOffers();
		ModelAndView modelAndView = new ModelAndView("offer/OfferList");
				
		if(OffrList !=null ){
			modelAndView.addObject("Offers", OffrList);			
		}else{
			modelAndView.addObject("Offers", null);
		}
		
 		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody//	@ResponseBody means that there is no need for the controller to look for a view for	this action
	public boolean removeOffer(@PathVariable int id) {
		return Offers.removeOffer(id);
	}

	/**
	 * @param ids : list of IDs separated with comma ','
	 */
	public void RemoveListOffers(String ids) {
		String listIds[] = ids.split(",");
		for (String id : listIds) {
			Offers.removeOffer(Integer.parseInt(id));
		}
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
		
		List<Offer> OfferRes = this.Offers.getOfferByNameAffiliate(affiliate, name);
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