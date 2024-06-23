package com.example.student.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "studentdb")
public class Student {


    @Id
    private String id;
    @Field
    private String name;
    @Field
    private int registrationNo;
    @Field
    private String mailId;


}

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private int registrationNo;
//    private String mailId;
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getRegistrationNo() {
//        return registrationNo;
//    }
//
//    public void setRegistrationNo(int registrationNo) {
//        this.registrationNo = registrationNo;
//    }
//
//    public String getMailId() {
//        return mailId;
//    }
//
//    public void setMailId(String mailId) {
//        this.mailId = mailId;
//    }





