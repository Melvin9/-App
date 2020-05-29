package com.melvin9.projects.school.experiments.projectFinder.projectListActivity

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.melvin9.projects.school.experiments.projectFinder.mainActivity.MainActivity
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectTypes

class ProjectListPresenter {
    fun onCreate(context: Context, projectListInterface: ProjectListInterface) {
        addProjectTypes(context, projectListInterface)
        addProjectLists(context, projectListInterface)
    }

    private fun addProjectTypes(context: Context, projectListInterface: ProjectListInterface) {
        val data = listOf(
            ProjectTypes("Physics"),
            ProjectTypes("Chemistry"),
            ProjectTypes("Biology"),
            ProjectTypes("Computer")
        )
        projectListInterface.renderProjectTypes(context, data)
    }

    private fun addProjectLists(context: Context, projectListInterface: ProjectListInterface) {
        MainActivity.data.observe(context as LifecycleOwner, Observer {
            val data = it
            projectListInterface.renderProjectLists(context, data)
        })

    }
}