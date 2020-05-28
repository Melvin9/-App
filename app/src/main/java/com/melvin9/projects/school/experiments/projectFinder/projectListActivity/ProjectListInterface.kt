package com.melvin9.projects.school.experiments.projectFinder.projectListActivity

import android.content.Context
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectLists
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectTypes

interface ProjectListInterface {
    fun renderProjectTypes(context: Context,data:List<ProjectTypes>)
    fun renderProjectLists(context: Context,data:List<ProjectLists>)
}