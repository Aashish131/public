  
package com.portal.service;

import java.util.List;


import com.portal.models.BugAllocationDetails;

public interface BugAllocationService {
	public boolean saveBugDetails(BugAllocationDetails bugAllocate);
	public List<BugAllocationDetails> getAllBugDesc();
	public BugAllocationDetails getBugAllocationById(int bugAllocateId);
	public boolean update(BugAllocationDetails bugAllocate);

}