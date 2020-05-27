package com.melvin9.projects.school.experiments.projectFinder.utils

import android.util.Log

fun Any?.log(tag: String = "Projects_LOG"){
    Log.d(tag, this.toString())
}