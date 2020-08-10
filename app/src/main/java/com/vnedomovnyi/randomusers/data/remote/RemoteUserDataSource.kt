package com.vnedomovnyi.randomusers.data.remote

import com.vnedomovnyi.randomusers.USER_COUNT
import com.vnedomovnyi.randomusers.core.data.UserDataSource
import com.vnedomovnyi.randomusers.core.domain.entity.User

class RemoteUserDataSource(private val userService: UserService) : UserDataSource {

    override suspend fun getUsers() = userService.getUsers(USER_COUNT).users.map {
        User(
            it.email
        )
    }

}