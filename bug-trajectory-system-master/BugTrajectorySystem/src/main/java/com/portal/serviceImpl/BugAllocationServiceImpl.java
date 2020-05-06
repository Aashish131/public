package com.portal.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.daos.BugAllocationDetailsDaos;
import com.portal.models.BugAllocationDetails;
import com.portal.service.BugAllocationService;



@Transactional
@Service("BugAllocationService")
public class BugAllocationServiceImpl implements BugAllocationService {

	@Autowired
	BugAllocationDetailsDaos bugAllocationDetailDao;
	public boolean saveBugDetails(BugAllocationDetails bugAllocate) {
		return bugAllocationDetailDao.saveBugDetails(bugAllocate);
	}
	
	public List<BugAllocationDetails> getAllBugDesc() {
		return bugAllocationDetailDao.getAllBugDesc();
	}

	public boolean update(BugAllocationDetails bugAllocate) {
		return bugAllocationDetailDao.update(bugAllocate);
	}

	public BugAllocationDetails getBugAllocationById(int bugAllocateId) {
		return bugAllocationDetailDao.getBugAllocationById(bugAllocateId);
	}

}