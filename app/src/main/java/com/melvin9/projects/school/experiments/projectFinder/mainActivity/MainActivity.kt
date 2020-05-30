package com.melvin9.projects.school.experiments.projectFinder.mainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project

class MainActivity : AppCompatActivity() {

    companion object {
        var data = MutableLiveData<List<Project>>()
    }

    private val mainActivityPresenter = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
        mainActivityPresenter.onCreate(this)
        supportActionBar?.hide()
    }
}
