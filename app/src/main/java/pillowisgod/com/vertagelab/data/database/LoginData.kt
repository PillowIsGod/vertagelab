package pillowisgod.com.vertagelab.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import pillowisgod.com.vertagelab.helpers.Constants.DATABASE_NAME
import java.util.*


@Entity(tableName = DATABASE_NAME)
data class LoginData (
        @PrimaryKey(autoGenerate = true) val id : Int = 0,
        @ColumnInfo(name = "mail") val mail : String,
        @ColumnInfo(name = "password") val password : String
        )