package pillowisgod.com.vertagelab.data.repository.apicalls

import pillowisgod.com.vertagelab.data.repository.model.PlacesModel
import retrofit2.http.GET


interface TestApiCall {

    @GET("/kyiv/places")
    suspend fun getUserPlaces() : PlacesModel
}