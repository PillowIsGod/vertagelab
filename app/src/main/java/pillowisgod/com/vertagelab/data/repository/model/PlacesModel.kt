package pillowisgod.com.vertagelab.data.repository.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class PlacesModel(
    @SerializedName("places")
    val placesObj : List<PlaceResponse>
)
