package com.melvin9.projects.school.experiments.projectFinder.projectContent

import android.content.Context
import com.melvin9.projects.school.experiments.projectFinder.data.db.ProjectDatabase
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Favourite
import com.melvin9.projects.school.experiments.projectFinder.utils.logd
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProjectContentPresenter {

    private var isFavourite = false

    private fun addToFavorites(context: Context, id: String) = GlobalScope.launch {
        ProjectDatabase(context).projectDao().favouriteInsert(Favourite(id))
    }

    private fun removeFavourites(context: Context, id: String) = GlobalScope.launch {
        ProjectDatabase(context).projectDao().deleteFavourite(id)
    }

    fun choose(
        context: Context,
        id: String,
        view: ProjectContentView
    ) {
        GlobalScope.launch {
            if (isFavourite){
                removeFavourites(context, id)
            }else{
                addToFavorites(context, id)
            }
            isFavourite = !isFavourite
            view.setFavoriteStatus(isFavourite, true)
        }
    }

    fun onCreate(
          context: Context,
          id: String,
          view: ProjectContentView
    ){
        GlobalScope.launch {
            ProjectDatabase(context).projectDao().getFavoriteData(id).logd()
            isFavourite = ProjectDatabase(context).projectDao().getFavoriteData(id) != null
            view.setFavoriteStatus(isFavourite)
        }
    }

}