package com.melvin9.projects.school.experiments.projectFinder.mainActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project
import com.melvin9.projects.school.experiments.projectFinder.projectList.ProjectListActivity
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivityImpl : AppCompatActivity(),MainActivity {

    companion object{
        var data= MutableLiveData<List<Project>>()
    }
    private val mainActivityPresenter=MainActivityPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        mainActivityPresenter.onCreate(this)

        physics.setOnClickListener {
            itemClicked(this,"physics")
        }
        chemistry.setOnClickListener {
            itemClicked(this,"chemistry")
        }
        biology.setOnClickListener {
            itemClicked(this,"biology")
        }
        computer.setOnClickListener {
            itemClicked(this,"computer")
        }
    }

    override fun itemClicked(context: Context, type: String) {
        val intent= Intent(context,
            ProjectListActivity::class.java)
        intent.putExtra("type",type)
        startActivity(intent)
    }

}
