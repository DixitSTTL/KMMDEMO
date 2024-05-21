package common.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DataMoreCars")
data class DataMoreCars(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    var kms: String,
    var fule: String,
    var isEv: Boolean,
    var image: String
)
