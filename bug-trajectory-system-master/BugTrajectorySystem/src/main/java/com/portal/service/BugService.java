package com.portal.service;

import java.util.List;

import com.portal.models.BugType;

public interface BugService {
	public List<BugType> getAllBug();
	public BugType getBugById(int bId);
}