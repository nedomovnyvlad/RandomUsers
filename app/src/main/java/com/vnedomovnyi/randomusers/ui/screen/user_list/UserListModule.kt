package com.vnedomovnyi.randomusers.ui.screen.user_list

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userListModule = module {
    factory { UserAdapter() }
    viewModel { UserListViewModel(get()) }
}