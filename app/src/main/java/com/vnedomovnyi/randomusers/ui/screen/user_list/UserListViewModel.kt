package com.vnedomovnyi.randomusers.ui.screen.user_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vnedomovnyi.randomusers.core.domain.entity.User
import com.vnedomovnyi.randomusers.core.domain.interactor.GetUsers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class UserListViewModel(private val getUsers: GetUsers) : ViewModel() {

    private val _usersLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val usersLiveData: LiveData<List<User>> get() = _usersLiveData

    fun fetchUsers() {
        GlobalScope.launch {
            try {
                _usersLiveData.postValue(getUsers())
            } catch (t: Throwable) {
                Timber.e(t, "Failed to load users.")
            }
        }
    }

}