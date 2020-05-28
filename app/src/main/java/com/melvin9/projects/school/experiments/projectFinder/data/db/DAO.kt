package com.melvin9.projects.school.experiments.projectFinder.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(projects: List<Project>)

    @Query("Select * from project")
    fun getProjectData():LiveData<List<Project>>

    @Query("Delete from project ")
    fun deleteAll()

}