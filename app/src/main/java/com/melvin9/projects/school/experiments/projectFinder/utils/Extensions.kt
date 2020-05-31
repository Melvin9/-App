package com.melvin9.projects.school.experiments.projectFinder.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*

fun Any?.logd(tag: String = "Projects_LOG"){
    Log.d(tag, this.toString())
}

fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()