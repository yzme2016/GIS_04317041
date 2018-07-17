package yanz.sqliteexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    //val db = DatabaseHandler(this )
    //var data = db.readData()

    private val Usr = User()
    private val UsrLat = User().lattitude
    private val UsrLon = User().Longitude
    private val UsrLoc = User().lokasi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera

        val startPoint = LatLng(UsrLat.get(1).toDouble(), UsrLon.get(0).toDouble())
        for (i in 0..(Usr.lokasi.size-1)) {
            var titik = LatLng(UsrLat.get(i).toDouble(), UsrLon.get(i).toDouble())
            mMap.addMarker(MarkerOptions().position(titik).title(UsrLoc.get(i).toString()))
        }
        drawLine()
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(startPoint,10.0f))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

    }

    fun drawLine() {

        val options = PolylineOptions()
        options.color(R.color.blaze)
        options.width(10F)
        for (i in 0..(Usr.lokasi.size-1)) {
            options.add(LatLng(UsrLat.get(i).toDouble(), UsrLon.get(i).toDouble()))
        }
        mMap.addPolyline(options)


    }

}
