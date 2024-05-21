package common.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import common.data.model.DataEmployee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Insert
    suspend fun insert(item: DataEmployee)

    @Query("SELECT count(*) FROM DataEmployee")
    suspend fun count(): Int

    @Query("SELECT * FROM DataEmployee ORDER BY id DESC")
    fun getAllAsFlow(): Flow<List<DataEmployee>>

    @Query("DELETE FROM DataEmployee")
    suspend fun deleteAll()

    @Query("DELETE FROM DataEmployee WHERE id=:id")
    suspend fun deleteById(id: Int)
}