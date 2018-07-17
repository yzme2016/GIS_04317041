package yanz.sqliteexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        var db = DatabaseHandler(context)

        btn_insert.setOnClickListener({
             var userx=User()
             db.deleteData()
             try {
                 for (i in 0..(userx.lokasi.size-1)){
                     var u = User(userx.lokasi.get(i).toString(), userx.lattitude.get(i).toDouble(),userx.Longitude.get(i).toDouble())
                     db.insertData(u)
                 }
                 } finally {
                 Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show()
                 }
             //var user=User(etvName.text.toString(),etvLat.text.toString().toDouble(),etvLong.text.toString().toDouble())
             //db.insertData(user)
             //Toast.makeText(context,"Please Fill All Data's",Toast.LENGTH_SHORT).show()
       })

        btn_read.setOnClickListener({
            var data = db.readData()
            tvResult.text=""
            for (i in 0..(data.size-1)){
                tvResult.append(data.get(i).id.toString() + " " + data.get(i).name + " " + data.get(i).lat + " " + data.get(i).long + "\n")
            }
        })

        btn_open.setOnClickListener({
            val mainToMap = Intent(this,MapsActivity::class.java)
            startActivity(mainToMap)
        })
    }


}
