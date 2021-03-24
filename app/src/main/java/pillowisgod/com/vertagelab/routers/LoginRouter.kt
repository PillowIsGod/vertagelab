package pillowisgod.com.vertagelab.routers

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pillowisgod.com.vertagelab.R

class LoginRouter(private val fragment : Fragment) {
    fun routeToMapFragment() {
        fragment
                .findNavController()
                .navigate(R.id.action_login_to_map)
    }
}