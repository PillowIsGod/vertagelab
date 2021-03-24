package pillowisgod.com.vertagelab.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pillowisgod.com.vertagelab.data.database.LoginDAO
import pillowisgod.com.vertagelab.data.database.LoginData
import pillowisgod.com.vertagelab.data.repository.apicalls.TestApiCall
import pillowisgod.com.vertagelab.data.repository.model.PlaceResponse

class MapViewModel : ViewModel() {
    private var placesList = MutableLiveData<List<PlaceResponse>>()
    val places : LiveData<List<PlaceResponse>> = placesList
    private var loginData = MutableLiveData<LoginData>()
    val loginInfo : LiveData<LoginData> = loginData

    fun getApiData(testApiCall: TestApiCall) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = testApiCall.getUserPlaces()
                placesList.postValue(data.placesObj)
            }
        }
    }

    fun getRoomData(dao: LoginDAO) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = dao.getAll()
                loginData.postValue(data[0])
            }

        }
    }
}