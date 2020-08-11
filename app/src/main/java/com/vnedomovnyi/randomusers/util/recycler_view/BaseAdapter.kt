package com.vnedomovnyi.randomusers.util.recycler_view

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Entity, ViewHolder : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<ViewHolder>() {

    private val list: MutableList<Entity> = ArrayList()

    protected abstract fun getDiffCallback(
        oldList: List<Entity>,
        newList: List<Entity>
    ): DiffUtil.Callback

    override fun getItemCount(): Int {
        return list.size
    }

    protected fun getItem(position: Int): Entity {
        return list[position]
    }

    fun setData(newList: List<Entity>) {
        val diffResult = DiffUtil.calculateDiff(getDiffCallback(list, newList))
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

}