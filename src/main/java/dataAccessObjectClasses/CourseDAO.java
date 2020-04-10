package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mainClasses.Course;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public interface CourseDAO {
	/**
	 * This is the method to be used to initialize database resources i.e.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the course table.
	 */
	public void create(Integer courseId, String location, Integer creditHours, Integer courseLevel, String time,
			String courseTitle, String instructor, Integer instructorId);

	/**
	 * This is the method to be used to list down a record from the course table
	 * corresponding to a passed courseId
	 */
	public List<Course> getCourse(Integer id);

	/**
	 * This is the method to be used to list down all the records from the course
	 * table.
	 */
	public List<Course> listCourse();

	/**
	 * This is the method to be used to delete a record from the course table
	 * corresponding to a passed courseId
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update a record into the course table.
	 */
	public void update(Integer id, Integer courseLevel);

	/**
	 * This is the method used for getting hours of a course
	 */
	public int getHours(Integer courseId);
}
