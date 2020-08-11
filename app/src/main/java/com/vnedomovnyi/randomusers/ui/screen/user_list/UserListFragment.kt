package com.vnedomovnyi.randomusers.ui.screen.user_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vnedomovnyi.randomusers.R
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    private val adapter: UserAdapter by inject()

    private val userListViewModel: UserListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userListViewModel.usersLiveData.observe(this, Observer { adapter.setData(it) })
        userListViewModel.fetchUsers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        userRecyclerView.layoutManager = layoutManager
        userRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                layoutManager.orientation
            )
        )
        userRecyclerView.adapter = adapter
    }

}