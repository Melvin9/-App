package com.melvin9.projects.school.experiments.projectFinder.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.mainActivity.MainActivity
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(){


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (text_dashboard == null) return
        MainActivity.data.observe(this as LifecycleOwner, Observer {
            text_dashboard.text=it.toString()
        })
    }

}
