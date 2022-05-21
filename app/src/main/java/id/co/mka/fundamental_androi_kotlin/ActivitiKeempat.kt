package id.co.mka.fundamental_androi_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import id.co.mka.fundamental_androi_kotlin.databinding.ActivityActivitiKeempatBinding

class ActivitiKeempat : AppCompatActivity() {

    private lateinit var bindingkeempat : ActivityActivitiKeempatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingkeempat = ActivityActivitiKeempatBinding.inflate(layoutInflater)
        setContentView(bindingkeempat.root)

        with(bindingkeempat){

        }
    }

    // Memanggil Fungsi Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    // Membuat Fungsi Menu Aktif berdasarkan Klik
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tb_setting -> Toast.makeText(this, "Anda Mengklik Setting", Toast.LENGTH_LONG ).show()
            R.id.tb_feedback -> Toast.makeText(this, "Anda Memberikan Feedback", Toast.LENGTH_LONG ).show()
            R.id.tb_vavorit -> Toast.makeText(this, "Anda Memilih Favorit", Toast.LENGTH_LONG ).show()
            R.id.tb_getContact -> Toast.makeText(this, "Anda Mendapatkan Kontak", Toast.LENGTH_LONG ).show()
            R.id.tb_exit -> finish()
        }
        return true
    }
}