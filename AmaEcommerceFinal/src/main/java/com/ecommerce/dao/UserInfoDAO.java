package com.ecommerce.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.UserRoleMapping;
import com.ecommerce.entity.Users;

@Repository
@Transactional
public class UserInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserInfoDAO() {

	}

	/*public UserInfo findUserInfo(String userName) {
		String sql = "Select new " + UserInfo.class.getName() + "(u.username,u.password,u.ispassworddefault) "//
				+ " from " + User.class.getName() + " u where u.username = :username and u.rowstate>=1";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		query.setParameter("username", userName);

		return (UserInfo) query.uniqueResult();
	}*/
	
	public Users findUserInfo(String userName) {
		System.out.println("in findUserInfo");
		Users users=null;
		try {
			Session session = sessionFactory.getCurrentSession();
			//users=(Users) session.get(Users.class, userName.trim());
	        Criteria crit = session.createCriteria(Users.class)
	        		.add(Restrictions.eq("username", userName));
	        users=(Users) crit.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	        return users;
	}
	
	public ArrayList<UserRoleMapping> getUserRoles(int roleid) {
		/*String sql = "Select r.userRole "//
		+ " from " + UserRole.class.getName() + " r where r.user.username = :username and r.rowstate>=1";*/
		System.out.println("roleid "+roleid);
		ArrayList<UserRoleMapping> roleMappings= null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria crit = session.createCriteria(UserRoleMapping.class)
					.add(Restrictions.eq("userRoleMappingId.user_id", roleid));
			roleMappings= (ArrayList<UserRoleMapping>) crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*Query query = session.createQuery(sql);
		query.setParameter("username", userName);

		@SuppressWarnings("unchecked")
		List<String> roles = query.list();*/

		return  roleMappings;
		}

}
