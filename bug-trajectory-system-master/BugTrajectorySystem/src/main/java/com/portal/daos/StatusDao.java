package com.portal.daos;
	
	import java.util.List;
	
	import com.portal.models.BugStatus;
	
	
	public interface StatusDao {
	       public List<BugStatus> getAllStatus();
	       public boolean updateStatus();
	       
	}

