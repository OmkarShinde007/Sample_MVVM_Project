package com.omkar.sample_mvvm_project.data.mapper

import com.omkar.sample_mvvm_project.data.dto.CommentsDTO
import com.omkar.sample_mvvm_project.domain.entity.CommentsEntity

fun CommentsDTO.commentDTOToEntityMapper() : CommentsEntity{

    return CommentsEntity(
        id = id,
        name = name,
        email = email,
        comment = body
    )
}
