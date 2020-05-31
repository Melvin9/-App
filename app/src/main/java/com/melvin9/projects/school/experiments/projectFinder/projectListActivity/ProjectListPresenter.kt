package com.melvin9.projects.school.experiments.projectFinder.projectListActivity

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project
import com.melvin9.projects.school.experiments.projectFinder.mainActivity.MainActivity
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectTypes
import java.util.*
import kotlin.collections.ArrayList

class ProjectListPresenter {
    var list:MutableList<Project> = ArrayList()

    fun onCreate(context: Context, projectListInterface: ProjectListInterface) {
        addProjectTypes(context, projectListInterface)
        addProjectLists(context, projectListInterface) }

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
        MainActivity.data.observe(context as LifecycleOwner, Observer {project->
            for(item in project){
                if(item.projectType.toString().trim().equals(ProjectListActivity.type,true))
                list.add(item)
            }
            projectListInterface.renderProjectLists(context, list)
        })
    }
    fun filterList(context: Context,searchQuery:String,projectListInterface: ProjectListInterface){
        val newList:MutableList<Project> = ArrayList()
        if(searchQuery.isNotEmpty()) {
            for (item in list)
                if (item.projectTitle.toString().toLowerCase(Locale.ROOT)
                        .contains(searchQuery.toLowerCase(Locale.ROOT)) || item.projectDescription.toString().toLowerCase(Locale.ROOT)
                        .contains(searchQuery.toLowerCase(Locale.ROOT))) {
                    newList.add(item)
                }
            projectListInterface.renderProjectLists(context, newList)
        }
        else{
            projectListInterface.renderProjectLists(context, list)
        }

    }


}