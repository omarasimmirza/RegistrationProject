package mainClasses;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dataAccessObjectClasses.CourseJDBCTemplate;
import dataAccessObjectClasses.RegisteredStudentJDBCTemplate;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegistrationManager {
	ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

	private CourseJDBCTemplate course = factory.getBean(CourseJDBCTemplate.class);
	private RegisteredStudentJDBCTemplate registeredStudent = factory.getBean(RegisteredStudentJDBCTemplate.class);
	private static int hours = 0;

	public void displayCourses() {
		List<Course> courses = course.listCourse();
		for (Course record : courses) {
			System.out.println("\nCourseId: " + record.getCourseId());
			System.out.println("CourseLevel: " + record.getCourseLevel());
			System.out.println("CourseTitle: " + record.getCourseTitle());
			System.out.println("CreditHours: " + record.getCreditHours());
			System.out.println("Location: " + record.getLocation());
			System.out.println("Time: " + record.getTime());
			System.out.println("Instructor: " + record.getInstructor());
			System.out.println("InstructorId: " + record.getInstructorId());
		}
	}

	public void register(int studentId, int courseId, int instructorId) {
		List<RegisteredStudent> student = registeredStudent.getRegisteredStudent(studentId);
		boolean currentCourse = false;
		for (RegisteredStudent record : student) {
			if (record.getCourseId() == courseId) {
				currentCourse = true;
			}
		}
		if (!registeredStudent.registeredStudentList().isEmpty()) {
			hours = registeredStudent.getCreditHours(studentId);
		} else {
			hours = 0;
		}
		if (hours <= 15 && !currentCourse) {
			hours += course.getHours(courseId);
			registeredStudent.create(studentId, courseId, instructorId, hours);
		} else if (hours >= 15) {
			System.out.println("\nYou have reached the hour limit (15) per semester.");
		} else {
			System.out.println("\nYou are already registered in that course.");
		}
	}

//	public void register(Student student, List<Course> course, List<Classes> classes, String courseTitle) {
//		for (int i = 0; i < course.size(); i++) {
//			if (course.get(i).getCourseTitle().equals(courseTitle)) {
//				student.addToStudentCourseList(course.get(i));
//				student.addToStudentClassList(classes.get(i));
//				hours += course.get(i).getCreditHours();
//				numOfCourses++;
//				System.out.println("\nRegistered " + courseTitle);
//			}
//		}
//	}
//
//	public void dropClass(Student student, String courseTitle) {
//		int temp = -1;
//		for (int i = 0; i < student.getStudentCourseList().size(); i++) {
//			if (student.getStudentCourseList().get(i).getCourseTitle().equals(courseTitle)) {
//				temp = i;
//				hours -= student.getStudentCourseList().get(i).getCreditHours();
//				numOfCourses--;
//				System.out.println("\nDropped " + courseTitle);
//			}
//		}
//		if (temp != -1) {
//			student.getStudentCourseList().remove(temp);
//			student.getStudentClassList().remove(temp);
//		}
//	}
//
	public void displayStudentCourses(int studentId) {
		if (!registeredStudent.registeredStudentList().isEmpty()) {
			List<RegisteredStudent> student = registeredStudent.getRegisteredStudent(studentId);
			for (RegisteredStudent record : student) {
				System.out.println("\nCourseId: " + record.getCourseId());
				System.out.println("CourseLevel: " + course.getCourse(record.getCourseId()).get(0).getCourseLevel());
				System.out.println("CourseTitle: " + course.getCourse(record.getCourseId()).get(0).getCourseTitle());
				System.out.println("CreditHours: " + course.getCourse(record.getCourseId()).get(0).getCreditHours());
				System.out.println("Location: " + course.getCourse(record.getCourseId()).get(0).getLocation());
				System.out.println("Time: " + course.getCourse(record.getCourseId()).get(0).getTime());
				System.out.println("Instructor: " + course.getCourse(record.getCourseId()).get(0).getInstructor());
				System.out.println("InstructorId: " + course.getCourse(record.getCourseId()).get(0).getInstructorId());
			}
		} else {
			System.out.println("\nNo Course registered.");
		}
	}

	public void dropCourse(int courseId) {
		registeredStudent.delete(courseId);
	}
//	public void displayClass(List<Course> courses, List<Classes> classes) {
//		for (int i = 0; i < courses.size(); i++) {
//			System.out.println(courses.get(i));
//			System.out.println(classes.get(i));
//		}
//	}
};
