package mainClasses;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dataAccessObjectClasses.StudentCredentialsJDBCTemplate;
import dataAccessObjectClasses.StudentJDBCTemplate;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		StudentJDBCTemplate student = factory.getBean(StudentJDBCTemplate.class);
		StudentCredentialsJDBCTemplate login = factory.getBean(StudentCredentialsJDBCTemplate.class);

		StudentCredentials user = factory.getBean(StudentCredentials.class);
		RegistrationManager registration = factory.getBean(RegistrationManager.class);

//------------------------------------------------------------------------------------------------------------------
//		DELETING COURSE RECORDS
//		
//		System.out.println("------Delete Courses------");
//		courseTemplate.delete(1);
//		courseTemplate.delete(2);
//		courseTemplate.delete(3);

//		CREATING COURSE RECORDS
//		
//		System.out.println("------Creating Courses------");
//		courseTemplate.create(1, "Building 1", 4, 2000, "MW 10:00 - 11:15am", "Computer Science 1");
//		courseTemplate.create(2, "Building 2", 3, 1000, "TR 9:00 - 9:50am", "History 1");
//		courseTemplate.create(3, "Building 3", 4, 2000, "TR 10:00 - 11:15am", "Discrete Math");

//		CREATING INSTRUCTOR RECORDS
//		
//		System.out.println("------Creating Instructors------");
//		instructorTemplate.create(1, "John Wick", "PHD", "794 Chestnut Ave, Saint Petersburg, FL 33702", "-",
//				2099552297, 2108658107, "Aug. 17, 1986", 976839618);
//		instructorTemplate.create(2, "Jason Bourne", "Masters", "9094 Rockville St., Lake Zurich, IL 60047", "-",
//				2032568779, 2115822167, "Apr. 11, 1998", 184855311);
//		instructorTemplate.create(3, "James Bond", "BS", "633 Linden St., Sylvania, OH 43560", "-", 2065839130,
//				1858723218, "Jun. 6, 2002", 499829430);

//		DELETING INSTRUCTOR RECORDS
//		
//		System.out.println("------Delete instructor records------");
//		instructorTemplate.delete(1);
//		instructorTemplate.delete(2);
//		instructorTemplate.delete(3);
//------------------------------------------------------------------------------------------------------------------
		int checked = 0;
		int checkExist = 0;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		String enter = "";
		do {
			System.out.println("Enter \"hello\" to continue");
			enter = sc.nextLine();
			if (enter.equals("exit")) {
				System.out.println("\nProgram closing");
				continue;
			}
			System.out.println("Username: ");
			user.setUsername(sc.nextInt());
			sc.nextLine();
			System.out.println("Password: ");
			user.setPassword(sc.nextLine());
			checked = login.checkPass(user.getUsername(), user.getPassword());
			checkExist = student.profileExist(user.getUsername());
			if (checked == 1) {
				if (checkExist != 1) {
					System.out.print("Enter your full name: ");
					String name = sc.nextLine();
					System.out.print("Enter your date of birth (mm/dd/yyyy): ");
					String dateOfBirth = sc.nextLine();
					System.out.print("Enter your student id: ");
					int studentId = sc.nextInt();
					sc.nextLine(); // to collect the new line character that sc.nextInt() doesn't pick up.
					System.out.print("Enter your gender: ");
					String gender = sc.nextLine();
					System.out.print("Enter your ssn: ");
					int ssn = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter your Address: ");
					String address1 = sc.nextLine();
					System.out.print("Enter Address 2, Otherwise enter \"-\": ");
					String address2 = sc.nextLine();
					System.out.print("Enter your phone number: ");
					String phone = sc.nextLine();
					System.out.print("Enter your mobile number: ");
					String mobile = sc.nextLine();
					student.create(studentId, name, dateOfBirth, gender, ssn, address1, address2, phone, mobile);
				}

				do {
					System.out.println("\n1. List all available classes");
					System.out.println("2. Register a class");
					System.out.println("3. Print your schedule");
					System.out.println("4. Drop a class");
					System.out.println("5. Complete Registeration\n");
					System.out.print("Your choice: ");
					choice = sc.nextInt();
					sc.nextLine(); // to collect the new line character that sc.nextInt() doesn't pick up.

					switch (choice) {
					case 1:
						registration.displayCourses();
						break;
					case 2:
						System.out.println("Enter the courseId: ");
						int courseId = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter the instructorId: ");
						int instructorId = sc.nextInt();
						sc.nextLine();
						List<Student> student1 = student.getStudent(user.getUsername());
						registration.register(student1.get(0).getStudentId(), courseId, instructorId);
						break;
					case 3:
						student1 = student.getStudent(user.getUsername());
						registration.displayStudentCourses(student1.get(0).getStudentId());
						break;
					case 4:
						System.out.println("Enter the coursId: ");
						courseId = sc.nextInt();
						sc.nextLine();
						registration.dropCourse(courseId);
						break;
					case 5:
						System.out.println("\nExiting Registration\n");
						break;
					default:
						System.out.println("\nEnter a number between 1-5");
					}
				} while (choice != 5);
			} else {
				System.out.println("\nusername or password was incorrect\n");
			}
		} while (!enter.equals("exit"));

		sc.close();
	}
}