package com.vnedomovnyi.randomusers.ui.screen.user_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vnedomovnyi.randomusers.R
import com.vnedomovnyi.randomusers.core.domain.entity.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User) {
        val resources = itemView.resources
        val name = resources.getString(R.string.user_name, user.firstName, user.lastName)
        itemView.textView.text = name

        Glide.with(itemView)
            .load(user.photoUrl)
            .circleCrop()
            .into(itemView.imageView)
    }

    companion object {

        fun create(parent: ViewGroup): UserViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
            return UserViewHolder(itemView)
        }

    }

}