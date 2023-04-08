package com.revature.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.revature.daos.UserDAO;

import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class UserService {

	private UserDAO uDAO = new UserDAO();
	
	public Users validateUser(String username, String password) {
		return uDAO.getUserByUsernamePassword(username,password);
	}
	
	public List<Users> getAllUsers()
	{
		return uDAO.getAllUsers();
	}
	
	public void addUser(Users user) {
		//return;
		 uDAO.addUser(user);
	}
	


	public Users getUserByUsername(String username) {
	    Session ses = HibernateUtil.getSession();

	    CriteriaBuilder cb = ses.getCriteriaBuilder();
	    CriteriaQuery<Users> query = cb.createQuery(Users.class);
	    Root<Users> root = query.from(Users.class);
	    query.select(root).where(cb.equal(root.get("username"), username));

	    List<Users> users = ses.createQuery(query).getResultList();

	    if (users.size() > 0) {
	        return users.get(0);
	    } else {
	        return null;
	    }
	}

}
