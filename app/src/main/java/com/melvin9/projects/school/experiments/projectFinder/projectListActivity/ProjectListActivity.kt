package com.melvin9.projects.school.experiments.projectFinder.projectListActivity

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
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
        setActionBar()
        type=intent.getStringExtra("clickedProject")!!
        projectListPresenter.onCreate(this,this,intent)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView =menu.findItem(R.id.search).actionView as SearchView
        (searchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        setSearchView(searchView)
        return true
    }


    override fun renderProjectTypes(context: Context, data: List<ProjectTypes>) {
//        typeRecyclerView?.layoutManager = LinearLayoutManager(this@ProjectListActivity, LinearLayoutManager.HORIZONTAL, false)
//        typeRecyclerView?.adapter =  ProjectTypesAdapter(data)
    }

    override fun renderProjectLists(context: Context,data:List<Project>) {

        listRecyclerView?.layoutManager = LinearLayoutManager(this@ProjectListActivity, LinearLayoutManager.VERTICAL, false)
        listRecyclerView?.adapter =  ProjectListsAdapter(data)
        (listRecyclerView?.adapter as ProjectListsAdapter).notifyDataSetChanged()
        if(data.isEmpty()){
            emptyImage.alpha= 1F
        }
        else{
            emptyImage.alpha = 0F
        }
    }
    private fun setActionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }
    private fun setSearchView(searchView: SearchView){
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                projectListPresenter.filterList(this@ProjectListActivity,query!!,this@ProjectListActivity)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                projectListPresenter.filterList(this@ProjectListActivity,newText!!,this@ProjectListActivity)
                return true
            }

        })
    }
}
