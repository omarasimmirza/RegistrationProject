package mainClasses;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Student {

	private String name;
	private String birthday;
	private int studentId;
	private String gender;
	private int ssn;
	private String address1;
	private String address2;
	private String phoneNum;
	private String mobileNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

//	public ArrayList<Course> getStudentCourseList() {
//		return studentCourseList;
//	}

//	public void addToStudentCourseList(Course course) {
//		studentCourseList.add(course);
//	}

//	public ArrayList<Classes> getStudentClassList() {
//		return studentClassList;
//	}

//	public void addToStudentClassList(Classes class_) {
//		studentClassList.add(class_);
//	}

//	public void displaySchedule() {
//		if (studentClassList.isEmpty()) {
//			System.out.println("\nNo classes");
//		} else {
//			System.out.println("\nStudent course list:");
//
//			for (int i = 0; i < studentCourseList.size(); i++) {
//				System.out.println(studentCourseList.get(i));
//				System.out.println(studentClassList.get(i) + "\n");
//			}
//		}
//	}
};