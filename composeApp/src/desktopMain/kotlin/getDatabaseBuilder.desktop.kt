import androidx.room.Room
import androidx.room.RoomDatabase
import common.database.AppDatabase
import org.koin.core.KoinApplication
import java.io.File
actual fun getDatabaseBuilder(applicationContext: KoinApplication): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    )
}