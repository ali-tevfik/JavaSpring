package com.ali.db.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
    @NotEmpty(message = "Firstname must be fill")
    @Size(min = 3,max = 40,message = "leng problem")
    private String firstName;

    @Size(min = 3,max = 40,message = "leng problem")
    private String lastName;
 private Date birthOfDate;
}
