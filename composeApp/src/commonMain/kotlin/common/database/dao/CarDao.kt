package common.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import common.data.model.DataMoreCars
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Insert
    suspend fun insert(item: DataMoreCars)

    @Query("SELECT count(*) FROM DataMoreCars")
    suspend fun count(): Int

    @Query("SELECT * FROM DataMoreCars")
    fun getAllAsFlow(): Flow<List<DataMoreCars>>
}