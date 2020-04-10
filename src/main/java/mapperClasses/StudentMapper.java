package mapperClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mainClasses.Student;

@SuppressWarnings("rawtypes")
public class StudentMapper implements RowMapper {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getInt("studentId"));
		student.setName(rs.getString("name"));
		student.setBirthday(rs.getString("birthday"));
		student.setGender(rs.getString("gender"));
		student.setSsn(rs.getInt("ssn"));
		student.setAddress1(rs.getString("address1"));
		student.setAddress2(rs.getString("address2"));
		student.setPhoneNum(rs.getString("phoneNum"));
		student.setMobileNum(rs.getString("mobileNum"));

		return student;
	}

}
