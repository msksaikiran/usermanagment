package com.bridgelabz.hibernetdemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//import com.sdnext.hibernate.tutorial.dto.Student;
import com.sdnext.hibernate.tutorial.utility.HibernateUtil;

public class ReadStudent {

 /**
  * @param args
  */
 public static void main(String[] args) 
 {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
 	Query query = session.createQuery("from Student");
 	List student = query.list();
 	 
	for(Object studentt : student)
 	  {
 	System.out.println("Sfname: "+((Student) studentt).getSfname()+", Student id:"+((Student)studentt).getSid()+", sname: "+((Student) studentt).getSname());
 	  }
 	org.hibernate.Transaction tx=session.beginTransaction();	
    // student=(Student)session.get(Student.class, 10);
      tx.commit();
     // System.out.println(student);
 }
}
