package com.sendtk.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sendtk.app.models.Liste;
import com.sendtk.app.models.dao.ListeDAO;

@Controller
@RequestMapping()
public class IndexController {
	
	@Autowired
	ListeDAO ModelListe;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView MV = new ModelAndView("campaign/New");
		return MV;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(){
		
		/**
		 *	Add new Liste 
		 **/
		Liste _List = new Liste();
		_List.setReference(ModelListe.generateReference());
		_List.setISP("HOTMAIL");
		_List.setType("FRESH");
		_List.setName(ModelListe.generateName("HOTMAIL","FRESH"));
		_List.setCount(0);
		_List.setDateEntree(new Date());
		_List.setLastModif(new Date());
		_List.setActive(1);
		 ModelListe.AddListe(_List);
		 
		 
		ModelAndView MV = new ModelAndView("campaign/test");
		return MV;
	}
}
