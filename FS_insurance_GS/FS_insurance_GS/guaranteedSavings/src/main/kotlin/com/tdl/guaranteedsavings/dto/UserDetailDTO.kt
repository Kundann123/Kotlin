package com.tdl.guaranteedsavings.dto

import io.konform.validation.Validation
import io.konform.validation.jsonschema.*

data class UserDetailDTO(
        val customerHash: String,
        val email: String,
        val phoneNumber: String,
        val panName: String,
        val ifscCode: String,
        val bankName: String,
        val branchName: String,
        val typeOfAccount: String,
        val incomeRange: String,
        val relationshipWithNominee: String,
        val gender: String,
        val nomineesFullName: String,
        val heightInFoot: Int,
        val heightInInch: Int,
        val weightInKg: Int,
        val createdByUser: String,
        val createdByDate: String,
        val modifiedByUser: String,
        val modifiedByDate: String
)

val validateUserDetails = Validation<UserDetailDTO> {
    UserDetailDTO::customerHash{ minLength(3)}
    UserDetailDTO::email {
        pattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") hint "please enter a valid main"
    }
    UserDetailDTO::phoneNumber required {
        pattern("[9,8,7,6]\\d{9}")
    }
    UserDetailDTO::panName{
        minLength(3) hint "pan name invalid"
    }
    UserDetailDTO::ifscCode{
        pattern("^[A-Z]{4}0[A-Z0-9]{6}$")
    }
    UserDetailDTO::bankName{minLength(3)}
    UserDetailDTO::branchName{minLength(3)}
    UserDetailDTO::typeOfAccount{minLength(3)}
    UserDetailDTO::incomeRange{minLength(3)}
    UserDetailDTO::relationshipWithNominee{minLength(3)}
    UserDetailDTO::gender{minLength(3)}
    UserDetailDTO::nomineesFullName{minLength(3)}
    UserDetailDTO::createdByUser{minLength(3)}
    UserDetailDTO::createdByDate{minLength(3)}
    UserDetailDTO::modifiedByUser{minLength(3)}
    UserDetailDTO::modifiedByDate{minLength(3)}




}


