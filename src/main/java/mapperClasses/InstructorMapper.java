package mapperClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mainClasses.Instructor;

@SuppressWarnings("rawtypes")
public class InstructorMapper implements RowMapper {

	@Override
	public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructor instructor = new Instructor();
		instructor.setInstructorId(rs.getInt("instructorId"));
		instructor.setName(rs.getString("name"));
		instructor.setQualification(rs.getString("qualification"));
		instructor.setAddress1(rs.getString("address1"));
		instructor.setAddress2(rs.getString("address2"));
		instructor.setPhone(rs.getInt("phone"));
		instructor.setMobile(rs.getInt("mobile"));
		instructor.setDateJoined(rs.getString("dateJoined"));
		instructor.setSsn(rs.getInt("ssn"));
		return instructor;
	}

}