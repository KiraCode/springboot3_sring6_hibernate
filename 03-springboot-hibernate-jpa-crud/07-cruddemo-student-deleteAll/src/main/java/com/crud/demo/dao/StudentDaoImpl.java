package com.crud.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {

	private EntityManager manager;

	@Autowired
	public StudentDaoImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		manager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return manager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = manager.createQuery("FROM Student order by lastName asc", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = manager.createQuery("FROM Student where lastName=:theData", Student.class);
		theQuery.setParameter("theData", lastName);
		return theQuery.getResultList();
	}

	@Transactional
	@Override
	public void update(Student student) {
		manager.merge(student);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Student student = manager.find(Student.class, id);
		manager.remove(student);
	}

	@Transactional
	@Override
	public int deleteAll() {
		int deletedRowCounts = manager.createQuery("DELETE from Student").executeUpdate();
		return deletedRowCounts;
	}

}
