package com.sendtk.app.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sendtk.app.models.Role;
import com.sendtk.app.models.dao.UserDAO;

 

@Service("userDetailsService")
public class UserService implements UserDetailsService{

	 
	@Autowired
	private UserDAO MyUser;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		com.sendtk.app.models.User user = MyUser.findByUserName(username);
		if(user == null) return null;
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
		return buildUserForAuthentication(user, authorities);
	}
	
	// Converts com.sendtk.app.models.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.sendtk.app.models.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPasswd(), user.isActive(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority( Role userRole) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
