package dataAccessObjectClasses;

import javax.sql.DataSource;

import mainClasses.StudentCredentials;

public interface StudentCredentialsDAO {
	/**
	 * This is the method to be used to initialize database resources i.e.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the studentcredentials
	 * table.
	 */
	public void create(Integer id, Integer username, String password);

	/**
	 * This is the method to be used to delete a record from the studentcredentials
	 * table corresponding to a passed student id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update a record into the studentcredentials
	 * table.
	 */
	public void update(Integer username, String password);

	/**
	 * This is the method to be used to list down a record from the
	 * studentcredentials table corresponding to a passed student id.
	 */
	public StudentCredentials getStudentCredentials(Integer id);

	/**
	 * This is the method to be used to check whether the username and password
	 * entered match any of the usernames and passwords in the table.
	 */
	public Integer checkPass(Integer username, String password);
}
