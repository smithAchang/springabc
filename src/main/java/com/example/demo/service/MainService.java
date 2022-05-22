package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Emploee;
import com.example.demo.repository.EmploeeMapper;
import com.example.demo.tasks.JobTasks;

@Service
public class MainService {
	
	private final EmploeeMapper dao;
	

	private final JobTasks asyncJobTasks;
	
	@Autowired
	public MainService(EmploeeMapper dao, JobTasks asyncJobTasks)
	{
		this.dao = dao;
		this.asyncJobTasks = asyncJobTasks;
	}
	
	public int insertEmployee(Emploee newEmployee)
	{
		return dao.insert(newEmployee);
	}
	
	public List<Emploee> getAllUsers()
	{
		return dao.getAllUsers();
	}

}
