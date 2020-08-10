package com.vnedomovnyi.randomusers.domain

import com.vnedomovnyi.randomusers.core.domain.interactor.GetUsers
import org.koin.dsl.module

val interactorModule = module {
    factory { GetUsers(get()) }
}