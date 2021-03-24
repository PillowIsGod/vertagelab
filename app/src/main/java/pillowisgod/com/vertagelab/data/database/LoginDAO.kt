package pillowisgod.com.vertagelab.data.database

import android.util.Log
import androidx.room.*
import pillowisgod.com.vertagelab.helpers.Constants.DATABASE_NAME
import retrofit2.http.GET


@Dao
interface LoginDAO {
    @Query("SELECT * FROM $DATABASE_NAME")
    suspend fun getAll() : List<LoginData>
    @Query("DELETE FROM $DATABASE_NAME")
    suspend fun deleteAll()
    @Delete
    suspend fun deletePassword(passwordEntity: LoginData)
    @Insert
    suspend fun insertAll(vararg passwordEntity: LoginData)
    @Update
    suspend fun updatePassword2(loginData: LoginData)
}