package mapperClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mainClasses.RegisteredStudent;

@SuppressWarnings("rawtypes")
public class RegisteredStudentMapper implements RowMapper {

	@Override
	public RegisteredStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegisteredStudent student = new RegisteredStudent();
		student.setRegistrationId(rs.getInt("registrationId"));
		student.setStudentId(rs.getInt("studentId"));
		student.setCourseId(rs.getInt("courseId"));
		student.setInstructorId(rs.getInt("instructorId"));
		student.setCreditHour(rs.getInt("creditHour"));
		return student;
	}

}
