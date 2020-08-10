package com.vnedomovnyi.randomusers.data.remote

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api?nat=US")
    suspend fun getUsers(@Query("results") count: Int): GetUsersResponse

    data class GetUsersResponse(@SerializedName("results") val users: List<ApiUser>)

    data class ApiUser(
        @SerializedName("name") val name: Name,
        @SerializedName("email") val email: String,
        @SerializedName("location") val location: Location,
        @SerializedName("picture") val picture: Picture
    )

    data class Name(
        @SerializedName("first") val first: String,
        @SerializedName("last") val last: String
    )

    data class Location(
        @SerializedName("city") val city: String,
        @SerializedName("state") val state: String
    )

    data class Picture(@SerializedName("large") val largePhotoUrl: String)

}