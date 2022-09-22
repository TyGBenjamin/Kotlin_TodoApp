package com.example.simpletodo.presentation.MainActivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.simpletodo.R


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val handler = Handler()
        handler.postDelayed({ // TODO: Your application init goes here.
            val mInHome = Intent(this@SplashScreenActivity, DashboardActivity::class.java)
            startActivity(mInHome)
            this@SplashScreenActivity.finish()
        }, 5000)
    }

}