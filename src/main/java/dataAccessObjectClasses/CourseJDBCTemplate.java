package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import mainClasses.Course;
import mapperClasses.CourseMapper;

public class CourseJDBCTemplate implements CourseDAO {
	private JdbcTemplate jdbcTemplateObject;
	private Object[] sqlArgs;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Integer courseId, String location, Integer creditHours, Integer courseLevel, String time,
			String courseTitle, String instructor, Integer instructorId) {
		String SQL = "insert into course (courseId, location, creditHours, courseLevel, time, courseTitle, instructor, instructorId) values (?, ?, ?, ?, ?, ?, ?, ?)";
		this.sqlArgs = new Object[] { courseId, location, creditHours, courseLevel, time, courseTitle, instructor,
				instructorId };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Created Course Record with Title: " + courseTitle);
		return;
	}

	@Override
	public int getHours(Integer courseId) {
		String SQL = "select creditHours from course where courseId = ?";

		int hours = jdbcTemplateObject.queryForObject(SQL, new Object[] { courseId }, Integer.class);

		return hours;
	}

	@Override
	public List<Course> listCourse() {
		String SQL = "select * from course";

		@SuppressWarnings("unchecked")
		List<Course> course = jdbcTemplateObject.query(SQL, new CourseMapper());

		return course;
	}

	@Override
	public List<Course> getCourse(Integer courseId) {
		String SQL = "select * from course where courseId = " + courseId;

		@SuppressWarnings("unchecked")
		List<Course> course = jdbcTemplateObject.query(SQL, new CourseMapper());

		return course;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from course where courseId = ?";

		jdbcTemplateObject.update(SQL, new Object[] { id });

		System.out.println("Deleted Record with ID = " + id);

		return;
	}

	@Override
	public void update(Integer id, Integer courseLevel) {
		String SQL = "update course set courseLevel = ? where courseId = ?";

		this.sqlArgs = new Object[] { courseLevel, id };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Updated Record with ID = " + id);

		return;
	}

}
