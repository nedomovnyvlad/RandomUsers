package com.vnedomovnyi.randomusers.core.data

class UserRepository(private val userDataSource: UserDataSource) : UserDataSource {

    override suspend fun getUsers() = userDataSource.getUsers()

}