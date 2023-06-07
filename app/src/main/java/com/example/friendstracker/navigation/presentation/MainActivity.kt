package com.example.friendstracker.navigation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.friendstracker.R
import com.example.friendstracker.getAppComponent
import com.example.friendstracker.navigation.Navigator
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAppComponent()
            .inject(this)

        val navController = (supportFragmentManager.findFragmentById(R.id.fragment_container)
                as NavHostFragment).navController
        navigator.setNavController(navController)
    }
}