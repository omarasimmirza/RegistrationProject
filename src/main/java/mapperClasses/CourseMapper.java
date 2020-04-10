package mapperClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mainClasses.Course;

@SuppressWarnings("rawtypes")
public class CourseMapper implements RowMapper {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getInt("courseId"));
		course.setLocation(rs.getString("location"));
		course.setCreditHours(rs.getInt("creditHours"));
		course.setCourseLevel(rs.getInt("courseLevel"));
		course.setTime(rs.getString("time"));
		course.setCourseTitle(rs.getString("courseTitle"));
		course.setInstructor(rs.getString("instructor"));
		course.setInstructorId(rs.getInt("instructorId"));
		return course;
	}

}
