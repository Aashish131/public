package com.portal.service;

import java.util.List;
import com.portal.models.Project;

public interface ProjectService {
	public List<Project> getAllProjects();
	public Project getProjectById(String projectId);
	public boolean updateProject(Project pObj);

}