package com.portal.daos;
	
	import java.util.List;
	
	import com.portal.models.Project;
	
	public interface ProjectDaos {
	
	       public List<Project> getAllProjects();
	       public Project getProjectById(String projectId);
	       public boolean updateProject(Project pObj);
	       
	}
