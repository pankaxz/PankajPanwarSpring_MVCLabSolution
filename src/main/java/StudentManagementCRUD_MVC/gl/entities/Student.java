package StudentManagementCRUD_MVC.gl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentTable")
public class Student {

	@Id
	@Column(name="Student Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Name")
	private String studentName;
	
	@Column(name = "Department")
	private String department;
	
	@Column(name = "Country")
	private String country;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return studentName;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.studentName = name;
	}
	
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Student() {
		System.out.println("Creating student class");
	};
	
	public Student(int id, String name, String department, String country) {
		super();
		this.id = id;
		this.studentName = name;
		this.department = department;
		this.country = country;
	}
	
	public Student(String name, String department, String country) {
		super();
		this.studentName = name;
		this.department = department;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", department=" + department + ", country="
				+ country + "]";
	}
	
}
