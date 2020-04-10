package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mainClasses.Student;
import mapperClasses.StudentMapper;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StudentJDBCTemplate implements StudentDAO {
//	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private Object[] sqlArgs;

	@Override
	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Integer studentId, String name, String birthday, String gender, Integer ssn, String address1,
			String address2, String phoneNum, String mobileNum) {
		String SQL = "insert into Student (studentId, name, birthday, gender, ssn, address1, address2, phoneNum, mobileNum) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		this.sqlArgs = new Object[] { studentId, name, birthday, gender, ssn, address1, address2, phoneNum, mobileNum };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Created Record Name = " + name);
		return;
	}

	@Override
	public List<Student> getStudent(Integer ssn) {
		String SQL = "select * from Student where ssn = " + ssn;

		@SuppressWarnings("unchecked")
		List<Student> student = jdbcTemplateObject.query(SQL, new StudentMapper());

		return student;
	}

	@Override
	public List<Student> listStudents() {
		String SQL = "select * from Student";

		@SuppressWarnings("unchecked")
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());

		return students;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where studentId = ?";

		jdbcTemplateObject.update(SQL, new Object[] { id });

		System.out.println("Deleted Record with ID = " + id);

		return;
	}

	public Integer profileExist(Integer ssn) {
		String SQL = "select exists( select * from student where ssn = ?)";

		Integer student = jdbcTemplateObject.queryForObject(SQL, new Object[] { ssn }, Integer.class);
		return student;
	}
}