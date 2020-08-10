package com.vnedomovnyi.randomusers.core.domain.entity

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val city: String,
    val state: String,
    val photoUrl: String
)