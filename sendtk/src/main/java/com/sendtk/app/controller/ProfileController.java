package com.sendtk.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sendtk.app.models.User;
import com.sendtk.app.models.dao.UserDAO;



@Controller
@RequestMapping("/Profile")
public class ProfileController {

	@Autowired	
	UserDAO UserService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView NewCampaign( Principal  p){
		ModelAndView MV = new ModelAndView("profile/index");
		User CurrentUser = UserService.findByUserName(p.getName());	
		MV.addObject(CurrentUser);
		return MV;
	}
}
