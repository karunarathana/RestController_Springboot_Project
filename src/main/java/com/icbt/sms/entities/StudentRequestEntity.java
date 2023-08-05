package com.icbt.sms.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestEntity {
    @NotNull
    private String name;
    private int age;
    private String address;
    private String mobileNumber;
    private String className;
}
