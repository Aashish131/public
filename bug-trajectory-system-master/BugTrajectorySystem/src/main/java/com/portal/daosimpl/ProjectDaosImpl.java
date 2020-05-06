	package com.portal.daosimpl;
	
	import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import com.portal.daos.ProjectDaos;
	import com.portal.models.Project;
	
	
	@Repository("ProjectDaos")
	
	public class ProjectDaosImpl implements ProjectDaos{
	       @Autowired
	     SessionFactory sessionFactory;
	       
	       public List<Project> getAllProjects() {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                  Query q=session.createQuery("from com.portal.models.Project");
	                  List<Project> pList=q.list();
	                  return pList;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return null;
	       }
	       public Project getProjectById(String projectId) {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                  Project pObj=session.get(Project.class, projectId);
	                  return pObj;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return null;
	       }
	       public boolean updateProject(Project pObj) {
	              try{
	                     Session session=sessionFactory.getCurrentSession();
	                  session.update(pObj);
	                  return true;
	              }catch (Exception e) {
	                     e.printStackTrace();
	              }
	              return false;
	       }
	
	
	}

