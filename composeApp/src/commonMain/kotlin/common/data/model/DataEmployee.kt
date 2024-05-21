package common.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DataEmployee")
data class DataEmployee(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    var department: String
)