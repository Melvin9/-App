package com.melvin9.projects.school.experiments.projectFinder.projectListActivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectLists

class ProjectListsAdapter(private val ProjectLists: List<ProjectLists>) :
    RecyclerView.Adapter<ProjectListsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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
        return ProjectLists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = ProjectLists[position].title
        holder.descriptionTextView.text = ProjectLists[position].description
        holder.titleTextView.text = ProjectLists[position].title
        Glide.with(holder.context)
            .load(ProjectLists[position].imageURL)
            .centerCrop()
            .placeholder(R.drawable.ic_physics)
            .error(R.drawable.ic_physics)
            .fallback(R.drawable.ic_physics)
            .into(holder.imageView)
    }
}