package com.melvin9.projects.school.experiments.projectFinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_project_content.*


class ProjectContent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_content)
        val youTubePlayerView =
            findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = intent.getStringExtra("videoURL")!!
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
        projectTitle.text=intent.getStringExtra("title")!!
        description.text=intent.getStringExtra("description")!!
        steps.text=intent.getStringExtra("steps")!!
        itemsRequired.text=intent.getStringExtra("items")!!
    }
}
