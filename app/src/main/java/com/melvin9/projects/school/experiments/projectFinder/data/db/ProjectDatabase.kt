package com.melvin9.projects.school.experiments.projectFinder.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project

@Database(
    entities = [Project::class],
    version = 1
)
abstract class ProjectDatabase : RoomDatabase() {
    abstract fun projectDao(): DAO

    companion object {
        @Volatile
        private var instance: ProjectDatabase? = null
        private val Lock = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ProjectDatabase::class.java,
            "projects.db"
        ).build()

    }
}