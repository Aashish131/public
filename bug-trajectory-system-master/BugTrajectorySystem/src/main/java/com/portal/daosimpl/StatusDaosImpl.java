package com.portal.daosimpl;
	
	import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	
	import com.portal.daos.StatusDao;
	import com.portal.models.BugStatus;
	
	@Repository("StatusDao")
	public class StatusDaosImpl implements StatusDao{
	       @Autowired
	    SessionFactory sessionFactory;
	       public List<BugStatus> getAllStatus() {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                  Query q=session.createQuery("from com.portal.models.BugStatus");
	                  List<BugStatus> statusList=q.list();
	                  return statusList;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return null;
	       }
	       public boolean updateStatus() {
	              // TODO Auto-generated method stub
	              return false;
	       }
	
	}

