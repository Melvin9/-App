package com.melvin9.projects.school.experiments.projectFinder.projectListActivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.adapter.ProjectListsAdapter
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.adapter.ProjectTypesAdapter
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectLists
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.data.ProjectTypes
import kotlinx.android.synthetic.main.activity_project_list.*

class ProjectListActivity : AppCompatActivity(),ProjectListInterface {
    companion object{
       lateinit var type: String
    }
    private val projectListPresenter=ProjectListPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_list)
        type=intent.getStringExtra("clickedProject")!!
        projectListPresenter.onCreate(this,this)

    }

    override fun renderProjectTypes(context: Context, data: List<ProjectTypes>) {
        typeRecyclerView?.layoutManager = LinearLayoutManager(this@ProjectListActivity, LinearLayoutManager.HORIZONTAL, false)
        typeRecyclerView?.adapter =  ProjectTypesAdapter(data)
    }

    override fun renderProjectLists(context: Context,data:List<ProjectLists>) {
        listRecyclerView?.layoutManager = LinearLayoutManager(this@ProjectListActivity, LinearLayoutManager.VERTICAL, false)
        listRecyclerView?.adapter =  ProjectListsAdapter(data)
    }
}
