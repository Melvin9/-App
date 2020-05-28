package com.melvin9.projects.school.experiments.projectFinder.projectListActivity.adapter

import android.graphics.Color
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectTypes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.ProjectListActivity

class ProjectTypesAdapter(private val list: List<ProjectTypes>) :
    RecyclerView.Adapter<ProjectTypesAdapter.ProjectViewHolder>() {
    class ProjectViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val textView: TextView? = v.findViewById(R.id.cardTextView)
        val linearLayout: LinearLayout? = v.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        return ProjectViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_projects, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.textView?.text =list[position].projectType
        if(list[position].projectType.equals(ProjectListActivity.type,true)){
            holder.linearLayout?.setBackgroundColor(Color.parseColor("#8593ff"))
        }

    }
}