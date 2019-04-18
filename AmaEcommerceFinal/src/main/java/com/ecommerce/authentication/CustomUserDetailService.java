package com.ecommerce.authentication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserInfoDAO;
import com.ecommerce.entity.UserRole;
import com.ecommerce.entity.UserRoleMapping;
import com.ecommerce.entity.Users;
import com.ecommerce.model.UserInfo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserInfoDAO userInfoDAO;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		System.out.println("in loadUserByUsername ");
		/*UserInfo userInfo = userInfoDAO.findUserInfo(username);
		System.out.println("UserInfo= " + userInfo);

		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}*/
		System.out.println("WTF "+username);
		System.out.println("username "+username);
		Users user = userInfoDAO.findUserInfo(username);
		System.out.println("UserInfo= " + user.getId());

		// [USER,ADMIN,..]
		List <UserRoleMapping> userRoleList= userInfoDAO.getUserRoles(user.getId());
		GrantedAuthority authority=null;
		 List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (UserRoleMapping userRole : userRoleList) {
			if(userRole.getUserRoleMappingId().getRole_id()==1){
				authority= new SimpleGrantedAuthority("ROLE_ADMIN");
			}else if(userRole.getUserRoleMappingId().getRole_id()==3){
				authority= new SimpleGrantedAuthority("ROLE_VENDOR");
			}
			else{
				authority= new SimpleGrantedAuthority("ROLE_USER");
			}
			/*authority= new SimpleGrantedAuthority("ROLE_"+userRole.getUserRoleMappingId());*/
			 grantList.add(authority);
		}
		 System.out.println("grantList size "+grantList.size());
       
 
        // ROLE_EMPLOYEE, ROLE_MANAGER
         
      /*  boolean enabled = false;
        		if(user.getActive()==1){
        			enabled=true;
        		}*/
        			
       /* boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;*/
 
        UserDetails userDetails = (UserDetails) new User(user.getUsername(), //
        		user.getPassword(), grantList);
 
        return userDetails;
	}

}
