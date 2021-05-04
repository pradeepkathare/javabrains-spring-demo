package learning.spring.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//College has Student and college address
//Check xml,to see how to inject objects in college class
//use property tag with name and refernce sub-tags in xml
public class CollegeJSRAnnotation implements University {

	Student student;
	Address studentAddress;
	Address collegeAddress;
		
	public CollegeJSRAnnotation() {
		System.out.println("default constructor");
	}
	public CollegeJSRAnnotation(Student student ,Address studentAddress,Address collegeAddress) {
		System.out.println("paramater constructor");
		this.student=student;
		this.studentAddress=studentAddress;
		this.collegeAddress=collegeAddress;
	}
	
	public Student getStudent() {
		return student;
	}

	//JSR annotation same as autowiring and qualifier
	@Resource(name="studentdetail")
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

	@PostConstruct
	public void init() {
		System.out.println("CollegeJSRAnnotation init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("CollegeJSRAnnotation init method");
	}
	public void collegeDetails() {
		System.out.println("college details of College class");
		System.out.println("Student details={}" + student.toString());
		System.out.println("student Address={}" + studentAddress.toString());
		System.out.println("college Address={}" + collegeAddress.toString());
	}
}
