package id.co.mka.fundamental_androi_kotlin


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.mka.fundamental_androi_kotlin.databinding.ActivityKetigaBinding
import id.co.mka.fundamental_androi_kotlin.fragment.FragmentKedua
import id.co.mka.fundamental_androi_kotlin.fragment.fragment_pertama

class ActivityKetiga : AppCompatActivity() {

    // Activasi View Binding Activity Ketiga
    private lateinit var bindingKetiga : ActivityKetigaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingKetiga = ActivityKetigaBinding.inflate(layoutInflater)
        setContentView(bindingKetiga.root)

        // Mengambil Data dan Pesan Dari Activity Kedua
        with(bindingKetiga){

            // Memanggil Fungsi Fragment
            callFragment()

            val ambilNama = intent.getStringExtra("EXTRA_NAME") // Context Name Harus Sama
            val ambilHobi = intent.getStringExtra("Extra Hobi")
            val hasil  = "Hy $ambilNama Hobi Kamu $ambilHobi ya?"
            tvActivityKetiga.text = hasil

            // Fungsi Button 1 Fragment
            btnFragment1.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.container_fragment, fragment_pertama())
                    addToBackStack(null)
                    commit()
                }
            }
            // Fungsi Button 2 Fragment
            btnFagment2.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.container_fragment, FragmentKedua())
                    addToBackStack(null)
                    commit()
                }
            }
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
    // Memanggil fragment
    private fun callFragment(){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_fragment, fragment_pertama())
            commit()
        }
    }

}