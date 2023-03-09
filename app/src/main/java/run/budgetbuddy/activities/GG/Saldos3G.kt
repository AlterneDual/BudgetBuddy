//package run.budgetbuddy.activities.GG
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import run.budgetbuddy.databinding.GpSaldoBinding
//
//class Saldos3G : AppCompatActivity() {
//    private lateinit var binding: GpSaldoBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = GpSaldoBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.imageView8.setOnClickListener {
//            val intent = Intent(this, Gastos3G::class.java)
//            startActivity(intent)
//            finish()
//        }
//        binding.tvGastos.setOnClickListener {
//            val intent = Intent(this, Gastos3G::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }
//}