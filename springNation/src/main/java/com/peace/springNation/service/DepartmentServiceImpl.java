package com.peace.springNation.service;

import com.peace.springNation.entity.Department;
import com.peace.springNation.error.DepartmentNotFoundException;
import com.peace.springNation.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
// you have to annotate it as a service.
//next you name a dept repository interface in the repository package
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    //types of autowiring: constructor based and setter based
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        //after it brings you here you remove the null to the
        //reference of the dept repository as above and autowire it then pass the
        //department entity in the save ()method

        //NB: you autowire every reference
        //here with this, your dept is saved to your db. Now test the endpoints and http method
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
       Optional<Department> department = departmentRepository.findById(departmentId);
       if(!department.isPresent()){
           throw new DepartmentNotFoundException("Department not available");
       }
       return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);

    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
       Department depDB = departmentRepository.findById(departmentId).get();

       if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
           depDB.setDepartmentName(department.getDepartmentName());
       }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

       return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
