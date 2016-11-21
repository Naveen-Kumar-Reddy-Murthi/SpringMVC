package org.mnr.dao;

import javax.sql.DataSource;

import org.mnr.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	DataSource dataSource;
	JdbcTemplate template;
	
	@Override
	public void save(Student student) {
		template= new JdbcTemplate(dataSource);
		template.update("insert into student1 values (?, ?)",new Object[]{student.getId(),student.getName()});

	}

}
