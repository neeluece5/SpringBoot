package com.example.demo.controller;

/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.web.model.Employee;
import com.java.springboot.web.service.EmployeeService;

@RestController
@ComponentScans(value = { @ComponentScan })
public class EmployeeController{
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Employee> getAllEmployeeDetails(ModelMap model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		System.out.println("");		
		return employeeService.getallEmployees();
				
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)  
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addUser(employee);
		
	}
	
	@RequestMapping(value="/edit-user",method=RequestMethod.POST)
	public void editEmployee(@RequestBody Integer id) {
		
		employeeService.getUser(id);
		
	}
	

}

*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


 

 
@RestController
public class EmployeeController 
{
    @Autowired
    EmployeeService service;
    
    @Autowired
    private EmployeeRepository employeeRepository;
 
    @GetMapping(path = "/allEmployees",produces ="application/json")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = service.getAllEmployees();
 
        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping(path = "findEmployee/{id}",produces ="application/json")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) 
                                                     {
    	System.out.println("HHHHHHHHHHHHHHHHHHHHHH");
        Employee entity = service.getEmployeeById(id);
 
        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
   /* @PostMapping(path= "/{id}", produces = "application/json")
    public ResponseEntity<Employee> createOrUpdateEmployee(Employee employee) {
    	System.out.println("employee add");
    	employee.setEmail("Neelu@gmail.com");
    	employee.setFirstName("Neelaveni");
    	employee.setId(4l);
    	employee.setLastName("R");
        Employee updated = service.createOrUpdateEmployee(employee);Consumes
        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
    }*/
 
    @PostMapping(path= "/employees"  ,produces ="application/json",consumes = "application/json")
	
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		System.out.println("GGGGGGGGGGGGGGGGGGGGGG");
		
		 Employee updated = service.createOrUpdateEmployee(employee);
	     return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	}
    @DeleteMapping("delete/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) 
                                                     {
    	System.out.println("Deleteeeeeeeeeee");
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}