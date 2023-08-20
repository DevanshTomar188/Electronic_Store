package com.project.electronic.store.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="users")
public class User //User is a table name
{
    @Id
    private String userid;

    private String name;

    private String email;
    private String password;
    private String gender;
    private String about;
    private String imagename;



}
