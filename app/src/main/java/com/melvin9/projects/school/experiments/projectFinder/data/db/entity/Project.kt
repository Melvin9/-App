package com.melvin9.projects.school.experiments.projectFinder.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "project")
data class Project(
    @SerializedName("cost")
    val cost: Int?,
    @SerializedName("itemsRequired")
    val itemsRequired: String?,
    @SerializedName("projectTitle")
    val projectTitle: String?,
    @SerializedName("projectType")
    val projectType: String?,
    @SerializedName("steps")
    val steps: String?,
    @PrimaryKey
    @SerializedName("_id")
    val id: String,
    @ColumnInfo(defaultValue = "0")
    val favourite : Int?
)
