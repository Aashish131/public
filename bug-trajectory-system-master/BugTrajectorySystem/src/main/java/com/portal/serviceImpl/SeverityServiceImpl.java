package com.portal.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.daos.SeverityDaos;
import com.portal.models.Severity;
import com.portal.service.SeverityService;

@Transactional
@Service("SeverityService")
public class SeverityServiceImpl implements SeverityService {
@Autowired
SeverityDaos severityDao;
	public List<Severity> getAllSeverity() {
		return severityDao.getAllSeverity();
	}

}