package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
@Data
@Table(name = "user")
public class User {
    @Id
    @Column( name = "id")
    private Integer id;

    @Column( name = "userName")
    private String userName;

    @Column( name = "passWord")
    private String passWord;

    @Column( name = "realName")
    private String realName;

}
