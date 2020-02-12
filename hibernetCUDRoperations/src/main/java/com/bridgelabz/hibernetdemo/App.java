package com.bridgelabz.hibernetdemo;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sdnext.hibernate.tutorial.utility.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Scanner scan = new Scanner(System.in);
		System.out.println("1.create table");
		System.out.println("2.read data form table");
		System.out.println("3.update data in the table");
		System.out.println("4.delete the data in the table");
		System.out.println("enter ur choice");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			create(session);
			sf.close();
			break;
		case 2:
			read(session);
			sf.close();
			break;
		case 3:
			update(session);
			sf.close();
			break;
		case 4:
			delete(session);
			sf.close();
			break;
		default:
			System.out.println("Invalid input");
		}
		scan.close();
	}

	private static void delete(Session session) {
		try {
			Student student = (Student) session.load(Student.class, 1);
			if (student != null) {
				Transaction tx = session.beginTransaction();
				session.delete(student);
				tx.commit();
				System.out.println("deleted...");
			} else {
				System.out.println("not deleted...");
			}
		} catch (Exception ae) {
			System.out.println("invalid...");
		}
	}

	private static void update(Session session) {
		
		try {
			Student student = (Student) session.get(Student.class, 1);
			if (student != null) {
				Transaction tx = session.beginTransaction();
				student.setSname("kiran");
				tx.commit();
				System.out.println("Updated...");
			} else {
				System.out.println("not updated...");
			}
		} catch (Exception ae) {
			System.out.println("invalid...");
		}

	}

	public static void create(Session session) {

		Student st = new Student();
		st.setSfname("thrinath1");
		st.setSid(1);
		st.setSname("sai1");
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();
		System.out.println("Details added sucessfully....");
	}

	public static void read(Session session) {

		Query query = session.createQuery("from Student");
		List student = query.list();
		Transaction tx = session.beginTransaction();
		for (Object studentt : student) {
			System.out.println("Sfname: " + ((Student) studentt).getSfname() + ", Student id:"
					+ ((Student) studentt).getSid() + ", sname: " + ((Student) studentt).getSname());
		}
		tx.commit();
	}
}
