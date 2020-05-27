package com.melvin9.projects.school.experiments.projectFinder.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.projectList.ProjectListActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var clicked: String
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        physics.setOnClickListener {
            projectsClicked("physics")
        }
        chemistry.setOnClickListener {
            projectsClicked("chemistry")
        }
        biology.setOnClickListener {
            projectsClicked("biology")
        }
        computer.setOnClickListener {
            projectsClicked("computer")
        }


    }
    private fun projectsClicked(project:String){
        clicked=project
        startActivity(Intent(context,
            ProjectListActivity::class.java))
    }
}
