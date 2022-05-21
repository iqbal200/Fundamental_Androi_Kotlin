package id.co.mka.fundamental_androi_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.co.mka.fundamental_androi_kotlin.databinding.ActivitySelanjutnyaBinding

@Suppress("DEPRECATION")
class ActivityKedua : AppCompatActivity() {

    // Inialisai View Binding
    private lateinit var secondActivity : ActivitySelanjutnyaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondActivity = ActivitySelanjutnyaBinding.inflate(layoutInflater)
        setContentView(secondActivity.root)

        // Inialisasi viewBinding
        with(secondActivity){

            // Activasi Tombol Kembali
            btnKembaliActivity.setOnClickListener {
                finish()
            }

            // Membuat Custom Toast
            btnToast.setOnClickListener {
                    Toast(this@ActivityKedua).apply {
                        duration = Toast.LENGTH_LONG
                        val clToasts = null
                        view = layoutInflater.inflate(R.layout.custom_toast, clToasts)
                        show()
                    }
            }
            // Mengirim Data Ke Activity Ketiga
            btnKirimdata.setOnClickListener {
                Intent (this@ActivityKedua,ActivityKetiga::class.java) .also {
                    val nama = edNama.text.toString()
                    val hobi = edHobi.text.toString()
                    it.putExtra("EXTRA_NAME", nama)
                    it.putExtra("Extra Hobi", hobi)
                    startActivity(it)
                }
            }
        }

    }
}