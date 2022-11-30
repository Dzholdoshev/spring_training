package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // we can only PUT and not to GET
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference // This field is going to be serialized
    private AccountDTO account;

}
