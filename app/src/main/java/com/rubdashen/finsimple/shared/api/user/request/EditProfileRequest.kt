package com.rubdashen.finsimple.shared.api.user.request

import com.google.gson.annotations.SerializedName

data class EditProfileRequest(
    @SerializedName("companyName") val companyName: String,
    @SerializedName("email") val email: String,
    @SerializedName("ruc") val ruc: String
)
