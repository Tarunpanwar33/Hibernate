package com.jspiders.Hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.Hibernate.dto.Student;

public class studentdao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
public static void main(String[] args) {
	openconnection();
	entityTransaction.begin();
	
	Student student = new Student();
	student.setSid(1);
	student.setName("Ankit");
	student.setEmail("ankit@gmail.com");
	student.setAge(26);
	student.setFees(55000);
	
	entityManager.persist(student);
	
	
	entityTransaction.commit();
    closeconnection();
}
	
	
	public static void openconnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
	     entityTransaction = entityManager.getTransaction();
		
		
	}
	
	public static void closeconnection() {
		
		if (entityManagerFactory!=null) {
			
			entityManagerFactory.close();
		}
		
		if (entityManager!=null) {
			
			entityManager.close();
		}
		
		if (entityTransaction!= null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			
		}
	}
	
	
}
	