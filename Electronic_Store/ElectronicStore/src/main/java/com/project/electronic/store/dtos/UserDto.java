package com.project.electronic.store.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {


    private String userid;

    private String name;

    private String email;
    private String password;
    private String gender;
    private String about;
    private String imagename;

}
