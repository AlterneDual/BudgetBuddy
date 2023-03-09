package run.budgetbuddy.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import run.budgetbuddy.R
import run.budgetbuddy.activities.MG.MgInicio

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Establece un temporizador para mostrar la actividad principal después de 3 segundos
        val splashTimer = object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, MgInicio::class.java))
                finish()
            }
        }
        splashTimer.start()

    }
}