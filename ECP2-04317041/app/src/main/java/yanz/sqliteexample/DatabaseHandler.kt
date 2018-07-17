package yanz.sqliteexample

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "TrainST.db"
val TABLE_NAME = "Station"
val COL_NAME = "Name"
val COL_AGE = "age"
val COL_ID = "id"
val COL_LAT = "Lat"
val COL_LONG = "Long"




class DatabaseHandler(var context:Context) :SQLiteOpenHelper(context, DATABASE_NAME,null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID +" INTEGER PRIMARY KEY," +
                COL_NAME + " VARCHAR(256), " +
                COL_LAT+ " DOUBLE, " + COL_LONG +" DOUBLE)"

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user: User ){
        val db = this.writableDatabase

        var cv = ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_LAT,user.lat)
        cv.put(COL_LONG,user.long)
        var result = db.insert(TABLE_NAME,null,cv)
  /*      if (result==-1.toLong())
           Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show()
*/
    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()
        var db = this.readableDatabase
        var query = "Select * from " + TABLE_NAME
        var result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)  ).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.lat = result.getString(result.getColumnIndex(COL_LAT)).toDouble()
                user.long = result.getString(result.getColumnIndex(COL_LONG)).toDouble()
                list.add(user)
            }while (result.moveToNext()
                    )
        }
        result.close()
        db.close()

        return list

    }

    fun deleteData() {
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null,null)
        db.close()

    }
}


