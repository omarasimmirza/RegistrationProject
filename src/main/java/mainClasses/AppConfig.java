package mainClasses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dataAccessObjectClasses.CourseJDBCTemplate;
import dataAccessObjectClasses.InstructorJDBCTemplate;
import dataAccessObjectClasses.RegisteredStudentJDBCTemplate;
import dataAccessObjectClasses.StudentCredentialsJDBCTemplate;
import dataAccessObjectClasses.StudentJDBCTemplate;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
public class AppConfig {
	@Value("com.mysql.cj.jdbc.Driver")
	String driverClassName;
	@Value("jdbc:mysql://localhost:3306/registrationmanager")
	String url;
	@Value("root")
	String username;
	@Value("10mara51m2")
	String password;

	@Bean(name = "student")
	@Scope(value = "prototype")
	public Student getStudent() {
		return new Student();
	}

	@Bean(name = "course")
	@Scope(value = "prototype")
	public Course getCourse() {
		return new Course();
	}

	@Bean(name = "instructor")
	@Scope(value = "prototype")
	public Instructor getInstructor() {
		return new Instructor();
	}

	@Bean(name = "registeredStudent")
	@Scope(value = "prototype")
	public RegisteredStudent getRegisteredStudent() {
		return new RegisteredStudent();
	}

	@Bean(name = "registeredManager")
	@Scope(value = "prototype")
	public RegistrationManager getRegistrationManager() {
		return new RegistrationManager();
	}

	@Bean(name = "studentCredentials")
	@Scope(value = "prototype")
	public StudentCredentials getStudentCredentials() {
		return new StudentCredentials();
	}

	@Bean
	@Scope(value = "prototype")
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setUrl(url);
		source.setDriverClassName(driverClassName);
		source.setUsername(username);
		source.setPassword(password);
		return source;
	}

	@Bean
	@Scope(value = "prototype")
	public StudentJDBCTemplate studentManager() {
		StudentJDBCTemplate manager = new StudentJDBCTemplate();
		manager.setDataSource(datasource());
		return manager;
	}

	@Bean
	@Scope(value = "prototype")
	public CourseJDBCTemplate courseManager() {
		CourseJDBCTemplate manager = new CourseJDBCTemplate();
		manager.setDataSource(datasource());
		return manager;
	}

	@Bean
	@Scope(value = "prototype")
	public InstructorJDBCTemplate instructorManager() {
		InstructorJDBCTemplate manager = new InstructorJDBCTemplate();
		manager.setDataSource(datasource());
		return manager;
	}

	@Bean
	@Scope(value = "prototype")
	public RegisteredStudentJDBCTemplate registrationManager() {
		RegisteredStudentJDBCTemplate manager = new RegisteredStudentJDBCTemplate();
		manager.setDataSource(datasource());
		return manager;
	}

	@Bean
	@Scope(value = "prototype")
	public StudentCredentialsJDBCTemplate login() {
		StudentCredentialsJDBCTemplate manager = new StudentCredentialsJDBCTemplate();
		manager.setDataSource(datasource());
		return manager;
	}
}