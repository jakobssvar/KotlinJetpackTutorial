package com.example.kotlinjetpacktutorial.view.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.kotlinjetpacktutorial.R
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.R)    {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }      else{
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        splashAnimation.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
               //
            }

            override fun onAnimationEnd(animation: Animation?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()

                }, 1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {
                //
            }
        })
        tvSplash.animation = splashAnimation

    }
}