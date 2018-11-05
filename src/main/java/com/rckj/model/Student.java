package com.rckj.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 6771608755338249746L;

    private long id;
    private String name;
    private String sex;
    private int age;
}
