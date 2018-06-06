package main.yz.gis

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c: Calendar = Calendar.getInstance()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)
        label.text = "$day/$month/$year"
        btnTampil.setOnClickListener{readData()}
        btnMapN.setOnClickListener{
            val mainToMap = Intent(this,MapsActivity::class.java)
            startActivity(mainToMap)
        }
    }

    fun readData(): MutableList<ArrayModel> {
        val list = ArrayList<ArrayModel>()
        val teks: String = etLokasi.text.toString()
        list.add(ArrayModel(1,"ITATS","-7.289241","112.778776"))
        list.add(ArrayModel(2,"NAROTAMA","-7.288075","112.776449"))

        for (n:ArrayModel in list) {
            if(teks==n.lokasi){
                tvLong.setText(n.long)
                tvLat.setText(n.lat)
                Toast.makeText(this , "Data ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
        return list
    }






    }
