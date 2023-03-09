package run.budgetbuddy.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import run.budgetbuddy.R
import run.budgetbuddy.activities.MG.MgInicio

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageView = findViewById<ImageView>(R.id.splash_logo_budget)
        val animZoomIn = AnimationUtils.loadAnimation(applicationContext, R.anim.animation_splash)
        animZoomIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                // Iniciar la actividad principal después de que finalice la animación
                startActivity(Intent(this@SplashActivity, MgInicio::class.java))
                finish()
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })
        imageView.startAnimation(animZoomIn)
    }

    }
