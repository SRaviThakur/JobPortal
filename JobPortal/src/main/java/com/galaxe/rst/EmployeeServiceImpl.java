package com.galaxe.rst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	
	EmployeeDao empDao;
	@Autowired
	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	public EmployeeDao getEmpDao() {
		return empDao;
	}
	public void save(Employee emp)
	{
		empDao.save(emp);
	}
	public boolean authenticate(int id,String password)
	{

		return empDao.authenticate(id, password);
	}
	public Employee getDetails(int id)
	{
		return empDao.getDetails(id);
	}
	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		 empDao.update(emp);
		
	}
	
}