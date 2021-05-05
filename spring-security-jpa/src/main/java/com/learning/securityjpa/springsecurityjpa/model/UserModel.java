package com.learning.securityjpa.springsecurityjpa.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
}
