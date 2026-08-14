package ru.netology.nmedia.service

import android.content.Context
import android.app.Activity
import com.google.android.gms.common.ConnectionResult
import com.google.firebase.messaging.FirebaseMessaging
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.tasks.Task

interface FirebaseMessagingWrapper {
    val token: Task<String>
}

interface GoogleApiAvailabilityWrapper {
    fun isGooglePlayServicesAvailable(context: Context): Int
    fun getErrorDialog(
        activity: Activity,
        errorCode: Int,
        requestCode: Int
    ): android.app.Dialog?
    fun isUserResolvableError(errorCode: Int): Boolean
}
