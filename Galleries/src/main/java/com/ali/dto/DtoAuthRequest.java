package com.ali.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAuthRequest {

    @NotEmpty
    @NotBlank
    private String username;

    @NotEmpty
    @NotBlank
    private String password;

}
