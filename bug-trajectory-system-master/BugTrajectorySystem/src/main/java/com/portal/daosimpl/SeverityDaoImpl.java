package com.portal.daosimpl;
	
	import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	
	import com.portal.daos.SeverityDaos;
	import com.portal.models.Severity;
	@Repository("SeverityDaos")
	public class SeverityDaoImpl implements SeverityDaos {
	       @Autowired
	    SessionFactory sessionFactory;
	       public List<Severity> getAllSeverity() {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                  Query q=session.createQuery("from com.portal.models.Severity");
	                  List<Severity> sList=q.list();
	                  return sList;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return null;
	       }
	
	}

