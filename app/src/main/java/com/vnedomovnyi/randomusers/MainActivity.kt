package com.vnedomovnyi.randomusers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vnedomovnyi.randomusers.core.domain.interactor.GetUsers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val getUsers: GetUsers by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            Timber.d("${getUsers()}")
        }
    }

}