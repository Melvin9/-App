package com.melvin9.projects.school.experiments.projectFinder.favourite

import android.content.Context
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project

interface FavouriteInterface {
    fun render(context: Context,data:List<Project>)
}