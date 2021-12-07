package StudentManagementCRUD_MVC.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import StudentManagementCRUD_MVC.gl.entities.Student;
import StudentManagementCRUD_MVC.gl.service.IStudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping("/list")
	public String ListStudents(Model model) {
		List<Student> students = studentService.FindAllStudents();
		model.addAttribute("Students", students);
		System.out.println(students);
		return "StudentView";
	}
	
	@RequestMapping("/addForm")
	public String AddForm(Model model) {
		Student student = new Student();
		model.addAttribute("Students", student);
		return "StudentForm";
	}
	
	@RequestMapping("/updateForm")
	public String UpdateForm(@RequestParam("StudentId")int id, Model model) {
		Student student = studentService.FindStudentById(id);
		model.addAttribute("Studemt", student);
		
		return "StudentForm";
	}
	
	@PostMapping("/save")
	public String SaveStudentData(@RequestParam("id")int id, @RequestParam("name")String name,
			@RequestParam("department")String department, @RequestParam("country") String country) {
		
		System.out.println("The Id for the Studnet is : "+id);
		Student student;
		if(id!=0) {
			student = studentService.FindStudentById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}else {
			student = new Student(name, department, country);
		}
		
		studentService.SaveStudentData(student);
		
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String DeleteStudentData(@RequestParam("StudnetId")int id) {
		studentService.DeleteStudentData(id);
		return "redirect:/students/list";
	}
}
