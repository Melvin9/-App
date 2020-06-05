package com.melvin9.projects.school.experiments.projectFinder.favourite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.data.db.entity.Project
import com.melvin9.projects.school.experiments.projectFinder.projectListActivity.adapter.ProjectListsAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class FavouriteFragment : Fragment(),FavouriteInterface{

    private val favouritePresenter=FavouritePresenter()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root= inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                favouritePresenter.filterList(view.context,query!!,this@FavouriteFragment)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                favouritePresenter.filterList(view.context,newText!!,this@FavouriteFragment)
                return true
            }
        })
        sort.setOnClickListener {
            favouritePresenter.sort(view.context,this)
        }
    }
    override fun render(context: Context, data: List<Project>) {
        listRecyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        listRecyclerView?.adapter =  ProjectListsAdapter(data)
        (listRecyclerView?.adapter as ProjectListsAdapter).notifyDataSetChanged()
        if(data.isEmpty()){
            emptyImage.alpha= 1F
        }
        else{
            emptyImage.alpha = 0F
        }
    }

    override fun onResume() {
        super.onResume()
        favouritePresenter.onFavourites(requireContext(),this)

    }
}
