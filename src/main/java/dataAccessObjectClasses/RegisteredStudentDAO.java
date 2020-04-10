package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import mainClasses.RegisteredStudent;

public interface RegisteredStudentDAO {
	/**
	 * This is the method to be used to initialize database resources i.e.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the RegisteredStudent
	 * table.
	 */
	public void create(Integer studentId, Integer courseId, Integer instructorId, Integer creditHour);

	/**
	 * This is the method to be used to list down a record from the
	 * RegisteredStudent table corresponding to a passed student id.
	 */
	public List<RegisteredStudent> getRegisteredStudent(Integer id);

	/**
	 * This is the method to be used to get courses for RegisteredStudent.
	 */
	public int getCourseId(Integer studentId);

	public List<RegisteredStudent> registeredStudentList();

	/**
	 * This is the method to be used to delete a record from the RegisteredStudent
	 * table corresponding to a passed student id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update a record into the RegisteredStudent
	 * table.
	 */
	public void update(Integer id, Integer tableId);

	public int getInstructorId(Integer studentId);
}
