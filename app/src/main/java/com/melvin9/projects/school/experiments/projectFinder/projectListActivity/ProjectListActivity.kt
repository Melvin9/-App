package com.melvin9.projects.school.experiments.projectFinder.projectListActivity

import android.R.color
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.adapter.ProjectListsAdapter
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
        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#ffffff")
        }
    }

    override fun renderProjectTypes(context: Context, data: List<ProjectTypes>) {
//        typeRecyclerView?.layoutManager = LinearLayoutManager(this@ProjectListActivity, LinearLayoutManager.HORIZONTAL, false)
//        typeRecyclerView?.adapter =  ProjectTypesAdapter(data)
    }

    override fun renderProjectLists(context: Context,data:List<Project>) {
        listRecyclerView?.layoutManager = LinearLayoutManager(this@ProjectListActivity, LinearLayoutManager.VERTICAL, false)
        listRecyclerView?.adapter =  ProjectListsAdapter(data)
    }
}
