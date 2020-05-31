package com.melvin9.projects.school.experiments.projectFinder.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite")
data class Favourite(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("_id")
    val id: String
)
