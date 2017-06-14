package com.galaxe.rst;


public interface EmployeeService {
	public void save(Employee emp);
	public boolean authenticate(int id,String password);
	public Employee getDetails(int id);
	public void update(Employee emp);
	
}
