package com.example.suitmediaapp.models

import UserModel
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data") val data: List<UserModel>
)
