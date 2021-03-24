package pillowisgod.com.vertagelab.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_login.*
import pillowisgod.com.vertagelab.R
import pillowisgod.com.vertagelab.data.database.LoginDAO
import pillowisgod.com.vertagelab.routers.LoginRouter
import pillowisgod.com.vertagelab.viewmodels.LoginViewModel
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var loginRouter : LoginRouter
    private val viewModel : LoginViewModel by activityViewModels()
    @Inject lateinit var loginDAO : LoginDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginRouter = LoginRouter(fragment = this)

        btnLogin.setOnClickListener {
            if(loginAttempt()) {
                loginRouter.routeToMapFragment()
            }

        }
    }

    private fun loginAttempt() : Boolean {
        return if(etLogin.text.isNotEmpty() && etPassword.text.isNotEmpty()) {
            viewModel.fetchDataToDB(loginDAO, etLogin.text.toString(), etPassword.text.toString())
            true
        }
        else {
            Toast.makeText(context, R.string.empty_fields_error, Toast.LENGTH_LONG).show()
            false
        }
    }

}