package com.melvin9.projects.school.experiments.projectFinder.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.ProjectListActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        physics.setOnClickListener(this)
        chemistry.setOnClickListener(this)
        biology.setOnClickListener(this)
        computer.setOnClickListener(this)
        all.setOnClickListener (this)
        allCard.setOnClickListener(this)

    }
    private fun projectsClicked(project: String) {
        Intent(context, ProjectListActivity::class.java).apply {
            putExtra("clickedProject", project)
        }.let(::startActivity)
    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.biology -> projectsClicked("biology")
            R.id.chemistry -> projectsClicked("chemistry")
            R.id.physics -> projectsClicked("physics")
            R.id.computer -> projectsClicked("computer")
            R.id.all -> projectsClicked("all")
            R.id.allCard -> projectsClicked("all")
        }
    }
}
