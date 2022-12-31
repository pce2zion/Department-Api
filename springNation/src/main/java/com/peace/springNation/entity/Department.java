package com.peace.springNation.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
//to enable entity interact with the db and send endpoints to be used on the client side
@Data
//this is to call lombok into our code and use it. it contains the getters and setters and to string we normally use in our code
//but if you want getters and setters, you can just use them directly without the @Data annotation ie
//@Getter
//@Setter
@NoArgsConstructor
//lombok helps to automatically put no args constructor
@AllArgsConstructor
//it also helps to give all args constructor
@Builder
//lombok also helps to give builder class
public class Department {

    @Id
    //an entity always need a primary key and we will use id
    //and the generatedValue
    @GeneratedValue(strategy = GenerationType.AUTO)
    //after this we would need the particular entity controller
    private Long departmentId;
    @NotBlank(message = "Please add department name")
    //the above is a form of validation annotation to ensure that some field details must be filled by the user.
    // to use it,first install jpa validation
    //dependency in spring starter.io and copy to your pom.xml
    //after this, go to the controller and in the post method, where you receive the
    //users input, put a valid annotation

//    @Length(max= 5, min = 1, message = "Lenght must")
//    @Size(max = 10, min = 0)
//    @Email(message = "ddddd")
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
