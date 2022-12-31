package com.peace.springNation.service;

import com.peace.springNation.entity.Department;
import com.peace.springNation.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
//if you are using mockbean, you have to instantiate the entity

    //we are testing for our department service (always start from service layer), controller and repo
    //first of, create tests for them,
    //here we create a test for one of the services getDeptbyName
    //instantiate (with autowired the deptservice) since thats what calls the methods
    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Maths")
                        .departmentAddress("Enugu")
                        .departmentCode("MATHS211")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Maths")).thenReturn(department);
    }



    @Test
    @DisplayName("Get data based on valid department name")
    //@Disabled
    public void whenValidDepartment_thenDepartmentShouldBeFound(){
        String departmentName= "Maths";
        Department found= departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}