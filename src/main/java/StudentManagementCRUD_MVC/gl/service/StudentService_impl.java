package StudentManagementCRUD_MVC.gl.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import StudentManagementCRUD_MVC.gl.entities.Student;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService_impl implements IStudentService{
	
	private SessionFactory sessionFactory; 
	private Session session;
	
	@Autowired
	public StudentService_impl(SessionFactory sessionFactory) {
		System.out.println("sessionFactory VALID :::::::::::");
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch(HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}
	
	@Override
	public List<Student> FindAllStudents() {
		Transaction tx = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();
		System.out.println("Student list : "+students);
		return students;
	}

	@Override
	public Student FindStudentById(int id) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		tx.commit();
		System.out.println("Found student  : "+student);
		return student;
	}

	@Override
	public void SaveStudentData(Student student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		System.out.println("Updated student  : "+student);
		tx.commit();
	}

	@Override
	public void DeleteStudentData(int id) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		if(student != null) {
			System.out.println("Deleting student  : "+student);
			session.delete(student);
		}
		tx.commit();
	}
}
