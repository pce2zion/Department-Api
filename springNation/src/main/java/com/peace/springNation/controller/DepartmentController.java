package com.peace.springNation.controller;

import com.peace.springNation.entity.Department;
import com.peace.springNation.error.DepartmentNotFoundException;
import com.peace.springNation.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
//since we are creating end points, we would annotate it as above
// we would now create a dept service interface and dept service implementation class

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    //loggers are generally used to log in messages when a particular http method
    //has been called in an app. now add inside the post and get mapping methods
    //before the return statements

    @PostMapping("/departments")
    //here since we want to save the department from this server
    // to a db, we use post mapping and give it a path,
    //pass the entity you want to save to the db (in this case dept). A db needs to
    //be saved as a json object. so we annotate the entity as @requestbody

    //after this, we need to pass the service class as a field /object, since we use IOC in
    //spring boot, we make use of autowired annotation (to instantiate it)and pass the field

    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
        // instantiate this above method in the dept service
        // interface and make it a public method ie click on the red and let intellij
        // take it from there.they are helpful for debugging
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartment of DepartmentController");
       return departmentService.fetchDepartmentList();
       //we won't take any input because we need to send all the data back
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);

    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department  ){
        return departmentService.updateDepartment(departmentId, department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }




}
