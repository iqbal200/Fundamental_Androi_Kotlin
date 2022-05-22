package id.co.mka.fundamental_androi_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import id.co.mka.fundamental_androi_kotlin.databinding.ActivityMainBinding
import id.co.mka.fundamental_androi_kotlin.databinding.FragmentPertamaBinding
import id.co.mka.fundamental_androi_kotlin.fragment.fragment_kedua
import id.co.mka.fundamental_androi_kotlin.fragment.fragment_pertama

class MainActivity : AppCompatActivity() {
    //
    private lateinit var inibinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inibinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(inibinding.root)


        // Cara Berpindah Activity Menggunak
        with(inibinding){

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