package learning.spring.springcore.beans;

import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

//College has Student and college address
//Check xml,to see how to inject objects in college class
//use property tag with name and refernce sub-tags in xml
public class CollegeAutowiringAnnotation implements University {

	Student student;
	Address studentAddress;
	Address collegeAddress;
		
	public CollegeAutowiringAnnotation() {
		System.out.println("default constructor");
	}
	public CollegeAutowiringAnnotation(Student student ,Address studentAddress,Address collegeAddress) {
		System.out.println("paramater constructor");
		this.student=student;
		this.studentAddress=studentAddress;
		this.collegeAddress=collegeAddress;
	}
	
	public Student getStudent() {
		return student;
	}

	//in bean changed,bean id student to studentdetail.so while injecting it will look for byte
	@Autowired
	@Qualifier(value = "studentdetail") 
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
		System.out.println("college details of College class");
		System.out.println("Student details={}" + student.toString());
		System.out.println("student Address={}" + studentAddress.toString());
		System.out.println("college Address={}" + collegeAddress.toString());
	}
}
