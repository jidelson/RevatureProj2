package com.revature.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.revature.daos.SubjectDAO;
import com.revature.models.Subject;
import com.revature.utils.HibernateUtil;

public class SubjectService {
	private static SubjectDAO sDAO = new SubjectDAO();

	public List<Subject> getAllSubjects()
	{
		return sDAO.getAllSubjects();
	}
	
	public void addSubject(Subject subject) {
		sDAO.addSubject(subject);
	}

	public Subject getSubjectByName(String name) {
	    Session ses = HibernateUtil.getSession();

	    CriteriaBuilder cb = ses.getCriteriaBuilder();
	    CriteriaQuery<Subject> query = cb.createQuery(Subject.class);
	    Root<Subject> root = query.from(Subject.class);
	    query.select(root).where(cb.equal(root.get("name"), name));

	    List<Subject> subjects = ses.createQuery(query).getResultList();

	    if (subjects.size() > 0) {
	        return subjects.get(0);
	    } else {
	        return null;
	    }
	}

}
