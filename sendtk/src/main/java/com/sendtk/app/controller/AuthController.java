package com.sendtk.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sendtk.app.models.User;
import com.sendtk.app.models.dao.UserDAO;

@Controller
@RequestMapping("/Auth")
public class AuthController {

	@Autowired
	UserDAO User;

	/** Spring Security see this */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView MV = new ModelAndView();
		MV.addObject("toot", "dddd");
		MV.setViewName("/auth/login");
		return MV;
	}
	
	@RequestMapping(value = "/Validate", method = RequestMethod.POST, headers = "Accept=*")
	@ResponseBody
	public String validate(@RequestBody String data) {
		System.out.println("ok");
		return "ok";
	}
	
	@RequestMapping(value = "/expired")
	public ModelAndView expiredSession(Principal p) {
		User _User = User.findByUserName(p.getName());
		ModelAndView M_V = new ModelAndView();
		M_V.setViewName("/auth/expired");
		M_V.addObject(_User);
		return M_V;
	}
}
