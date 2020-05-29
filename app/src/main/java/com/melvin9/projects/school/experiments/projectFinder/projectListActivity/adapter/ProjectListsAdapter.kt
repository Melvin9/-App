package com.melvin9.projects.school.experiments.projectFinder.projectListActivity.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin9.projects.school.experiments.projectFinder.ProjectContent
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project

class ProjectListsAdapter(private val projectLists: List<Project>) :
    RecyclerView.Adapter<ProjectListsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.projectTitleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.projectDescriptionTextView)
        val imageView: ImageView = view.findViewById(R.id.projectImageView)
        val context: Context = view.context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_project_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return projectLists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = projectLists[position].projectTitle
        holder.descriptionTextView.text = projectLists[position].projectDescription
        Glide.with(holder.context)
            .load(projectLists[position].imageLink)
            .centerCrop()
            .placeholder(R.drawable.ic_physics)
            .error(R.drawable.ic_physics)
            .fallback(R.drawable.ic_physics)
            .into(holder.imageView)

        holder.itemView.setOnClickListener{
            val intent=Intent(holder.context,ProjectContent::class.java).apply {
                putExtra("videoURL",projectLists[position].videoLink)
                putExtra("description",projectLists[position].projectDescription)
                putExtra("title",projectLists[position].projectTitle)
                putExtra("steps",projectLists[position].steps)
                putExtra("items",projectLists[position].itemsRequired)

            }
            startActivity(holder.context,intent, Bundle.EMPTY)
        }
    }
}