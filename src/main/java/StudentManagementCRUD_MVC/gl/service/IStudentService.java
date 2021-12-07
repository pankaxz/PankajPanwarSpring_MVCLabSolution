package StudentManagementCRUD_MVC.gl.service;

import java.util.List;
import org.springframework.stereotype.Service;

import StudentManagementCRUD_MVC.gl.entities.Student;

@Service
public interface IStudentService {
	public List<Student> FindAllStudents();
	
	public Student FindStudentById(int id);
	
	public void SaveStudentData(Student student);
	
	public void DeleteStudentData(int id);
	
}
