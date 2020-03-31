package com.duing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int no;
    private Long id;
    private String name;
    private ArrayList<String> list;



    public User(Long id, String name) {
        // this();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
