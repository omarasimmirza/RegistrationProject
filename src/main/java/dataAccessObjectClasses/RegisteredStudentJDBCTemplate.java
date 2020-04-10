package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mainClasses.RegisteredStudent;
import mapperClasses.RegisteredStudentMapper;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegisteredStudentJDBCTemplate implements RegisteredStudentDAO {
	private JdbcTemplate jdbcTemplateObject;
	private Object[] sqlArgs;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(Integer studentId, Integer courseId, Integer instructorId, Integer creditHour) {
		String SQL = "insert into registeredStudent (studentId, courseId, instructorId, creditHour) values (?, ?, ?, ?)";
		this.sqlArgs = new Object[] { studentId, courseId, instructorId, creditHour };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Registered Student with ID = " + studentId);
		return;
	}

	@Override
	public int getCourseId(Integer studentId) {
		String SQL = "select courseId from RegisteredStudent where studentId = " + studentId;

		int courseId = jdbcTemplateObject.queryForObject(SQL, Integer.class);

		return courseId;
	}

	@Override
	public int getInstructorId(Integer studentId) {
		String SQL = "select instructorId from RegisteredStudent where studentId = " + studentId;

		int instructorId = jdbcTemplateObject.queryForObject(SQL, Integer.class);

		return instructorId;
	}

	public int getCreditHours(Integer studentId) {
		String SQL = "select sum(creditHour) from registeredstudent where studentId = " + studentId;

		int creditHours = jdbcTemplateObject.queryForObject(SQL, Integer.class);

		return creditHours;
	}

	@Override
	public List<RegisteredStudent> registeredStudentList() {
		String SQL = "select * from registeredStudent";

		@SuppressWarnings("unchecked")
		List<RegisteredStudent> student = jdbcTemplateObject.query(SQL, new RegisteredStudentMapper());

		return student;
	}

	@Override
	public List<RegisteredStudent> getRegisteredStudent(Integer studentId) {
		String SQL = "select * from registeredstudent where studentId = " + studentId;

		@SuppressWarnings("unchecked")
		List<RegisteredStudent> student = jdbcTemplateObject.query(SQL, new RegisteredStudentMapper());

		return student;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from RegisteredStudent where courseId = ?";

		jdbcTemplateObject.update(SQL, new Object[] { id });

		System.out.println("Dropped Course");

		return;
	}

	@Override
	public void update(Integer id, Integer tableId) {
		String SQL = "update RegisteredStudent set registrationId = ? where instructorId = ?";

		this.sqlArgs = new Object[] { id, tableId };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Updated Record with ID = " + id);

		return;
	}

}
