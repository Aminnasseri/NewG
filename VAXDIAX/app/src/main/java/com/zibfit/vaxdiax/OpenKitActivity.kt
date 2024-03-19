package com.zibfit.vaxdiax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_open_kit.*
import kotlinx.android.synthetic.main.toolbar_open_kit.*
private lateinit var backToast: Toast

class OpenKitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_kit)

        setSupportActionBar(toolbarOpenKit as Toolbar?)
        setSupportActionBar(findViewById(R.id.toolbarOpenKit))

        val actionBar: ActionBar? = supportActionBar
        home_toolbar_open_kit.setOnClickListener {  startActivity(Intent(this,HomeActivity::class.java))
            overridePendingTransition(R.anim.left_in, R.anim.right_out)
            finish()
        }


        btn_open_kit.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent))
        btn_open_kit.setOnClickListener {  startActivity(Intent(this,QRReaderActivity::class.java))
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