package com.tweteroo.api.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(


    @NotBlank @Length(min = 1) String username, 
    @NotBlank @Length(min = 1) String avatar

    ) {
    
}
