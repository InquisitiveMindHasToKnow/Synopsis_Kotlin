package org.ohmstheresistance.synopsiskotlin

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bar: ActionBar? = supportActionBar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            bar!!.setBackgroundDrawable(ColorDrawable(getColor(R.color.actionBarColorTest)))
        }

        val profileAboutMeButton: Button = findViewById(R.id.profile_about_me_button)
        val profileContactMeButton: Button = findViewById(R.id.profile_contact_me_button)
        val profileProjectsButton: Button = findViewById(R.id.profile_projects_button)
        val profileResumeButton: Button = findViewById(R.id.profile_resume_button)

        profileAboutMeButton.setOnClickListener(this)
        profileContactMeButton.setOnClickListener(this)
        profileProjectsButton.setOnClickListener(this)
        profileResumeButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        val navigationIntent: Intent

        when (view!!.id) {
            R.id.profile_about_me_button -> {
                navigationIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(navigationIntent)
            }
            R.id.profile_contact_me_button -> {
                navigationIntent = Intent(this@MainActivity, ContactMe::class.java)
                startActivity(navigationIntent)
            }
            R.id.profile_projects_button -> {
                navigationIntent = Intent(this@MainActivity, Projects::class.java)
                startActivity(navigationIntent)
            }
            R.id.profile_resume_button -> {
                navigationIntent = Intent(this@MainActivity, Resume::class.java)
                startActivity(navigationIntent)
            }
        }
    }


}
