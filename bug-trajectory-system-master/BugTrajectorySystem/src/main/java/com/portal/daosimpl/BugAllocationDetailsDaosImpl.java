package com.portal.daosimpl;
	
	import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	
	import com.portal.daos.BugAllocationDetailsDaos;
	import com.portal.models.BugAllocationDetails;
	
	
	@Repository("BugAllocationDetailsDaos")
	public class BugAllocationDetailsDaosImpl implements BugAllocationDetailsDaos {
	       @Autowired
	    SessionFactory sessionFactory;
	       public boolean saveBugDetails(BugAllocationDetails bugAllocate) {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                 session.save(bugAllocate);
	                 System.out.println("bug allocated"
	                 		+ ""+bugAllocate);
	                 return true;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return false;
	       }
	       
	       public List<BugAllocationDetails> getAllBugDesc() {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                  Query q=session.createQuery("from com.portal.models.BugAllocationDetails");
	                  List<BugAllocationDetails> bugList=q.list();
	                  return bugList;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return null;
	       }
	       public boolean update(BugAllocationDetails bugAllocate) {
	              try {
	                     Session session=sessionFactory.getCurrentSession();
	                     session.update(bugAllocate);
	                     return true;
	              }
	              catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return false;
	       }
	
	       public BugAllocationDetails getBugAllocationById(int bugAllocateId) {
	              try {
	                     Session session=sessionFactory.getCurrentSession();
	                     BugAllocationDetails bugALlocation=session.get(BugAllocationDetails.class,bugAllocateId);
	                     return bugALlocation;
	              }
	              catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return null;
	       }
	
	
	}

