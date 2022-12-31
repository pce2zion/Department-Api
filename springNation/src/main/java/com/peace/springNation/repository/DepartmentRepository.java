package com.peace.springNation.repository;

import com.peace.springNation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//we would be annotating it as such above and extend jpa repository, pass the entity
// and pass the primary key data type
//extending jpa repository gives us access to methods for querying the db
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //next create methods for your department controller

    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);


}
