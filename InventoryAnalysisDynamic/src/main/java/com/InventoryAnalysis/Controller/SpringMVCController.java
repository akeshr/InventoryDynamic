package com.InventoryAnalysis.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryAnalysis.DAO.InventoryAnalysisDAO;
import com.InventoryAnalysis.Model.Student;
 
 
@RestController
public class SpringMVCController {
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    InventoryAnalysisDAO inventoryAnalysisDAO = 
       (InventoryAnalysisDAO)context.getBean("InventoryAnalysisDAO");
	
	
	/*@RequestMapping(value = "/PostService", method = RequestMethod.POST, headers="Accept=application/json")
	public person PostService(@RequestBody p person) {
			
		return person;
		
		
	}
	@RequestMapping(value = "/PostFormData", method = RequestMethod.POST)
	public person PostService2(@RequestBody person person) {
		
		return person;
	}*/
	
	@RequestMapping(value = "PostFormData", method = RequestMethod.GET)
	public List<Student> getStudent(){
		
	List<Student> students = inventoryAnalysisDAO.listStudents();
		
		return students;
	}
	
 
}