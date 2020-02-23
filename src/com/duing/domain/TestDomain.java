package com.duing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDomain {
    // public static final
    public static Integer I1 = 1;
    public Integer integer;
    public String name;
    public Admin admin;

    public TestDomain(Integer integer, String name) {
        this.integer = integer;
        this.name = name;
    }
}
