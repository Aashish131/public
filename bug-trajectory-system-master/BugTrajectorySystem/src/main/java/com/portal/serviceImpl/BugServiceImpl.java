package com.portal.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.daos.BugDaos;
import com.portal.models.BugType;
import com.portal.service.BugService;

@Transactional
@Service("BugService")
public class BugServiceImpl implements BugService {
 @Autowired
 BugDaos bugDao;
	public List<BugType> getAllBug() {
		System.out.println(bugDao.getAllBug());
		return bugDao.getAllBug();
	}
	public BugType getBugById(int bId) {
		return bugDao.getBugById(bId);
	}

}