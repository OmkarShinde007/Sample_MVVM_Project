package com.omkar.sample_mvvm_project.data.mapper

import com.omkar.sample_mvvm_project.data.dto.PostsDTO
import com.omkar.sample_mvvm_project.domain.entity.PostsEntity

fun PostsDTO.postsDTOToEntityMapper(): PostsEntity {

    return PostsEntity(
        id = id, title = title, posts = body
    )
}