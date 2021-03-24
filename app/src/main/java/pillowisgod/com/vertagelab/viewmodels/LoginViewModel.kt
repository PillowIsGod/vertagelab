package pillowisgod.com.vertagelab.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pillowisgod.com.vertagelab.data.database.LoginDAO
import pillowisgod.com.vertagelab.data.database.LoginData


class LoginViewModel : ViewModel() {
//    private var loginData = MutableLiveData<LoginData>()
//    val loginDataToUse : LiveData<LoginData> = loginData

     fun fetchDataToDB(dao : LoginDAO, email : String, password : String) {
         viewModelScope.launch {
             val loginData = LoginData(mail = email, password = password)
             withContext(Dispatchers.IO) {
                 val users = dao.getAll()
                 if(users.size > 0) {
                     dao.updatePassword2(loginData = LoginData(mail = loginData.mail,
                             password = loginData.password, id = users[0].id))
                 }
                 else {
                     dao.insertAll(loginData)
                 }


             }
         }
    }
}