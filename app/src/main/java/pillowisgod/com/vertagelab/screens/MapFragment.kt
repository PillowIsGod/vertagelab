package pillowisgod.com.vertagelab.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_map.*
import pillowisgod.com.vertagelab.R
import pillowisgod.com.vertagelab.adapters.PlacesAdapter
import pillowisgod.com.vertagelab.data.database.LoginDAO
import pillowisgod.com.vertagelab.data.repository.apicalls.TestApiCall
import pillowisgod.com.vertagelab.helpers.Constants.MAPVIEW_BUNDLE_KEY
import pillowisgod.com.vertagelab.viewmodels.LoginViewModel
import pillowisgod.com.vertagelab.viewmodels.MapViewModel
import javax.inject.Inject


class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var mapView : MapView
    private val viewModel : MapViewModel by activityViewModels()
    @Inject lateinit var loginDAO : LoginDAO
    @Inject lateinit var testApiCall : TestApiCall
    private val placesAdapter = PlacesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap(savedInstanceState)
        viewModel.getApiData(testApiCall)
        initAdapter()
        initActionBar()

    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        viewModel.places.observe(viewLifecycleOwner) { listPlaces ->
            listPlaces.forEach { place ->
                val pos = LatLng(place.lat, place.lng)
                mMap.addMarker(MarkerOptions().position(pos).title(place.name))
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(listPlaces[0].lng, listPlaces[0].lat)))
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY) ?: Bundle().also {
            outState.putBundle(MAPVIEW_BUNDLE_KEY, it)
        }
        mapView.onSaveInstanceState(mapViewBundle)
    }

    private fun initAdapter() {
        viewModel.places.observe(viewLifecycleOwner) { placesResponse ->
            placesAdapter.setData(placesResponse)
            rvMarkersList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvMarkersList.adapter = placesAdapter
        }
    }
    private fun initActionBar() {
        viewModel.getRoomData(dao = loginDAO)
        viewModel.loginInfo.observe(viewLifecycleOwner) {
            activity?.title = it.mail
        }
    }


    private fun initMap(savedInstanceState: Bundle?) {
        mapView = view?.findViewById(R.id.testMap)!!
        val mapViewBundle = savedInstanceState?.getBundle(MAPVIEW_BUNDLE_KEY)
        mapView.onCreate(mapViewBundle)
        mapView.getMapAsync(this)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }
    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}