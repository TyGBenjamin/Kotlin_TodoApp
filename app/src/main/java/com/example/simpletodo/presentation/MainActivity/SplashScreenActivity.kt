package com.example.simpletodo.presentation.MainActivity

import android.app.Activity
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.simpletodo.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
         val ivSplash = findViewById<ImageView>(R.id.iv_check)
        ivSplash.alpha = 0f
        ivSplash.animate().setDuration(1500).alpha(1f).withEndAction{
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in ,android.R.anim.fade_out)
            finish()
        }
    }
}