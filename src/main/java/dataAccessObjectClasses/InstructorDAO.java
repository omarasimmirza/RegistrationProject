package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import mainClasses.Instructor;

public interface InstructorDAO {
	/**
	 * This is the method to be used to initialize database resources i.e.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the instructor table.
	 */
	public void create(Integer instructorId, String name, String qualification, String address1, String address2,
			Integer phone, Integer mobile, String dateJoined, Integer ssn);

	/**
	 * This is the method to be used to list down a record from the instructor table
	 * corresponding to a passed instructor id.
	 */
	public Instructor getInstructor(Integer id);

	/**
	 * This is the method to be used to list down all the records from the
	 * instructor table.
	 */
	public List<Instructor> listInstructor();

	/**
	 * This is the method to be used to delete a record from the instructor table
	 * corresponding to a passed student id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update a record into the instructor table.
	 */
	public void update(Integer id, String name);
}
