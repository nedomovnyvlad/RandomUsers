package com.vnedomovnyi.randomusers.ui.screen.user_list

import com.vnedomovnyi.randomusers.core.domain.entity.User
import com.vnedomovnyi.randomusers.util.recycler_view.BaseDiffCallback

class UserDiffCallback(oldList: List<User>, newList: List<User>) :
    BaseDiffCallback<User>(oldList, newList) {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.firstName == newItem.firstName && oldItem.lastName == newItem.lastName
    }

}