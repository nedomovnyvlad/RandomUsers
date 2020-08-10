package com.vnedomovnyi.randomusers.data

import com.vnedomovnyi.randomusers.core.data.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single { UserRepository(get()) }
}