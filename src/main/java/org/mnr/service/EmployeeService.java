package org.mnr.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mnr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	DataSource dataSource;
	JdbcTemplate template;
	
//	private List<Employee> employees	=	new ArrayList<Employee>();

	public String getEmployees() {
//		System.out.println("getEmployees");
		StringBuilder html=new StringBuilder("");
		List<Employee> employees	=	new ArrayList<Employee>();
		
		template	=	new JdbcTemplate(dataSource);
		
		String sql = "SELECT * FROM EMPLOYEE ORDER BY id";
		
		 employees = template.query(sql,new BeanPropertyRowMapper<Employee>( Employee.class ));
		
		 if(employees.isEmpty()==false){
			// html.append("<div id=\"data-div\">");
				for (Employee employee : employees) {
					html.append("<tr>")
					.append("<td>" + employee.getId() + "</td>")
					.append("<td>" + employee.getName() + "</td>")
					.append("<td>" + employee.getDepartment() + "</td>")
					.append("<td>" + employee.getEmail() + "</td>")
					.append("<td> <img src=\"resources/" )
					.append( (employee.getImage()==null?"":employee.getImage()))
					.append(" \" width=\"140\" height=\"80\">")
					.append("</td>")
					.append("</tr>");
		 		}
//				System.out.println("html string:"+html);
				 //html.append("</div>");
				return html.toString();
			}
				
			else{
				return "";
			}
		
	}

	
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}

}
