package ru.netology.nmedia.service

import android.content.Context
import android.app.Activity
import com.google.firebase.messaging.FirebaseMessaging
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.tasks.Task
import ru.netology.nmedia.service.FirebaseMessagingWrapper
import ru.netology.nmedia.service.GoogleApiAvailabilityWrapper

class FirebaseMessagingWrapperImpl : FirebaseMessagingWrapper {
    override val token: Task<String>
        get() = FirebaseMessaging.getInstance().token
}

class GoogleApiAvailabilityWrapperImpl : GoogleApiAvailabilityWrapper {
    private val googleApiAvailability = GoogleApiAvailability.getInstance()

    override fun isGooglePlayServicesAvailable(context: Context): Int =
        googleApiAvailability.isGooglePlayServicesAvailable(context)

    override fun getErrorDialog(
        activity: Activity,
        errorCode: Int,
        requestCode: Int
    ): android.app.Dialog? =
        googleApiAvailability.getErrorDialog(activity, errorCode, requestCode)

    override fun isUserResolvableError(errorCode: Int): Boolean =
        googleApiAvailability.isUserResolvableError(errorCode)
}
