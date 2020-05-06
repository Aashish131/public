package com.portal.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.daos.StatusDao;
import com.portal.models.BugStatus;
import com.portal.service.StatusService;


@Transactional
@Service("StatusService")
public class StatusServiceImpl implements StatusService{
@Autowired
StatusDao statusDao;
	public List<BugStatus> getAllStatus() {
			return statusDao.getAllStatus();
	}

}