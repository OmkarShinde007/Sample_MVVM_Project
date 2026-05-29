package com.omkar.sample_mvvm_project.data.mapper

import com.omkar.sample_mvvm_project.data.dto.UserDTO
import com.omkar.sample_mvvm_project.domain.entity.UserEntity

fun UserDTO.userDTOToEntityMapper(): UserEntity {
    return UserEntity(
        id = id,
        name = name,
        userName = username,
        email = email,
        zipCode = address.zipcode,
        city = address.city,
        phoneNo = phone
    )
}