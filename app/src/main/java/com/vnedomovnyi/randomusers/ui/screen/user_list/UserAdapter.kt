package com.vnedomovnyi.randomusers.ui.screen.user_list

import android.view.ViewGroup
import com.vnedomovnyi.randomusers.core.domain.entity.User
import com.vnedomovnyi.randomusers.util.recycler_view.BaseAdapter

class UserAdapter : BaseAdapter<User, UserViewHolder>() {

    override fun getDiffCallback(oldList: List<User>, newList: List<User>) =
        UserDiffCallback(oldList, newList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder.create(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position))

}