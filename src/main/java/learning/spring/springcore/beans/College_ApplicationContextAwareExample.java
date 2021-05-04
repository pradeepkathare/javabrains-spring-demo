package learning.spring.springcore.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//College has Student and college address
//Check xml,to see how to inject objects in college class
//use property tag with name and refernce sub-tags in xml
public class College_ApplicationContextAwareExample implements ApplicationContextAware {

	Student student;
	Address studentAddress;
	Address collegeAddress;

	private ApplicationContext applicationContext;
	
	public College_ApplicationContextAwareExample(Student student ,Address studentAddress,Address collegeAddress) {
		this.student=student;
		this.studentAddress=studentAddress;
		this.collegeAddress=collegeAddress;
	}
	
	//since student is prototype,then use applicationcontext.getBean everytime
	public Student getStudent() {
		
		return (Student) applicationContext.getBean("student");
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
		System.out.println("Student details={}" + student.toString());
		System.out.println("student Address={}" + studentAddress.toString());
		System.out.println("college Address={}" + collegeAddress.toString());
	}

	//this will be created as soon as ApplicationContext class is loaded/initialized/created
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setting application-context");
		this.applicationContext = applicationContext;
		
	}
}
