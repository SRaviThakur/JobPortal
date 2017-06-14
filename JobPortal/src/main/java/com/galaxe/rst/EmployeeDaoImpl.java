package com.galaxe.rst;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	SessionFactory sf;
	

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		Session s =sf.openSession();
		s.beginTransaction();
		s.save(emp);
		s.getTransaction().commit();
		s.close();
		
	}

	@Override
	public boolean authenticate(int id, String password) {
		// TODO Auto-generated method stub
Session s =sf.openSession();
		
		Criteria ctr = s.createCriteria(Employee.class);
		List list =	ctr.add(Restrictions.eq("id",id)).add(Restrictions.eq("password",password)).list();
		
		s.close();
		
		if (!list.isEmpty())
		{
			System.out.println("Authorized user");
			return true;
		}
		return false;
	}

	public Employee getDetails(int id) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
	    sess.beginTransaction();  
	    Employee emp= (Employee) sess.get(Employee.class,id);
//	    Emlpoyee std = (Employee) sess.get(Employee.class);
	    sess.getTransaction().commit();
	    sess.close();
	 //   return std;
		
		return emp;
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
	    sess.beginTransaction();  
	    sess.update(emp);
	    sess.getTransaction().commit();
	    sess.close();
		
		
	}

	
	

}
