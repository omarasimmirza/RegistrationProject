package mapperClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mainClasses.StudentCredentials;

@SuppressWarnings("rawtypes")
public class StudentCredentialsMapper implements RowMapper {

	@Override
	public StudentCredentials mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentCredentials student = new StudentCredentials();
		student.setUsername(rs.getInt("username"));
		student.setPassword(rs.getString("password"));
		return student;
	}

}
