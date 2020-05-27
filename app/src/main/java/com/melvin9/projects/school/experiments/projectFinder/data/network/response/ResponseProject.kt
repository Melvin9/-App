package com.melvin9.projects.school.experiments.projectFinder.data.network.response

import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project

data class ResponseProject(
    val project: List<Project>
)