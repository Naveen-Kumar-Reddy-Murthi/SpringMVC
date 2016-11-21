package org.mnr.spring;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.mnr.dao.EmployeeDao;
import org.mnr.model.Employee;
import org.mnr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController  {
	
	public static final String	STORAGE_PATH="D:\\luna-practice\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringMVC\\resources\\";
	
	
	@Autowired
	EmployeeDao dao;
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value="/showMainForm")
	public ModelAndView showFullForm(Employee employee){
		System.out.println("showFullForm");
		ModelAndView modelAndView	=	new ModelAndView("MainForm");
		modelAndView.addObject("employees", service.getEmployees());
		return modelAndView;
	}
	
	@RequestMapping(value="/registerEmployee")
	public ModelAndView registerForm(Employee employee){
		
		return new ModelAndView("EmployeeForm");
	}
	
	@RequestMapping(value="/saveEmployee")
	public ModelAndView register(@Valid Employee employee, BindingResult bind,@RequestParam(value = "imageFile", required = false) MultipartFile imageFile ){
		
		ModelAndView modelAndView	=	new ModelAndView("MainForm");
		modelAndView.addObject("employees", service.getEmployees());
		
		if (imageFile!=null && !imageFile.isEmpty()) {
			try {
				validateImage(imageFile);

			} catch (RuntimeException re) {
				bind.reject(re.getMessage());
				bind.addError(new ObjectError("ImageFile","Image is mandatory"));
			}
		}
		
		if(bind.hasErrors()){
			return modelAndView;
		}
		else{
				try {
					String fileName = employee.getName().replace(" ", "") + ".jpg";
					employee.setImage(fileName);
					saveImage(fileName, imageFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				dao.save(employee);
//				ModelAndView modelAndView	=	new ModelAndView("MainForm");
				modelAndView.addObject("employees", service.getEmployees());
				employee	=	new Employee();	
				modelAndView.addObject("employee", employee);
				return  modelAndView;
		}
		
	}
	
	@RequestMapping(value="/saveEmployee1")
	public ModelAndView register1(@Valid Employee employee, BindingResult bind,@RequestParam(value = "imageFile", required = false) MultipartFile imageFile ){
		
		ModelAndView modelAndView	=	new ModelAndView("EmployeeForm");
		
		if (imageFile!=null && !imageFile.isEmpty()) {
			try {
				validateImage(imageFile);

			} catch (RuntimeException re) {
				bind.reject(re.getMessage());
				bind.addError(new ObjectError("ImageFile","Image is mandatory"));
			}
		}
		
		if(bind.hasErrors()){
			return modelAndView;
		}
		else{
				try {
					String fileName = employee.getName().replace(" ", "") + ".jpg";
					employee.setImage(fileName);
					saveImage(fileName, imageFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				dao.save(employee);
				employee	=	new Employee();	
				modelAndView.addObject("employee", employee);
				return  modelAndView;
		}
		
	}
	
	@RequestMapping(value="/showAllEmployees") 
	public  String showAllEmployees(Map<String, Object> model){
		model.put("employees", service.getEmployees());
		return "EmployeeView";
	}
	
	@RequestMapping(value="/showAllEmployeesAjax") 
	public @ResponseBody String showAllEmployeesAjax(){
		System.out.println("Ajax Request "+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()).toString());
		String html	= "";
		html	=	service.getEmployees();
		return html;
		
	}

	
	
	private String saveImage(String filename, MultipartFile image)
			throws RuntimeException, IOException {
		try {
			String fileName	=	"";
			File file = new File(STORAGE_PATH + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			fileName=file.getName();
			return fileName;
		} catch (IOException e) {
			throw e;
		}
	}
	
	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
		throw new RuntimeException("Only JPG images are accepted");
		}
		}

	
	

}
