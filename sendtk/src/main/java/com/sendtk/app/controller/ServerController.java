package com.sendtk.app.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sendtk.app.models.Offer;
import com.sendtk.app.models.Server;
import com.sendtk.app.services.ServerService;

@Controller
@RequestMapping("/Server")
public class ServerController {


	private static final Logger logger = LoggerFactory.getLogger(ServerController.class);	
	
	@Autowired
	private  ServerService Server;
	
	
	@RequestMapping("/")
	public ModelAndView NewOffer() {
		
		Server x =  Server.getServerByMainIP(" 146.247.24.68");
		/*
		x.setMainIP("111.90.150.161");
		x.setName("ServerCentral");
		x.setUser("root");
		x.setPasswd("davudex@2A");
		x.setProvider("unknown");
		x.setStatus("Active");
		x.setDateEntrer(new Date());
		*/
		
		List<Server> ServList = Server.listServers();
		
		ModelAndView modelAndView = new ModelAndView("server/index");
		modelAndView.addObject("Servers",ServList);
		//Server.addServer(x);
		//Server.UpdateServer(x);
		//Server.removeServer(0);
		return modelAndView;
	}	

	/**
	 * 
	 * @return
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value = "/getIPs", method = RequestMethod.GET,   headers = "Accept=*")
	@ResponseBody
	public String searchOffer() throws JsonProcessingException, IOException{
		
		List<Object[]> ServerRes = this.Server.getAllServersIPs();
		
		String items = "";
		String serializedObj = "";
//		for(int i=0;i < ServerRes.size();i++){
//			serializedObj = new ObjectMapper().writeValueAsString(ServerRes.get(i));
//			items += serializedObj+"";
//			if(i!=ServerRes.size()-1)
//				items +=",";
//		}
		
		return "";// return ServerRes.toString();
	
	}
}








