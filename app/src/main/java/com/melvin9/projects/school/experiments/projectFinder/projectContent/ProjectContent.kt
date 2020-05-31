package com.melvin9.projects.school.experiments.projectFinder.projectContent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.melvin9.projects.school.experiments.projectFinder.R
import com.melvin9.projects.school.experiments.projectFinder.utils.toast
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_project_content.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProjectContent : AppCompatActivity(), ProjectContentView {
    companion object {
        var id: String = String()
    }
    private val presenter=ProjectContentPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_content)
        videoPlayer()
        render()
        presenter.onCreate(this, id, this)
        favourite.setOnClickListener {
           presenter.choose(this, id, this)
        }

    }

    private fun render() {
        heart.isVisible = false
        projectTitle.text = intent.getStringExtra("title")!!
        description.text = intent.getStringExtra("description")!!
        steps.text = intent.getStringExtra("steps")!!
        itemsRequired.text = intent.getStringExtra("items")!!
        id = intent.getStringExtra("id")!!
    }

    private fun videoPlayer() {
        val youTubePlayerView =
            findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = intent.getStringExtra("videoURL")!!
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
    }

    override fun setFavoriteStatus(status: Boolean, showToast: Boolean) {
        GlobalScope.launch {
            withContext(Dispatchers.Main){
                heart.setImageResource(if (status) R.drawable.heart_ic else R.drawable.heart_icon)
                favTextView.alpha= if (status) 0F else 1F
                heart.isVisible = true
                if (showToast){
                    toast(if (status) "Added" else "Removed")
                }
            }
        }
    }
}
