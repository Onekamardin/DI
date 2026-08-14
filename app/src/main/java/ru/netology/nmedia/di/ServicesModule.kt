package ru.netology.nmedia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.netology.nmedia.service.FirebaseMessagingWrapper
import ru.netology.nmedia.service.FirebaseMessagingWrapperImpl
import ru.netology.nmedia.service.GoogleApiAvailabilityWrapper
import ru.netology.nmedia.service.GoogleApiAvailabilityWrapperImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServicesModule {

    @Provides
    @Singleton
    fun provideFirebaseMessagingWrapper(): FirebaseMessagingWrapper =
        FirebaseMessagingWrapperImpl()

    @Provides
    @Singleton
    fun provideGoogleApiAvailabilityWrapper(): GoogleApiAvailabilityWrapper =
        GoogleApiAvailabilityWrapperImpl()
}
