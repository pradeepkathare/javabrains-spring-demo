package learning.spring.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//College has Student and college address
//Check xml,to see how to inject objects in college class
//use property tag with name and refernce sub-tags in xml
public class CollegeBeanLifeCycle implements InitializingBean ,DisposableBean,University{

	Student student;
	Address studentAddress;
	Address collegeAddress;

	
	public CollegeBeanLifeCycle() {
		System.out.println("default constructor");
	}
	public CollegeBeanLifeCycle(Student student ,Address studentAddress,Address collegeAddress) {
		System.out.println("Constructor of CollegeBeanLifeCycle class");
		this.student=student;
		this.studentAddress=studentAddress;
		this.collegeAddress=collegeAddress;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Address getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(Address collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public void collegeDetails() {
		System.out.println("collegeDetails of CollegeBeanLifeCycle");
		System.out.println("Student details={}" + student.toString());
		System.out.println("student Address={}" + studentAddress.toString());
		System.out.println("college Address={}" + collegeAddress.toString());
	}
	
	
	public void destroy() throws Exception {
		System.out.println("used to destroy/closing connections");
		
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("used to initalizing after bean creations");
		
	}
	
	
	public void init() {
		System.out.println("Global init cutom method");
	}
	
	public void destroyGlobal() {
		System.out.println("global destroy method");
	}
}
