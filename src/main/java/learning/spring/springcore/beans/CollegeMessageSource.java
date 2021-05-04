package learning.spring.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

//College has Student and college address
//Check xml,to see how to inject objects in college class
//use property tag with name and refernce sub-tags in xml
@Component
public class CollegeMessageSource implements University {

	Student student;
	Address studentAddress;
	Address collegeAddress;
	
	@Autowired
	MessageSource messagesource;
	
	public CollegeMessageSource() {
		System.out.println("default constructor");
	}
	public CollegeMessageSource(Student student ,Address studentAddress,Address collegeAddress) {
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

	@Autowired
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Address getCollegeAddress() {
		return collegeAddress;
	}

	@Autowired
	public void setCollegeAddress(Address collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public void collegeDetails() {
		System.out.println("college details of College class");
		System.out.println("Student details={}" + student.toString());
		System.out.println("student Address={}" + studentAddress.toString());
		System.out.println("college Address={}" + collegeAddress.toString());
		printMessageSource();
	}
	
	void printMessageSource() {
		System.out.println(messagesource.getMessage("greeting", null, "Default Message absece of key", null));
		System.out.println(messagesource.getMessage("dynamicMessage", new Object[] {"parameter 0"," parametr1"}, "defaultMessage", null));
	}
}
