package learning.spring.springcore.beans;

import java.util.List;



//College has Student and college address
//Check xml,to see how to inject objects in college class
//use property tag with name and subtag list and refernce attribute in xml
//Spring Internally cast list of students defined in xml to  student type

public class Colleges {

	List<Student> students;
	Address studentAddress;
	Address collegeAddress;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
		
		for(Student student:students) {
			System.out.println("Student details={}" + student.toString());
		}
		
		System.out.println("student Address={}" + studentAddress.toString());
		System.out.println("college Address={}" + collegeAddress.toString());
	}
}
