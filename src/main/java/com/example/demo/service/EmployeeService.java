package com.example.demo.service;
/*
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.web.model.Employee;
import com.java.springboot.web.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	public List<Employee> getallEmployees(){
		 List<Employee> Employees = new ArrayList<>();  
		 empRepository.findAll().forEach(Employees::add);  
	        return Employees;  
	    }  
	    public Employee getUser(Long id){  
	        return empRepository.findOne(id);  
	    }  
	    public void addUser(Employee employee){  
	        empRepository.save(employee);  
	    }  
	    public void delete(Long id){  
	        empRepository.delete(id);  
	    }  
	
}
*/

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;



 
@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }
     
    public Employee getEmployeeById(Long id) throws RecordTypeNotSupportedException 
    {
        Employee employee = repository.findOne(id);
         
       
            return employee;
       
    }
     
    public Employee createOrUpdateEmployee(Employee entity) throws ResourceNotFoundException 
    {
    	System.out.println("create and update "+entity.getId());
    	System.out.println("create and update "+entity.getEmail());
    	
    	
        Employee employee = repository.findOne(entity.getId());
    	//Employee employee  = new Employee();
    	if(employee == null) {
    	   employee = new Employee();	
    	}
         
        employee.setId(entity.getId());
        employee.setEmail(entity.getEmail());
        employee.setFirstName(entity.getFirstName());
        employee.setLastName(entity.getLastName());
 
        employee = repository.save(employee);
             
            return employee;
        
    } 
     
    public void deleteEmployeeById(Long id) throws RecordTypeNotSupportedException 
    {
        Employee employee = repository.findOne(id);
      
            repository.delete(id);
        
    } 
}