import androidx.room.Room
import androidx.room.RoomDatabase
import common.database.AppDatabase
import org.koin.core.KoinApplication

actual fun getDatabaseBuilder(applicationContext: KoinApplication): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/my_room.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
        factory = { AppDatabase::class.instantiateImpl() }
    )
}