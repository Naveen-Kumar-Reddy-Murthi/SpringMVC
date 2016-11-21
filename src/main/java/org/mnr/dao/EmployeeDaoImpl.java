package org.mnr.dao;

import javax.sql.DataSource;

import org.mnr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	DataSource dataSource;
	JdbcTemplate template;

	@Override
	public void save(Employee employee) {
		template	=	new JdbcTemplate(dataSource);
		template.update("insert into employee(id, name, department, email, image) values(?, ?, ?, ?, ? )",new Object[]{employee.getId(), employee.getName(), employee.getDepartment(), employee.getEmail(),
				employee.getImage()});
	}

}
