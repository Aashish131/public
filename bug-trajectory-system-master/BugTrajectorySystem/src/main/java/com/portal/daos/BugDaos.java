package com.portal.daos;
	
	import java.util.List;
	
	import com.portal.models.BugType;
	
	
	
	public interface BugDaos {
	       public List<BugType> getAllBug();
	       public BugType getBugById(int bId);
	}

