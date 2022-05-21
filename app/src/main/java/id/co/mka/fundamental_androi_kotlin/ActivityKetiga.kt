package id.co.mka.fundamental_androi_kotlin


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.mka.fundamental_androi_kotlin.databinding.ActivityKetigaBinding

class ActivityKetiga : AppCompatActivity() {

    // Activasi View Binding Activity Ketiga
    private lateinit var bindingKetiga : ActivityKetigaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingKetiga = ActivityKetigaBinding.inflate(layoutInflater)
        setContentView(bindingKetiga.root)

        // Mengambil Data dan Pesan Dari Activity Kedua
        with(bindingKetiga){
            val ambilNama = intent.getStringExtra("EXTRA_NAME") // Context Name Harus Sama
            val ambilHobi = intent.getStringExtra("Extra Hobi")
            val hasil  = "Hy $ambilNama Hobi Kamu $ambilHobi ya?"
            tvActivityKetiga.text = hasil
        }
        // Berpindah Activity Keempat
        with(bindingKetiga){
            btnKeempat.setOnClickListener {
                Intent(this@ActivityKetiga,ActivitiKeempat::class.java).also {
                    startActivity(it)
                }
            }
        }

    }
}