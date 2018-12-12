package com.neusoft.saca.dataviz.authentication.cas;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.neusoft.saca.dataviz.common.security.DefaultUser;
import com.neusoft.saca.dataviz.system.bo.UserBO;
import com.neusoft.saca.dataviz.system.service.UserService;

@Transactional
@Slf4j
public class SampleUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserService userService;
	
	private Set<GrantedAuthority> defaultAuthorities;

	public SampleUserDetailsService() {
		log.error("=================================UserDetailService=============================");
		defaultAuthorities = new HashSet<GrantedAuthority>(1);
		defaultAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		log.error(username + "===============================");
		UserBO userBO = this.userService.getUserByloginID(username);
		if (userBO == null) {
			throw new UsernameNotFoundException("User [" + username
					+ "] not found.");
		}
		DefaultUser user = userService.isAdminLogin(userBO)
				? new DefaultUser(userBO.getId(), "", new SimpleGrantedAuthority("ROLE_USER"))
				: new DefaultUser(userBO.getId(), "");
		log.error(user + "===============================");
		if (userBO.getState() == UserBO.STATE_INVALID) {
			user.setLocked(true);
		}
		return user;
	}
}
