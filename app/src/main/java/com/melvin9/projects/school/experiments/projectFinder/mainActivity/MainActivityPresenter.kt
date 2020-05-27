package com.melvin9.projects.school.experiments.projectFinder.mainActivity

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.melvin9.projects.school.experiments.projectFinder.data.db.ProjectDatabase
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project
import com.melvin9.projects.school.experiments.projectFinder.data.network.ApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityPresenter {
    var projectData = MutableLiveData<List<Project>>()
    fun onCreate(context: Context) {
        getDataFromDB(context)
        getDataFromServer {
            storeDataToDB(context, it)
        }
    }

    private fun getDataFromDB(context: Context) {
        ProjectDatabase(context).projectDao().getProjectData().observe(context as LifecycleOwner,
            Observer {
                projectData.value = it
                MainActivityImpl.data=projectData
            })
    }

    private fun getDataFromServer(callback: (data: List<Project>) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = ApiHandler().getProjectsAsync().await()
            callback(response.project)
        }
    }

    private fun storeDataToDB(context: Context, data: List<Project>) {
        ProjectDatabase(context).projectDao().insert(data)
    }

}

