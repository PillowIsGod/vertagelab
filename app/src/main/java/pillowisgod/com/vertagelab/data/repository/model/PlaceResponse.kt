package pillowisgod.com.vertagelab.data.repository.model

import com.google.gson.annotations.SerializedName


data class PlaceResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("lat")
    val lat : Double,
    @SerializedName("lng")
    val lng : Double
)
