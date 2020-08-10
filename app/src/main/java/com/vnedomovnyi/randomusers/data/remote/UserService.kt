package com.vnedomovnyi.randomusers.data.remote

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api?nat=US")
    suspend fun getUsers(@Query("results") count: Int): GetUsersResponse

    data class GetUsersResponse(@SerializedName("results") val users: List<ApiUser>)

    data class ApiUser(@SerializedName("email") val email: String)

}