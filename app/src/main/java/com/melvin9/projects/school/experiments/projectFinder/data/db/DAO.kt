package com.melvin9.projects.school.experiments.projectFinder.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Favourite
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun projectInsert(projects: List<Project>)

    @Query("Select * from project")
    fun getProjectData():LiveData<List<Project>>

    @Query("Delete from project ")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun favouriteInsert(data:Favourite)

    @Query("Select * from favourite where id = :id")
    fun getFavoriteData(id: String): Favourite?

    @Query("Select * from favourite")
    fun getAllFavorites(): List<Favourite>

    @Query("Delete from favourite where id LIKE :projectId")
    fun deleteFavourite(projectId: String)



}