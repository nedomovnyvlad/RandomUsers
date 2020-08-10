package com.vnedomovnyi.randomusers.core.domain.interactor

import com.vnedomovnyi.randomusers.core.data.UserRepository

class GetUsers(private val userRepository: UserRepository) {

    suspend operator fun invoke() = userRepository.getUsers()

}