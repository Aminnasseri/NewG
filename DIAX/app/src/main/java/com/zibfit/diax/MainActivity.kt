package com.zibfit.diax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.analytics.FirebaseAnalytics
import com.zibfit.diax.R
import kotlinx.android.synthetic.main.activity_main.*
private lateinit var backToast: Toast


class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Video Button
        btn_video.setOnClickListener{
            startActivity(Intent(this,WatchVideoActivity::class.java))
        }

       // firebaseAnalytics = FirebaseAnalytics.getInstance(this);

        //Change color button

        btn_covid19_start.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent))



        btn_covid19_start.setOnClickListener {
            startActivity(Intent(this,OpenKitActivity::class.java))
            finish()
        }

        btn_history.setOnClickListener {
            startActivity(Intent(this,HistoryActivity::class.java))
            finish()
        }
    }

    private val TIME_INTERVAL =
        2000 // # milliseconds, desired time passed between two back presses.

    private var mBackPressed: Long = 0

    override fun onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            backToast.cancel()
            super.onBackPressed()
            return
        } else {
            backToast =
                Toast.makeText(baseContext, "Tap back button in order to exit", Toast.LENGTH_SHORT)
            backToast.show()
        }
        mBackPressed = System.currentTimeMillis()
    }
}