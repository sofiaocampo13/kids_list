package com.edu.umanizales.kids_list.model;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Kid {
    private String id;
    private String name;
    private byte age;
//    private String gender;
    private char gender;
}
