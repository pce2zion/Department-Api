package com.peace.springNation.service;

import com.peace.springNation.entity.Department;
import com.peace.springNation.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

  public  Department updateDepartment(Long departmentId, Department department);

  public  Department fetchDepartmentByName(String departmentName);

    //now we have to implement it in the implementation class click on the red
}
