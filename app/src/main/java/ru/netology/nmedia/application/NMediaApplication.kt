package ru.netology.nmedia.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.service.FirebaseMessagingWrapper
import javax.inject.Inject

@HiltAndroidApp
class NMediaApplication : Application() {
    private val appScope = CoroutineScope(Dispatchers.Default)

    @Inject
    lateinit var auth: AppAuth

    @Inject
    lateinit var firebaseMessagingWrapper: FirebaseMessagingWrapper

    override fun onCreate() {
        super.onCreate()
        setupAuth()
    }

    private fun setupAuth() {
        appScope.launch {
            try {
                val token = firebaseMessagingWrapper.token.await()
                auth.sendPushToken(token)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
