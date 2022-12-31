package com.peace.springNation.controller;

import com.peace.springNation.entity.Department;
import com.peace.springNation.error.DepartmentNotFoundException;
import com.peace.springNation.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
//here since we are controlling the mapping to the db, and we don't want to
    //make new posts, we have to use a mock mvc to mock the post request

class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Maths")
                .departmentAddress("Enugu")
                .departmentCode("MATHS211")
                .departmentId(1L)
                .build();

    }

    @Test
    void saveDepartment() throws Exception {
      Department inputDepartment=  Department.builder()
                .departmentName("Maths")
                .departmentAddress("Enugu")
                .departmentCode("MATHS211")
                .departmentId(1L)
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n " +
                        "\t\"departmentName\":\"Maths\",\n" +
                        "\t\"departmentAddress\":\"Enugu\",\n" +
                        "\t\"departmentCode\":\"MATHS211\"\n" +
                        "}"))
                .andExpect(status().isOk());



    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}