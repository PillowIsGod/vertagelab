package pillowisgod.com.vertagelab.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*
import pillowisgod.com.vertagelab.R
import pillowisgod.com.vertagelab.data.repository.model.PlaceResponse

class PlacesAdapter : RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>() {

    private val data : MutableList<PlaceResponse> = ArrayList()

    class PlacesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val etListItem = itemView.findViewById<EditText>(R.id.etListItem)
        fun bind(placesResponse : PlaceResponse) {
            val string = "${placesResponse.id}. ${placesResponse.name}"
            etListItem.setText(string)
        }

    }
    fun setData(placesResponse : List<PlaceResponse>) {
        data.clear()
        data.addAll(placesResponse)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        return PlacesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}