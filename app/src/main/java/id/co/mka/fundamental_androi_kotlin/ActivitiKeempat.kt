package id.co.mka.fundamental_androi_kotlin

import android.content.ClipData
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.toColor
import id.co.mka.fundamental_androi_kotlin.databinding.ActivityActivitiKeempatBinding

class ActivitiKeempat : AppCompatActivity() {

    private lateinit var bindingkeempat : ActivityActivitiKeempatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingkeempat = ActivityActivitiKeempatBinding.inflate(layoutInflater)
        setContentView(bindingkeempat.root)

        with(bindingkeempat){

            // Memanggil Fungtion
            buttonDialog1.setOnClickListener {
              addContactDialog()
            }
            // Memanggil Fungtion
            buttonDialog2.setOnClickListener {
                singleChoiseDialog()
            }
            // Memanggil Fungtion
            buttonDialog3.setOnClickListener {

            }
            // Memanggil Fungtion
            buttonDialog4.setOnClickListener {

            }


        }

        with(bindingkeempat){
            // Membuat Function Untuk Spinner
            actionBarSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        Toast.makeText(this@ActivitiKeempat,
                            "Kamu Memilih ${adapterView?.getItemAtPosition(position).toString()}",
                            Toast.LENGTH_LONG).show()

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }
    }

    // Function Untuk Membuat Alert Dialog Button Pertama
    private fun addContactDialog(){
        AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Apakah anda mau menambah kontak?")
            .setIcon(R.drawable.ic_baseline_done_all_24)
            .setPositiveButton("Ya") {_, _ ->
                Toast.makeText(this,"Anda Menambahkan Kontak Anda", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Tidak") {_, _ ->
                Toast.makeText(this,"Sayang Sekali anda tidak memilih kontak", Toast.LENGTH_SHORT).show()
            }.create()
            .show()
    }

    // Function Untuk Membuat Alert Dialog Button Kedua
    val option = arrayOf("Item Pertama", "Item Kedua", "Item Ketiga")
    private fun singleChoiseDialog(){
        AlertDialog.Builder(this)
            .setTitle("Pilih salah satu dari Pilihan Dibawah")
            .setSingleChoiceItems(option,0){DialogInterface, i ->
                Toast.makeText(this, "Pilihanmu adalah ${option[i]}", Toast.LENGTH_LONG).show()
            } .setPositiveButton("Accept") {_, _ ->
                Toast.makeText(this,"Anda Menerima", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline") {_, _ ->
                Toast.makeText(this,"Sayang Sekali anda tidak memilih Satu Dialog", Toast.LENGTH_SHORT).show()
            }.create()
            .show()
    }

    // Memanggil Fungsi Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    // Membuat Fungsi Menu Aktif berdasarkan Klik
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            // Memindahkan menu setting ke Activity Ketiga
            R.id.tb_setting -> Intent(this,ActivityKetiga::class.java).also {
                startActivity(it)
            }
            R.id.tb_feedback -> Toast.makeText(this, "Anda Memberikan Feedback", Toast.LENGTH_LONG ).show()
            R.id.tb_vavorit -> Toast.makeText(this, "Anda Memilih Favorit", Toast.LENGTH_LONG ).show()
            R.id.tb_getContact -> Toast.makeText(this, "Anda Mendapatkan Kontak", Toast.LENGTH_LONG ).show()
            R.id.tb_exit -> finish()
        }
        return true
    }
}