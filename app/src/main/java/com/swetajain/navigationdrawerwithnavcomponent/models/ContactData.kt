package com.swetajain.navigationdrawerwithnavcomponent.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactData(
    var name: String,
    var image: Int?,
    var phone: Int,
    var email: String?,
    var address: String?
) : Parcelable