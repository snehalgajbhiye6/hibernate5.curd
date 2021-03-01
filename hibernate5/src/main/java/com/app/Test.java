package com.app;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class Test {
	public void save()
	{
		Session session=Hibernate_Utility.getSessionFactory().openSession();
		Employee emp=new Employee();
	    emp.setName("snehal");
	    session.save(emp);
	    session.beginTransaction().commit();
	    System.out.println("success");
	}
	public void findAll()
	{
		Session session=Hibernate_Utility.getSessionFactory().openSession();
		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
	    cq.from(Employee.class);
	    List<Employee> list=session.createQuery(cq).getResultList();
	    list.forEach(System.out::println);
	}
	public Employee select()
	{
		Session session=Hibernate_Utility.getSessionFactory().openSession();
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq=session.getCriteriaBuilder().createQuery(Employee.class);
		Root<Employee> root=cq.from(Employee.class);
		cq.select(root);
		cq.where(cb.equal(root.get("id"), 2));
		Employee emp=session.createQuery(cq).getSingleResult();
		System.out.println(emp);
		return emp;
	}
	public void delete()
	{
		Employee emp=select();
		Session session=Hibernate_Utility.getSessionFactory().openSession();
		session.delete(emp);
		session.beginTransaction().commit();
	}
	public static void main(String[] args) {
		Test t=new Test();
		//t.save();
        //t.findAll();
        //t.select();
		t.delete();
	}

}
