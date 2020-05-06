package com.portal.daosimpl;
	
	import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	
	import com.portal.daos.BugDaos;
	import com.portal.models.BugType;
	
	@Repository("BugDaos")
	public class BugDaosImpl implements BugDaos{
	       @Autowired
	    SessionFactory sessionFactory;
	       public List<BugType> getAllBug() {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                  Query q=session.createQuery("from com.portal.models.BugType");
	                  List<BugType> bugList=q.list();
	                  return bugList;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return null;
	       }
	       public BugType getBugById(int bId) {
	              try {
	                     Session session=sessionFactory.getCurrentSession();
	                     BugType bugTypeList=session.get(BugType.class, bId);
	                     return bugTypeList;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	
	              return null;
	       }
	
	}

