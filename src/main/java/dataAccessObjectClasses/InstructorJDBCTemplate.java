package dataAccessObjectClasses;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mainClasses.Instructor;
import mapperClasses.InstructorMapper;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InstructorJDBCTemplate implements InstructorDAO {
	private JdbcTemplate jdbcTemplateObject;
	private Object[] sqlArgs;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(Integer instructorId, String name, String qualification, String address1, String address2,
			Integer phone, Integer mobile, String dateJoined, Integer ssn) {
		String SQL = "insert into instructor (instructorId, name, qualification, address1, address2, phone, mobile, dateJoined, ssn) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		this.sqlArgs = new Object[] { instructorId, name, qualification, address1, address2, phone, mobile, dateJoined,
				ssn };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Created Record Name = " + name);

		return;
	}

	@Override
	public Instructor getInstructor(Integer id) {
		String SQL = "select * from instructor where instructorId = ?";

		@SuppressWarnings("unchecked")
		Instructor instructor = (Instructor) jdbcTemplateObject.queryForObject(SQL, new Object[] { id },
				new InstructorMapper());

		return instructor;
	}

	@Override
	public List<Instructor> listInstructor() {
		String SQL = "select * from instructor";

		@SuppressWarnings("unchecked")
		List<Instructor> instructor = jdbcTemplateObject.query(SQL, new InstructorMapper());

		return instructor;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from instructor where instructorId = ?";

		jdbcTemplateObject.update(SQL, new Object[] { id });

		System.out.println("Deleted Record with ID = " + id);

		return;
	}

	@Override
	public void update(Integer id, String name) {
		String SQL = "update course set name = ? where instructorId = ?";

		this.sqlArgs = new Object[] { name, id };

		jdbcTemplateObject.update(SQL, this.sqlArgs);

		System.out.println("Updated Record with ID = " + id);

		return;
	}

}
