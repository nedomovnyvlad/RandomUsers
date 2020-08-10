package com.vnedomovnyi.randomusers.core.data

import com.vnedomovnyi.randomusers.core.domain.entity.User

interface UserDataSource {

    suspend fun getUsers(): List<User>

}