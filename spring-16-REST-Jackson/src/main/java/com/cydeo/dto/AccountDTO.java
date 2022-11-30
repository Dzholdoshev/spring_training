package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"address","country", "state"},ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    @JsonBackReference // This field is not going to be serialized -- we don't see this object to be converted as Json
   // @JsonIgnore // it'll ignore in get and put request
    private UserDTO user;

}
