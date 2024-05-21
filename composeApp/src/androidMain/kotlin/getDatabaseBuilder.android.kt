import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import common.database.AppDatabase
import org.koin.core.KoinApplication

actual fun getDatabaseBuilder(applicationContext: KoinApplication): RoomDatabase.Builder<AppDatabase> {
    val context: Context = applicationContext.koin.get()

    val dbFile = context.applicationContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = context,
        name = dbFile.absolutePath
    )
}