package dataAccessObjectClasses;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mainClasses.StudentCredentials;
import mapperClasses.StudentCredentialsMapper;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StudentCredentialsJDBCTemplate implements StudentCredentialsDAO {
	private JdbcTemplate jdbcTemplateObject;
	private Object[] sqlArgs;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(Integer id, Integer username, String password) {
		String SQL = "insert into studentcredentials (id, username, password) values (?, ?, ?)";
		this.sqlArgs = new Object[] { id, username, password };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Login created");
		return;
	}

	@Override
	public StudentCredentials getStudentCredentials(Integer id) {
		String SQL = "select * from studentcredentials where id = ?";

		@SuppressWarnings("unchecked")
		StudentCredentials student = (StudentCredentials) jdbcTemplateObject.queryForObject(SQL, new Object[] { id },
				new StudentCredentialsMapper());

		return student;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from studentcredentials where id = ?";

		jdbcTemplateObject.update(SQL, new Object[] { id });

		System.out.println("Dropped Course");

		return;

	}

	@Override
	public void update(Integer username, String password) {
		String SQL = "update studentcredentials set username = ? where password = ?";

		this.sqlArgs = new Object[] { username, password };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Updated password for: " + username);

		return;
	}

	@Override
	public Integer checkPass(Integer username, String password) {
		String SQL = "select exists( select * from studentcredentials where username = ? and password = ?)";

		Integer student = jdbcTemplateObject.queryForObject(SQL, new Object[] { username, password }, Integer.class);
		return student;
	}
}
