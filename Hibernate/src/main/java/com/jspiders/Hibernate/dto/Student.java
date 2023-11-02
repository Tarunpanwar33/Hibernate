package com.jspiders.Hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data

public class Student {
@Id
 private int sid;
 private String name;
 private String email;
 private int age;
 private double fees;
}
