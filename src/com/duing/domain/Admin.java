package com.duing.domain;

import com.jdbc.annotation.Column;
import com.jdbc.annotation.PrimaryKey;
import com.jdbc.annotation.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@Table("admin")
public class Admin {

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

    public static Admin build(String account) {
        return new Admin(account);
    }
}
