package com.omkar.sample_mvvm_project.core.di

import com.omkar.sample_mvvm_project.data.repository_impl.CommentsRepositoryImpl
import com.omkar.sample_mvvm_project.data.repository_impl.PostsRepositoryImpl
import com.omkar.sample_mvvm_project.data.repository_impl.UserRepositoryImpl
import com.omkar.sample_mvvm_project.domain.repository.CommentsRepository
import com.omkar.sample_mvvm_project.domain.repository.PostsRepository
import com.omkar.sample_mvvm_project.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindsPostsRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository

    @Binds
    @Singleton
    abstract fun bindsCommentsRepository(commentsRepositoryImpl: CommentsRepositoryImpl): CommentsRepository
}