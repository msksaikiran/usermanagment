package com.sdnext.hibernate.tutorial.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.bridgelabz.hibernetdemo.Student;

public class HibernateUtil {
	private static SessionFactory sessionfactory = null;
	static {
		try {
			Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
					.buildServiceRegistry();
			sessionfactory = con.buildSessionFactory(reg);
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionfactory;
	}
}