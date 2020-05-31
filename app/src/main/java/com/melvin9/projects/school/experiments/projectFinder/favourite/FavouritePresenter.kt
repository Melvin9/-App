package com.melvin9.projects.school.experiments.projectFinder.favourite

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.melvin9.projects.school.experiments.projectFinder.data.db.ProjectDatabase
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project
import com.melvin9.projects.school.experiments.projectFinder.mainActivity.MainActivity
import com.melvin9.projects.school.experiments.projectFinder.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList

class FavouritePresenter {
    var favList:MutableList<Project> =ArrayList()
    fun filterList(context: Context, searchQuery:String, favouriteInterface: FavouriteInterface){
        val newList:MutableList<Project> = ArrayList()
        if(searchQuery.isNotEmpty()) {
            for (item in favList)
                if (item.projectTitle.toString().toLowerCase(Locale.ROOT)
                        .contains(searchQuery.toLowerCase(Locale.ROOT)) || item.projectDescription.toString().toLowerCase(Locale.ROOT)
                        .contains(searchQuery.toLowerCase(Locale.ROOT)) ) {
                    newList.add(item)
                }
            favouriteInterface.render(context, newList)
        }
        else{
            favouriteInterface.render(context, favList)
        }

    }

    fun onFavourites(context: Context,favouriteInterface: FavouriteInterface) {
        var projectList:List<Project> =ArrayList()
        val favId:MutableList<String> = ArrayList()
        MainActivity.data.observe(context as LifecycleOwner, androidx.lifecycle.Observer {
            projectList=it
        })
        GlobalScope.launch {
            val fav =  ProjectDatabase(context).projectDao().getAllFavorites()
            fav.forEach { favId.add(it.id) }
            projectList.forEach{if(it.id in favId)favList.add(it)}
            withContext(Dispatchers.Main){
                favouriteInterface.render(context,favList)
            }
        }
        favList.clear()
    }
}