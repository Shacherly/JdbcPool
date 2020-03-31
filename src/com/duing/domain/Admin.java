package com.duing.domain;

import com.jdbc.annotation.Column;
import com.jdbc.annotation.PrimaryKey;
import com.jdbc.annotation.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Table("admin")
@AllArgsConstructor
public class Admin implements Serializable {

    // private TestDomain testDomain;

    @PrimaryKey
    private Integer id;

    @Column("account")
    private String account;

    @Column("password")
    private Integer password;

    @Column("create_date")
    private Date createDate;

    public Admin(String account) {
        this.account = account;
    }

    public Admin(String account, Integer password) {
        this.account = account;
        this.password = password;
    }

    public Admin(Integer id, String account) {
        this.id = id;
        this.account = account;
    }

    public static Admin build(String account) {
        return new Admin(account);
    }
}
