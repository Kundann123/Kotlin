package com.example.dto

import io.konform.validation.Validation
import io.konform.validation.jsonschema.minLength
import io.konform.validation.jsonschema.pattern

data class UserDTO(
    val userId: String,
    val name: String,
    val mobb: String,
    val email: String,
    val pass: String
)


val validateUser = Validation<UserDTO> {
    UserDTO::userId required { minLength(1)}
    UserDTO::name required {}
    UserDTO::mobb required {
        pattern("[9,8,7,6]\\d{9}") hint "Enter Valid Mobile Number"
    }
    UserDTO::email required {
        pattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") hint "Please enter a valid mail"
    }
    UserDTO::pass required {
        pattern(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        ) hint "Minimum 8 and maximum 32 characters, " +
                "at least one uppercase letter, one lowercase letter, " +
                "one number and one special character"
    }
}