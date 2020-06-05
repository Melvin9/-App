package com.melvin9.projects.school.experiments.projectFinder.notifications

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melvin9.projects.school.experiments.projectFinder.BuildConfig
import com.melvin9.projects.school.experiments.projectFinder.R
import kotlinx.android.synthetic.main.fragment_notifications.*


class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareView.setOnClickListener {
            try {
                val share = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_SUBJECT, "Project Finder")
                    var shareMessage = "\nLet me recommend you this application\n\n"
                    shareMessage =
                        """
                    ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                    """.trimIndent()
                    putExtra(Intent.EXTRA_TEXT, shareMessage)

                }
                startActivity(Intent.createChooser(share, "choose one"))

            } catch (e: Exception) {
                //e.toString();
            }
        }
        rateView.setOnClickListener{
            try{
                val intent1 = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "market://details?id="
                                + view.context.packageName
                    )
                )
                startActivity(intent1)

            }
            catch (e: Exception){
                val intent1 = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://play.google.com/store/apps/details?id="
                                + view.context.packageName
                    )
                )
                startActivity(intent1)
            }
        }
    }
}
