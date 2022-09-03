package id.co.mka.fundamental_androi_kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.co.mka.fundamental_androi_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //
    private lateinit var inibinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(inibinding.root)

        with(inibinding){

            // Share Preference
            val sharePref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
            val editor = sharePref.edit()
            btnSave.setOnClickListener {
                val name = tvfNama.text.toString()
                val umur = tvfUmur.text.toString().toInt()
                val checked = RbAdult.isChecked
                editor.apply {
                    putString("name", name)
                    putInt( "umur", umur)
                    putBoolean("checked", checked)
                    apply()
                }
                Log.d("MainActivity", "$name, $umur, Status $checked")
            }

            // Button Load SharePreference
            btnLoad.setOnClickListener {
                val name = sharePref.getString("name", null)
                val umur = sharePref.getInt("umur", 0)
                val checked = sharePref.getBoolean("checked", false)

                tvfNama.setText(name)
                tvfUmur.setText(umur.toString())
                RbAdult.isChecked = checked
            }
            // Cara Berpindah Activity Menggunakan
            btnPindahActivity.setOnClickListener {
                    Intent(this@MainActivity, ActivityKedua::class.java).also {
                        startActivity(it)
                    }
            }

        }



        // Cara Menghitung Dengan Tombol
        with(inibinding){
            var hitung = 0
            btnHitung.setOnClickListener {
                hitung++
                tvMenghitung.text = "Cobalah hitung ini $hitung"
            }

            // Cara Mengambil Data Ke Logcat
            btnApply.setOnClickListener {
             val nama =etNamaAwal.text.toString()
             val namaAkhir = etNamaAkhir.text.toString()
              val tgllahir =  etTglLahir.text.toString()
              val namakota = etNamaNegara.text.toString()
                Log.d("MainActivity", "$nama, $namaAkhir, Tanggal Lahir $tgllahir, Negara $namakota")

            }
        }
    }



}