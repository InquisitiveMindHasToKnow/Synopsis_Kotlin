package org.ohmstheresistance.synopsiskotlin

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bar: ActionBar? = supportActionBar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            bar!!.setBackgroundDrawable(ColorDrawable(getColor(R.color.actionBarColorTest)))
        }
    }
}
