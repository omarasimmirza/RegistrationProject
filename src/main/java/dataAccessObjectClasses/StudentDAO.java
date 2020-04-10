package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mainClasses.Student;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public interface StudentDAO {
	/**
	 * This is the method to be used to initialize database resources i.e.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the Student table.
	 */
	public void create(Integer studentId, String name, String birthday, String gender, Integer ssn, String address1,
			String address2, String phoneNum, String mobileNum);

	/**
	 * This is the method to be used to list down a record from the Student table
	 * corresponding to a passed student id.
	 */
	public List<Student> getStudent(Integer id);

	/**
	 * This is the method to be used to list down all the records from the Student
	 * table.
	 */
	public List<Student> listStudents();

	/**
	 * This is the method to be used to delete a record from the Student table
	 * corresponding to a passed student id.
	 */
	public void delete(Integer id);
}